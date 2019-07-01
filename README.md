### Immanuel

一个无服务器(serverless)架构基础应用;基于`spring-boot/kotlin`,使用`groovy`作为脚本语言;
目前已经支持`动态脚本`/`动态声明式路由`/`声明式事务`/`动态Bean注入`

### Principal
* 脚本即服务(script as a service)
* 数据即代码(data is code)

### Feature

#### 动态脚本

支持多种方式加载脚本(github/resource/api/database)  
[__WIP__]脚本支持多种语言 java/node/python/dsl etc.  

#### 声明式路由

使用[Api](https://github.com/iotaki/immanuel/blob/master/src/main/kotlin/com/theoxao/base/common/annotations/Api.kt)注解
groovy ast transform(下称GAT) 阶段会将路由信息保存到脚本属性中,后续会根据这些属性注册路由
ps: 当使用http接口调用方式加载脚本时, Api注解中的信息会覆盖api传参的信息 

#### 声明式事务

使用[Transactional](https://github.com/iotaki/immanuel/blob/master/src/main/kotlin/com/theoxao/base/common/annotations/Transactional.kt)注解
GAT阶段会将带Transactional注解的方法使用try-catch包装, 同时定义事务管理器;后续依赖注入时再注入事务管理器对象;流程与spring-aop类似

#### 依赖注入

使用[Autowired](https://github.com/iotaki/immanuel/blob/master/src/main/kotlin/com/theoxao/base/common/annotations/Autowired.kt)
GAT会将需要DI的成员打上标签; 后续DI阶段再注入


### RoadMap






