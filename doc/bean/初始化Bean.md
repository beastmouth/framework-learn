### 关于 Spring Bean 中多个Bean的注入问题
#### 倘若我在项目中初始化了两个Bean
```java
@Configuration
public class ApplicationConfig {
    /**
     * name 定义bean的名称
     */
    // 当有多个的时候 加入@Primary可以决定加载哪个
    @Primary
    @Bean(name = "personHbj")
    public Person initPerson() {
        Person user = new Person();
        user.setId(1L);
        user.setName("hbj");
        return user;
    }
}
```
```java
@Component("person")
public class Person {
    @Value("1")
    private Long id;
    @Value("hbj")
    private String name;
    @Autowired
    private Pet pet;
    // 省略getter setter
}
```
#### 假设没有加入第一段代码的 @Primary 则会报一个错误(因为定义了两个bean)
```java
Exception in thread "main" org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'com.narcos.frameworklearn.ioc.entity.Person' available: expected single matching bean but found 2: person,personHbj
```