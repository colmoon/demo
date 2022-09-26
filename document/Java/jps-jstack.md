# jps

JVM Process Status Tool，显示指定系统内所有的HotSpot虚拟机进程。

功能： 显示当前所有java进程pid的命令，我们可以通过这个命令来查看到底启动了几个java进程（因为每一个java程序都会独占一个java虚拟机实例）。

缺点： 不过jps有个缺点是只能显示当前用户的进程id，要显示其他用户的还只能用linux的ps命令。

| 参数 | 说明                            |
| ---- | ------------------------------- |
| `-l` | 输出主类全名或jar路径           |
| `-q` | 只输出LVMID                     |
| `-m` | 输出JVM启动时传递给main()的参数 |
| `-v` | 输出JVM启动时显示指定的JVM参数  |

> 其中 `[option]`、`[hostid]` 参数也可以不写。

```shell
root@localhost:/# jps -lv
7 soar-web-start-2.2.0-SNAPSHOT.jar -XX:MetaspaceSize=256m -XX:MaxMetaspaceSize=256m -Xms5g -Xmx5g -Xmn1g -Xss512k -XX:SurvivorRatio=8 -XX:ParallelGCThreads=4 -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:+UseConcMarkSweepGC -XX:+CMSScavengeBeforeRemark -XX:+HeapDumpOnOutOfMemoryError -XX:+UseCMSInitiatingOccupancyOnly -XX:+ScavengeBeforeFullGC -XX:+CMSParallelRemarkEnabled -XX:CMSInitiatingOccupancyFraction=70 -XX:+CMSClassUnloadingEnabled -XX:+ExplicitGCInvokesConcurrent -Dfile.encoding=UTF8 -Duser.timezone=GMT+08 -Dfastjson.parser.safeMode=true

```

# jstack

jstack是JVM自带的Java堆栈跟踪工具，它用于打印出给定的java进程ID、core file、远程调试服务的Java堆栈信息.

**jstack** [option] <**pid**>  *// 打印某个进程的堆栈信息*

| 选项 | 作用                                                         |
| ---- | ------------------------------------------------------------ |
| -F   | 当正常输出的请求不被响应时，强制输出线程堆栈                 |
| -m   | 如果调用到本地方法的话，可以显示C/C++的堆栈                  |
| -l   | 除堆栈外，显示关于锁的附加信息，在发生死锁时可以用jstack -l pid来观察锁持有情况 |

## 如何用如何用jstack排查死锁问题

```shell
root@localhost:/# jstack -l 7
2022-09-19 11:10:19
Full thread dump OpenJDK 64-Bit Server VM (25.275-b01 mixed mode):

"process reaper" #118557 daemon prio=10 os_prio=0 tid=0x00007f24b0085000 nid=0x723c waiting on condition [0x00007f24a0046000]
   java.lang.Thread.State: TIMED_WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
        - parking to wait for  <0x00000006f6ff6608> (a java.util.concurrent.SynchronousQueue$TransferStack)
        at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
        at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
        at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
        at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
        at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1073)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1134)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
        at java.lang.Thread.run(Thread.java:748)

   Locked ownable synchronizers:
        - None

```



## 分析CPU过高问题

步骤

- 1. top
- 2. top -Hp pid （shift+p 按cpu排序，shift+m 按内存排序） 
- 3. jstack pid (找到cpu最高的pid，用printf ‘%x\n’ pid 转换为[16进制](https://so.csdn.net/so/search?q=16进制&spm=1001.2101.3001.7020))
- 4. jstack -l [PID] >/tmp/log.txt
- 5. 分析堆栈信息

1、用ps -ef | [grep](https://so.csdn.net/so/search?q=grep&spm=1001.2101.3001.7020) tomcat-v3 查出tomcat运行的进程id 
![这里写图片描述](jps-jstack.assets/20160711175137284)
2、用top -Hp pid 查询进程下所有线程的运行情况（shift+p 按cpu排序，shift+m 按内存排序） 
top -Hp 30316 
![这里写图片描述](jps-jstack.assets/20160711175601506) 
3、找到cpu最高的pid，用printf ‘%x\n’ pid 转换为[16进制](https://so.csdn.net/so/search?q=16进制&spm=1001.2101.3001.7020) 
printf ‘%x\n’ 30506 
![这里写图片描述](jps-jstack.assets/20160711180026533) 
4、用jstack 进程id | grep 16进制线程id 找到线程信息 
jstack 30316 | grep -A 20 772a 
![这里写图片描述](jps-jstack.assets/20160711180311022) 



grep

 -A NUM，--after-context=NUM

除了列出符合行之外，并且列出后NUM行。

# jstat

jstat利用JVM内建的指令对Java应用程序的资源和性能进行实时的命令行的监控，包括了对进程的classloader，compiler，gc情况；

jstat命令格式

jstat -< option > [-t] [-h] < vmid > [< interval > [< count >]]

option 选项详解

class 显示classLoader 相关信息
compiler 显示 JIT 编译相关信息
gc 显示与 GC 相关堆信息
gccapacity 显示各个代的容量以及使用情况
gccause 显示垃圾收集相关信息，最后一次垃圾回收的原因
gcnew 显示新生代信息
gcnewcapacity 显示新生代使用情况
gcold 显示老年代和永久的信息
gcoldcapacity 显示老年代的大小
gcpermcapactiy 显示永久代的大小
gcutil 显示垃圾收集信息
printcompilation 输出 JIT 编译的方法信息

-t 参数详解
参数可以在输出信息前面加上一个 Timestamp 列，显示程序运行的时间

-h 参数详解
参数可以周期数据输出时，输出多少行后，跟着输出一个表头信息

interval 参数详解
指定输出统计数据的周期，单位毫秒

count 参数详解
一共输出多少次数据

# jmap

`jmap`命令是JDK中提供的一个用来监视进程运行中的JVM物理内存的占用情况的工具。该进程内存内，所有对象的情况，例如产生了哪些对象，对象数量。当系统崩溃时，jmap可以从core文件或进程中获得内存的具体匹配情况，包括`Heap size`、`Perm size`等。

jmap命令格式

jmap [option] < pid >

查看一下jmap命令的帮助信息

```shell
root@localhost:/# jmap -help
Usage:
    jmap [option] <pid>
        (to connect to running process)
    jmap [option] <executable <core>
        (to connect to a core file)
    jmap [option] [server_id@]<remote server IP or hostname>
        (to connect to remote debug server)

where <option> is one of:
    <none>               to print same info as Solaris pmap
    -heap                to print java heap summary
    -histo[:live]        to print histogram of java object heap; if the "live"
                         suboption is specified, only count live objects
    -clstats             to print class loader statistics
    -finalizerinfo       to print information on objects awaiting finalization
    -dump:<dump-options> to dump java heap in hprof binary format
                         dump-options:
                           live         dump only live objects; if not specified,
                                        all objects in the heap are dumped.
                           format=b     binary format
                           file=<file>  dump heap to <file>
                         Example: jmap -dump:live,format=b,file=heap.bin <pid>
    -F                   force. Use with -dump:<dump-options> <pid> or -histo
                         to force a heap dump or histogram when <pid> does not
                         respond. The "live" suboption is not supported
                         in this mode.
    -h | -help           to print this help message
    -J<flag>             to pass <flag> directly to the runtime system

```



参数：

option： 选项参数
pid： 需要打印配置信息的进程ID
executable： 产生核心dump的Java可执行文件
core： 需要打印配置信息的核心文件
server-id 可选的唯一id，如果相同的远程主机上运行了多台调试服务器，用此选项参数标识服务器
remote server IP or hostname 远程调试服务器的IP地址或主机名
这些参数里面一般使用option和pid即可

option：

no option： 查看进程的内存映像信息，类似Solaris pmap命令
heap： 显示Java堆详细信息
histo[:live]： 显示堆中对象的统计信息
clstats：打印类加载器信息
finalizerinfo： 显示在F-Queue队列等待Finalizer线程执行finalizer方法的对象
dump:：生成堆转储快照
F： 当-dump没有响应时，使用-dump或者-histo参数。在这个模式下，live子参数无效
help：打印帮助信息
J：指定传递给运行jmap的JVM的参数



# jinfo

观察进程运行环境参数，包括Java System属性和JVM命令行参数



内存泄漏排查

使用jmap -heap pid命令查看Java进程堆内存使用情况
使用jstat -gc pid命令查看Java进程堆和gc情况
使用jmap -dump:format=b,file=heapdump.phrof pid命令，dump下当前Java进程的内存快照
使用jstack pid命令，dump下当前Java进程的线程快照。
根据报错信息判断是堆内存溢出还是方法区溢出
