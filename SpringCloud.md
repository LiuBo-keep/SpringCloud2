## 什么是服务治理
 Spring Cloud 封装了Netflix公司开发的Eureka模块来实现服务治理
 
 在传统的**rpc**远程调用框架中，管理每个服务与服务之间依赖关系比较复杂，管理比较复杂，所以需要使用服务治理
 ，管理服务于服务之间的依赖关系，可以实现服务调用，负载均衡，容错等，实现服务发现与注册。
 

## 什么是服务注册与发现
Eureka采用CS的设计框架，EurekaServer作为服务注册功能的服务器，它是服务注册中心。而系统中的其他微服务，
使用Eureka的客户端连接到EurekaServer并维持心跳连接。这样系统的维护人员就可以通过EurekaServer来监控
系统中的各个微服务是否正常运行。
在服务注册与发现中，有一个注册中心。当服务启动的时候，会把当前自己服务器的信息，比如服务地址通讯地址等
以别名方式注册到注册中心上，另一方(消费者|服务提供者)，以该别名的方式去注册中心上获取到实际的服务通讯地址
，然后在实现本地**rpc**调用**rpc**远程调用框架核心设计思想：在于注册中心，因为使用注册中心管理每个服务于
服务之间的一个依赖关系(服务治理概念)。在任何**rpc**远程框架中，都会有一个注册中心(存放服务地址相关信息[接口地址]) 

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200710234801615.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDcyMzk5,size_16,color_FFFFFF,t_70)

## Eureka包含两个组件：Eureka Sever 和Eureka Client
- EurekaServer提供服务注册服务
   各个微服务节点通过配置启动后，会在EurekaServer中进行注册，这样EurekaServer中的服务注册表中将会存储
   所有可用服务节点的信息，服务节点的信息可以在界面中直观看到
- EurekaClient通过注册中心进行访问
   是一个Java客户端，用于简化EurekaServer的交互，客户端同时也具备一个内置的，使用轮询负载算法的
   负载均衡器。在应用启动后，将会向EurekaServer发送心跳(默认周期为30s)。如果EurekaServer在多个
   心跳周期内没有接受到某个节点的心跳，EurekaServer将会从服务注册表中把这个服务节点移除(默认90s)
   
 ## 微服务注册名称配置说明
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200711001237999.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDcyMzk5,size_16,color_FFFFFF,t_70)
 
 
 ## 自我保护机制
 
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200711001348572.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDcyMzk5,size_16,color_FFFFFF,t_70)
 
- 故障现象：保护模式主要用于一组客户端和Eureka Server之间存在网络分区场景下的保护，一旦

进入保护模式，Eureka Server将会尝试保护其服务注册表中的信息，不再删除服务注册表中的数据，

也就是不会注销任何微服务。

- 导致原因：某时刻某一个微服务不可用了，Eureka不会立即清除，依旧会对微服务的信息进行保存

属于CAP里面的AP分支
       
- 什么是自我保护模式
默认情况下，如果Eureka Server在一定时间内没有接受到某个微服务实例的心跳，EurekaServer将

会注销该实例(默认90s)。但是是当网络分区故障发生(延时，卡顿，拥挤)时，微服务与EurekaServer

之间无法正常通信，以上行为可能变的非常危险--因为微服务本身其实是健康的，此时不应该注销这个

微服务。Eureka通过“自我保护模式”来解决这个问题---当EurekaServer节点在短时间内丢失过多客户

端时(可能发生了网络分区故障)，那么这个节点就会进入自我保护模式。 

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200712083645748.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDcyMzk5,size_16,color_FFFFFF,t_70)

- 关闭自我保护机制
    
 ```yml
 修改Eureka的配置
     #关闭自我保护机制，保证不可用服务被及时剔除
            eureka:
               server:
                 enable-self-preservation: false   #默认是true，开启的
                 eviction-interval-timer-in-ms: 2000   #将时间缩短
 ```      
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200712085241686.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDcyMzk5,size_16,color_FFFFFF,t_70)
       
```yml
修改服务端的配置

#默认
 eureka.instance.lease-renewal-interval-in-seconds=30 #单位为秒(默认为30s)
 eureka.instance.lease-expiration-duration-in-seconds=90 #单位为秒(默认为30s)
  
#修改
 #Eureka客户端服务端发送心跳的时间间隔，单位为秒(默认为30s)
 eureka.instance.lease-renewal-interval-in-seconds=1
 #Eureka服务端在收到最后一次心跳等待上限，单位为秒(默认为90s)，超时将剔除 
 eureka.instance.lease-expiration-duration-in-seconds=2
```

## Eureka集群原理说明
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200711143436580.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDcyMzk5,size_16,color_FFFFFF,t_70)

问题：微服务RPC远程服务调用最核心的是什么？
  高可用，试想你的注册中心只有一个，它出了故障，会导致整个微服务环境不可用。
  
解决方式：搭建Eureka 注册中心集群，实现负载均衡+故障容错         


---
## Consul 简介

 - 官网：https://www.consul.io/intro/index.html
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200714181234442.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDcyMzk5,size_16,color_FFFFFF,t_70)
 
 - 能干什么
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200714181542821.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDcyMzk5,size_16,color_FFFFFF,t_70)
 
 - 下载：https://www.consul.io/downloads.html
 
 - 中文官网：https://www.springcloud.cc/spring-cloud-consul.html
 
 - 官网安装说明：https://learn.hashicorp.com/consul/getting-started/install.html
 
 - 下载完成后只有一个consul.exe文件，硬盘路径下双击运行，查看版本号信息
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200714182704351.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDcyMzk5,size_16,color_FFFFFF,t_70)
 
 
 - 使用开发模式启动：1.consul agent -dev 2.通过以下地址可以访问Consul的首页：http://localhost:8500
 
 3.界面
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200714212201439.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDcyMzk5,size_16,color_FFFFFF,t_70)
 
 
 ## 三种注册中心的异同点
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200714223140139.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDcyMzk5,size_16,color_FFFFFF,t_70)
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200714223406412.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDcyMzk5,size_16,color_FFFFFF,t_70)



## Ribbon(负载均衡+RestTemplate)

- 是什么

Spring Cloud Ribbon 是基于Netflix Ribbon实现的一套客户端 负载均衡的工具

简单的说，Ribbon就是Netflix发布的开源项目，主要功能是提供客户端的软件负载均衡算法和服务调用。Ribbon客户端组件提供一系列
完善的配置项如连接超时，重试等。简单的说，就是在配置文件中列出Load Balancer(简称LB)后面所有的机器，Robbin会自动的帮助你
基于某种规则(如轮询，随机连接等)去连接这些机器。我们很容易使用Robbin实现自定义的负载均衡算法。

- 官网：https://github.com/Netflix/ribbon/wiki/Getting-Started

- 能干什么？

  1.LB(负载均衡)
  
      LB负载均衡(locad Balance)
      简单的说就是将用户的请求分摊到多个服务上，从而达到系统的HA(高可用)。
      常见的负载均衡有软件Nginx,LVS,硬件F5等
      
      Ribbon本地负载均衡客户端 VS Nginx服务端负载均衡区别：
      Nginx是服务器负载均衡，客户端所有请求都会交给Nginx，然后由Nginx实现
      转发请求，即负载均衡是由服务端实现的
      Ribbon本地负载均衡，在调用微服务接口的时候，会在注册中心上获取注册信
      息服务列表之后缓存到JVM本地，从而在本地实现RPC远程服务调用技术
      
     * 集中式LB
     
     * 进程内LB
- 架构说明
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200718153213733.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDcyMzk5,size_16,color_FFFFFF,t_70)

Ribbon在工作时分成两部
第一步先选择EurekaServer，他优先选择在同一个区域负载较少的Server

第二步再根据用户指定的策略，在从server取到的服务注册列表中选择一个地址

其中Ribbon提供了多种策略，比如轮询，随机和根据相应时间加权。     

- Ribbon核心组件IRule(IRule:根据特定算法中从服务列表中选取一个要访问的服务)
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020071816124226.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDcyMzk5,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200718161433692.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDcyMzk5,size_16,color_FFFFFF,t_70)

- 注意配置细节

      官方文档明确给出了警告：
      这个自定义配置类不能放在@ComponentScan所扫描的当前包下以及子包下
      否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，达不到特殊定制的目的了
      
- 默认负载轮询算法原理
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200718193505665.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMDcyMzk5,size_16,color_FFFFFF,t_70)      

 
          