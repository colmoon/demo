# 整体架构

Tomcat设计了两个核心组件连接器（Connector）和容器（Container）来分别做这 两件事情。连接器负责对外交流，容器负责内部处理。

![image-20220822111057276](Tomcat.assets/image-20220822111057276.png)

1） 处理Socket连接，负责网络字节流与Request和Response对象的转化。 

2） 加载和管理Servlet，以及具体处理Request请求。