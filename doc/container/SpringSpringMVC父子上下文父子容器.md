### SpringSpringMVC父子上下文/父子容器

#### 笔记地址：[简书](https://www.jianshu.com/p/2977ea5ce0fc)

##### 例子：

- 在SSM配置中，Spring管理除了Controller以外的Bean，SpringMVC管理Controller
- 在SpringCloud中，Ribbon和Feign的配置类Spring官方建议放到启动类扫不到的包下

Spring的配置：application.xml

```xml
    <context:component-scan base-package="org.bc.redis" use-default-filters="true">
        <!-- 排除含@Controller注解的类 -->
        <context:exclude-filter type="annotation" expression="com.learn.controller"/>
    </context:component-scan>
```

SpringMVC的配置：springmvc.xml

```xml
    <!--  只扫描含@Controller注解的包,避免重复扫描 -->
    <context:component-scan base-package="com.learn.controller" use-default-filters="true">
    </context:component-scan>
```

如果扫描重叠的话，则会出现以下几种情况：

- 扫描的类增多，项目启动的时间变慢
- @PostConstruct注解标注的方法被执行两次
- 会使Spring配置的事务失效（Spring是父容器，先初始化，SpringMVC是子容器，后初始化。子容器可以访问父容器的bean，父容器不能访问子容器的bean，当SpringMVC初始化时，它会将已经在父容器中的service等重新初始化一次，而SpringMVC不支持事务）

