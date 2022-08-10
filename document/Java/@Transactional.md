# 一、作用于接口、接口方法、类以及类方法上

1️⃣当作用于类上时，该类的所有 public 方法将都具有该类型的事务属性。

2️⃣当作用在方法级别时会覆盖类级别的定义。

3️⃣当作用在接口和接口方法时则只有在使用[基于接口的代理](https://www.jianshu.com/p/0ce892b5ae5e)时它才会生效，也就是 JDK 动态代理，而不是 Cglib 代理。如果正在使用基于类的代理(也就是 CGLIB 代理)时，那么事务的设置将不能被基于类的代理所识别，而且对象也将不会被事务代理所包装，因为注解是不能继承的。
 `Spring 的建议是在具体的类(或类的方法)上使用 @Transactional 注解，而不要使用在类所要实现的任何接口上。`

4️⃣当在 [protected、private](https://www.jianshu.com/p/f981ad7b7726) 或者默认可见性的方法上使用 @Transactional 时是不会生效的，也不会抛出任何异常。

5️⃣默认情况下，只有来自外部的方法调用才会被 [AOP 代理](https://www.jianshu.com/p/0ce892b5ae5e)捕获，也就是，类内部方法调用本类内部的其他方法并不会引起事务行为，即使被调用方法使用 @Transactional 进行修饰。

原因：
spring 在扫描bean的时候会扫描方法上是否包含@Transactional注解，如果包含，spring会为这个bean动态地生成一个子类（即代理类，proxy），代理类是继承原来那个bean的。此时，当这个有注解的方法被调用的时候，实际上是由代理类来调用的，代理类在调用之前就会启动transaction。然而，如果这个有注解的方法是被同一个类中的其他方法调用的，那么该方法的调用并没有通过代理类，而是直接通过原来的那个bean，所以就不会启动transaction，我们看到的现象就是@Transactional注解无效

为什么一个方法a()调用同一个类中另外一个方法b()的时候，b()不是通过代理类来调用的呢？可以看下面的例子（为了简化，用伪代码表示）：

```java
@Service
class A{
    @Transactinal
    method b(){...}
    
    method a(){    //标记1
        b();
    }
}
 
//Spring扫描注解后，创建了另外一个代理类，并为有注解的方法插入一个startTransaction()方法：
class proxy$A{
    A objectA = new A();
    method b(){    //标记2
        startTransaction();
        objectA.b();
    }
 
    method a(){    //标记3
        objectA.a();    //由于a()没有注解，所以不会启动transaction，而是直接调用A的实例的a()方法
    }
}
```



当我们调用A的bean的a()方法的时候，也是被proxy$A拦截，执行proxy$A.a()（标记3），然而，由以上代码可知，这时候它调用的是objectA.a()，也就是由原来的bean来调用a()方法了，所以代码跑到了“标记1”。由此可见，“标记2”并没有被执行到，所以startTransaction()方法也没有运行。



# 二、@Transactional 配置事务失效的场景

1️⃣@Transactional 应用在非 public 修饰的方法上。
 注意：protected、private 修饰的方法上使用 @Transactional，虽然事务无效，但不会有任何报错。

2️⃣@Transactional 属性 propagation 设置错误。
 这种失效是由于配置错误，若是错误的配置以下三种 propagation，事务将不会发生回滚：
 ①`@Transactional(propagation=Propagation.SUPPORTS)`：如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。 ②`@Transactional(propagation=Propagation.NOT_SUPPORTED)`：以非事务方式运行，如果当前存在事务，则把当前事务挂起。
 ③`@Transactional(propagation=Propagation.NEVER)`：以非事务方式运行，如果当前存在事务，则抛出异常。

3️⃣@Transactional 属性 rollbackFor 设置错误。
 rollbackFor 可以指定能够触发事务回滚的异常类型。[Spring 默认抛出了未检查 unchecked 异常(继承自 RuntimeException 的异常)或者 Error 才回滚事务；其他异常不会触发回滚事务](https://www.jianshu.com/p/97fc15f6c668)。如果在事务中抛出其他类型的异常，但却期望 Spring 能够回滚事务，就需要指定 rollbackFor 属性。

4️⃣同一个类中方法调用，导致 @Transactional 失效。
 一个类 Test，它的方法 A(未声明注解事务)，调用本类的方法 B(声明有注解事务。不论是 public 的还是 private 的)。外部调用方法 A 之后，方法 B 的事务是不会起作用的。

5️⃣如果异常被`try{}catch{}`了，事务就不回滚。如果想让事务回滚必须再往外抛`try{}catch{throw new RunTimeException()}`。

如果 B 方法内部抛了异常，而 A 方法此时 try catch 了 B 方法的异常，该事务不能正常回滚。会抛出异常：



```css
org.springframework.transaction.UnexpectedRollbackException: 
Transaction rolled back because it has been marked as rollback-only
```

因为当 B 中抛出了一个异常以后，B 标识当前事务需要 rollback。但是由于 A 手动捕获该异常并进行处理，A 认为当前事务应该正常 commit。此时就出现了前后不一致，也就是因为这样，抛出了前面的`UnexpectedRollbackException`。

Spring 的事务是在调用业务方法之前开始的，业务方法执行完毕之后才执行 commit/rollback，事务是否执行取决于是否抛出 RuntimeException。如果抛出 RuntimeException，并在业务方法中没有 catch 的话，事务会回滚。

在业务方法中一般不需要 catch 异常，如果非要 catch 一定要`throw new RuntimeException()`，或者注解中指定抛异常类型`@Transactional(rollbackFor = Exception.class)`，否则会导致事务失效，数据 commit 造成数据不一致，所以有些时候 [try catch](https://www.jianshu.com/p/97fc15f6c668) 反倒会画蛇添足。

6️⃣[数据库引擎不支持事务](https://www.jianshu.com/p/1ed1c5319b09)
 事务能否生效，数据库引擎是否支持事务是关键。常用的 MySQL 数据库默认使用支持事务的 innodb 引擎。一旦数据库引擎切换成不支持事务的 MyISAM，那事务就从根本上失效了。

# 三、@Transactional 的可用参数

1️⃣readOnly
 该属性用于设置当前事务是否为只读事务，设置为 true 表示只读，false 则表示可读写，默认值为 false。

理解：
 如果一次执行单条查询语句，则没有必要启用事务支持，数据库默认支持 SQL 执行期间的读一致性。
 如果一次执行多条查询语句，例如统计查询，报表查询，在这种场景下，多条查询 SQL 必须保证整体的读一致性。否则，在前条 SQL 查询之后，后条 SQL 查询之前，数据被其他用户改变，则该次整体的统计查询将会出现读数据不一致的状态，此时，应该启用事务支持。
 【注意是一次执行多次查询来统计某些信息，这时为了保证数据整体的一致性，要用只读事务】

2️⃣rollbackFor
 该属性用于设置需要进行回滚的异常类数组，当方法中抛出指定异常数组中的异常时，则进行事务回滚。例如：

1. 指定单一异常类：`@Transactional(rollbackFor=RuntimeException.class)`
2. 指定多个异常类：`@Transactional(rollbackFor={RuntimeException.class,BusinessException.class})`

3️⃣rollbackForClassName
 该属性用于设置需要进行回滚的异常类名称数组，当方法中抛出指定异常名称数组中的异常时，则进行事务回滚。例如：

1. 指定单一异常类名称：`@Transactional(rollbackForClassName="RuntimeException")`
2. 指定多个异常类名称：`@Transactional(rollbackForClassName={"RuntimeException","BusnessException"})`

4️⃣noRollbackFor
 该属性用于设置不需要进行回滚的异常类数组，当方法中抛出指定异常数组中的异常时，不进行事务回滚。

5️⃣timeout
 该属性用于设置事务的超时秒数，默认值为 -1，表示永不超时。

6️⃣propagation
 该属性用于设置[事务传播行为](https://www.jianshu.com/p/df67740c1f4c)。例如：`@Transactional(propagation=Propagation.NOT_SUPPORTED)`

# 四、基于注解@Transactional的事务

Spring 的事务基础架构代码将默认地只在抛出 RuntimeException  和 unchecked exceptions 时才标识事务回滚。也就是说，当抛出 RuntimeException 或其子类例的实例时(error 也一样)默认标识事务回滚。从事务方法中抛出的 Checked exceptions 将不被标识进行事务回滚。

1️⃣@Transactional 的异常控制，默认是 unChecked Exception 回滚；Checked Exception 不回滚。
 2️⃣如果配置了rollbackFor 和 noRollbackFor 且两个都是用同样的异常，那么遇到该异常，还是回滚。
 3️⃣rollbackFor 和 noRollbackFor 配置也许不会涵盖所有异常，对于遗漏的按照 unChecked Exception 回滚，Check ed Exception 不回滚。
 4️⃣让 checked 例外也回滚：
 在整个方法前加上`@Transactional(rollbackFor=Exception.class)`
 5️⃣让 unchecked 例外不回滚：
 `@Transactional(notRollbackFor=RunTimeException.class)`
 6️⃣不需要事务管理的(只查询的)方法：
 `@Transactional(propagation=Propagation.NOT_SUPPORTED)`

注意：
 1️⃣@Transactional 标识的方法，处理过程尽量的简单。尤其是带锁的事务方法，能不放在事务里面的最好不要放在事务里面。可以将常规的数据库查询操作放在事务前面进行，而事务内进行增、删、改、加锁查询等操作。



```
1. TransactionDefinition.PROPAGATION_REQUIRED：
   如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。这是默认值。
 
2. TransactionDefinition.PROPAGATION_REQUIRES_NEW：
   创建一个新的事务，如果当前存在事务，则把当前事务挂起。
 
3. TransactionDefinition.PROPAGATION_SUPPORTS：
   如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
 
4. TransactionDefinition.PROPAGATION_NOT_SUPPORTED：
   以非事务方式运行，如果当前存在事务，则把当前事务挂起。
 
5. TransactionDefinition.PROPAGATION_NEVER：
   以非事务方式运行，如果当前存在事务，则抛出异常。
 
6. TransactionDefinition.PROPAGATION_MANDATORY：
   如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。
 
7. TransactionDefinition.PROPAGATION_NESTED：
   如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；
   如果当前没有事务，则该取值等价于TransactionDefinition.PROPAGATION_REQUIRED。
```



作者：日常更新
链接：https://www.jianshu.com/p/907a895587bf
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。