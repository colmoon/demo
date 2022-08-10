#### 问题

在编写一个group by的时候，同事说这样的写法在生产上是错误的，由于生产上的sql_mode设置了ONLY_FULL_GROUP_BY。之前见到过sql_mode的模式，但是没有重点了解过，借此机会正好整理一下。

#### 问题复现

这里使用网上的例子，更直观的了解group by可能的问题

id	name	age	dept
1	zhang3	33	101
2	li4	34	101
3	wang5	35	102
4	zhao6	36	102
5	tian7	37	102
查询语句select NAME,dept,MAX(age) from test group by dept
返回的结果是

name	age	dept
zhang3	34	101
wang5	37	102
此时会发现：查询结果中，dept和max(age) 是正确的，但是name却是错误的。因为34岁的101部门应该指向li4 ，37岁的102部门应该是tian7。

#### 问题分析

为什么很多网上的帖子会出现这个sql语句查询报错的情况
[Err] 1055 - Expression #1 of SELECT list is not in GROUP BY clause and contains nonaggregated column ‘test.name’ which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by

select list的表达式1不在group by子句中，并且包含非聚合列“test.name”，该列在功能上不依赖于group by子句中的列；这与sql _mode=only_full_group_by不兼容

如果抛出了上面的错误，那配置的sql_mode中一定包含 ONLY_FULL_GROUP_BY

可以通过show variables like 'sql_mode';查看

sql_mode介绍

在我们使用group by进行查询语句时，如果查询字段不在聚合列中(也就是group by后面的列)，实际上这种sql语句是错误的，也是没有意义的，mysql是可以不支持这种查询方式的。在我们生产境中，最好将sql_mode设置为严格模式，这样在开发阶段就能发现问题，排除错误、无效的sql语句。

ONLY_FULL_GROUP_BY就是规定了你不能使用错误、无效的group by去查询数据，所以，如果你的sql_mode是ONLY_FULL_GROUP_BY，那么执行上面那条sql语句就会抛出错误了。

为什么这种sql语句能执行但是查询结果不正确
因为sql_mode中没有配置only_full_group_by，一旦配置后，执行该语句就会报错。

#### sql_mode介绍

官网描述

The MySQL server can operate in different SQL modes, and can apply these modes differently for different clients, depending on the value of the sql_mode system variable. DBAs can set the global SQL mode to match site server operating requirements, and each application can set its session SQL mode to its own requirements.

mysql服务器可以在不同的SQL模式下运行，并且可以根据sql_模式系统变量的值，为不同的客户机应用这些模式。DBA可以设置全局SQL模式以匹配站点服务器操作需求，并且每个应用程序都可以将其会话SQL模式设置为自己的需求。

sql_mode是个很容易被忽视的变量，**默认值是空值**，在这种设置下是可以允许一些非法操作的，比如允许一些非法数据的插入。在生产环境必须将这个值设置为严格模式，所以开发、测试环境的数据库也必须要设置，这样在开发测试阶段就可以发现问题。

#### 查看方式

mysql数据库的中有一个环境变量sql_mode，定义了mysql应该支持的sql语法，数据校验等，我们可以通过以下方式查看当前数据库使用的sql_mode：

sql_mode的设置分为局部(session)设置和全局(global)设置。

session就是指你设置的sql_mode只会在你当前会话有效，当你注销用户，重新登录mysql后，仍然是你默认的sql_mode。

global就是指全局的。设置GLOBAL变量需要该SUPER权限，并影响从该时间开始连接的所有客户端的操作。设置SESSION变量仅影响当前客户端。每个客户端都可以随时更改其会话sql_mode值。

局部查询 select @@sql_mode; 或 show variables like 'sql_mode';
全局查询 select @@global.sql_mode; 或 show global variables like 'sql_mode';

#### 配置方式

修改my.ini文件
sql_mode修改
局部
去掉不想要的，例如ONLY_FULL_GROUP_BY等，重新设置
set sql_mode=‘NO_ZERO_DATE,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION’;

全局
使用select @@global.sql_mode;可以查看全局sql_mode的值

```sql
set @@global.sql_mode=‘NO_ZERO_DATE,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION’;
```

重新链接就OK啦

sql_mode类型介绍
官方说明5.7
官方说明8.0

sql_mode	描述
ONLY_FULL_GROUP_BY	对于GROUP BY聚合操作，如果在SELECT中的列，没有在GROUP BY中出现，那么将认为这个SQL是不合法的，因为列不在GROUP BY从句中。所以对于设置了这个mode的数据库，在使用group by 的时候，就要用MAX(),SUM(),ANT_VALUE()这种聚合函数，才能完成GROUP BY 的聚合操作。
NO_AUTO_VALUE_ON_ZERO	该值影响自增长列的插入。默认设置下，插入0或NULL代表生成下一个自增长值。如果用户希望插入的值为0，而该列又是自增长的，那么这个选项就有用了。
STRICT_TRANS_TABLES	在该模式下，如果一个值不能插入到一个事务表中，则中断当前的操作，对非事务表不做任何限制
NO_ZERO_IN_DATE	在严格模式，不接受月或日部分为0的日期。如果使用IGNORE选项，我们为类似的日期插入’0000-00-00’。在非严格模式，可以接受该日期，但会生成警告。
NO_ZERO_DATE	在严格模式，不要将 '0000-00-00’做为合法日期。你仍然可以用IGNORE选项插入零日期。在非严格模式，可以接受该日期，但会生成警告
ERROR_FOR_DIVISION_BY_ZERO	在严格模式，在INSERT或UPDATE过程中，如果被零除(或MOD(X，0))，则产生错误(否则为警告)。如果未给出该模式，被零除时MySQL返回NULL。如果用到INSERT IGNORE或UPDATE IGNORE中，MySQL生成被零除警告，但操作结果为NULL。
NO_AUTO_CREATE_USER	防止GRANT自动创建新用户，除非还指定了密码。
NO_ENGINE_SUBSTITUTION	如果需要的存储引擎被禁用或未编译，那么抛出错误。不设置此值时，用默认的存储引擎替代，并抛出一个异常。
PIPES_AS_CONCAT	将"||"视为字符串的连接操作符而非或运算符，这和Oracle数据库是一样的，也和字符串的拼接函数Concat相类似
ANSI_QUOTES	启用ANSI_QUOTES后，不能用双引号来引用字符串，因为它被解释为识别符
mysql5.0以上版本支持三种sql_mode模式

sql_mode	描述
ANSI模式	宽松模式，对插入数据进行校验，如果不符合定义类型或长度，对数据类型调整或截断保存，报warning警告。
TRADITIONAL模式	严格模式，当向mysql数据库插入数据时，进行数据的严格校验，保证错误数据不能插入，报error错误。用于事物时，会进行事物的回滚。
STRICT_TRANS_TABLES模式	严格模式，进行数据的严格校验，错误数据不能插入，报error错误。
总结
虽然mysql规定了这么多sql_mode用来约束sql语句规范，但是并不是每一个sql_mode都要配上，我们要在合适的环境选择合适的配置。

参考
MySQL的sql_mode模式
Mysql的sql_mode修改
由group by引发的sql_mode的学习
MySQL5.7官网文档

#### SQL UNION 操作符

UNION 操作符用于合并两个或多个 SELECT 语句的结果集。

请注意，UNION 内部的 SELECT 语句必须拥有相同数量的列。列也必须拥有相似的数据类型。同时，每条 SELECT 语句中的列的顺序必须相同。

UNION ALL 命令和 UNION 命令几乎是等效的，不过 UNION ALL 命令会列出所有的值。

#### group_concat()

1、功能：将group by产生的同一个分组中的值连接起来，返回一个字符串结果。

2、语法：group_concat( [distinct] 要连接的字段 [order by 排序字段 asc/desc ] [separator '分隔符'] )

说明：通过使用distinct可以排除重复值；如果希望对结果中的值进行排序，可以使用order by子句；separator是一个字符串值，缺省为一个逗号。