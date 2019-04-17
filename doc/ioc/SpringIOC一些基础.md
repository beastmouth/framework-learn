## Spring IOC 的一些基础
### Spring IOC 支持的功能
* 依赖注入
* 依赖检查
* 自动装配
* 支持集合
* 制定初始化方法和销毁方法
* 支持回调方法
### Spring IOC 的核心接口
* BeanFactory
* ApplicationContext
### BeanDefinition (主要用来描述Bean的定义 Spring 容器启动的时候，会将 Spring Bean 的定义解析成 BeanDefinition )
### BeanDefinitionRegistry（提供向IOC容器注册BeanDefinition对象的方法）
### BeanFactory
* 提供IOC的配置机制
* 包含Bean的各种定义，便于实例化Bean
* 建立Bean之间的依赖关系
* Bean生命周期的控制
[BeanFactory体系](../../images/ioc/BeanFactory体系.jpg)