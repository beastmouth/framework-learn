### AOP 介绍
#### AOP 的主要名词概念
* Aspect : 通用功能的代码实现 
* Target : 被织入Aspect的对象（例如：com.narcos.frameworklearn.controller 包中的 HelloController）
* Join Point : 可以作为切入点的机会，所有方法都可以作为切入点（例如 sayHello 方法）
* Pointcut : Aspect实际被应用在的Join Point，支持正则（Spring支持的切入点就是方法调用）
* Advice : 类（切面的那个类）里的方法以及这个方法如何织入到目标方法的方式
* Weaving : Aop的实现过程 
#### AOP 中 Advice的种类
* 前置通知 : Before（在方法调用之前调用通知）
* 后置通知 : AfterReturning（在方法执行成功之后调用通知）
* 异常通知 ：AfterThrowing（在方法抛出异常后进行通知）
* 最终通知 ：After（在方法完成之后调用通知，无论方法执行成功与否）
* 环绕通知 ：Around（通知包裹了被通知的方法，在被通知的方法调用之前和调用之后执行自定义的行为）
#### AOP 的实现（JdkProxy 和 Cglib）
##### 由 AopProxyFactory 根据 AdvisedSupport 对象的配置来决定
##### 默认策略 ：如果目标类是接口，则使用 JDKProxy（JDK 动态代理技术） 来实现，否则用后者（JDKProxy 利用 JAVA 的反射原理）
##### JDKProxy的核心：InvocationHandler 接口和 Proxy 类（要求目标类必须实现一个接口）
##### Cglib ：（目标类未实现接口 例如：com.narcos.frameworklearn.controller 的 HelloController）则通过继承的方式（如果某个类被标记成 final 则无法继承，同样无法使用 Cglib 实现动态代理）动态生成目标类的代理（通过修改字节码的方式实现代理的）
##### JDKProxy ：通过 JAVA 内部的反射机制实现
##### Cglib ：借助 ASM（能操作字节码的框架） 实现
##### ·反射机制在生成类的过程中比较高效
##### ·ASM 在生成类之后比较高效（所以可以将 ASM 生成类进行缓存，来解决低效问题）
#### 代理模式 ：接口 + 真实实现类（实现接口） + 代理类（实现接口）
#### Spring 里的代理模式的实现
##### 真实实现类的逻辑包含在了 getBean 方法里（所以需要 Spring 管理）
##### getBean 方法返回的实际上是 Proxy 的实例
##### Proxy 实例是 Spring 采用 JDK Proxy 或 CGLIB 动态生成的

#### 生成动态代理的主流程
##### AbstractBeanFactory
##### doGetBean
##### AbstractAutowireCapableBeanFactory
##### doCreateBean 里面 initializeBean
##### initializeBean 里面 applyBeanPostProcessorsAfterInitialization
##### applyBeanPostProcessorsAfterInitialization 里面 postProcessAfterInitialization
##### AbstractAutoProxyCreator 
##### postProcessAfterInitialization 里面 wrapIfNecessary 
##### wrapIfNecessary 里面 createProxy
##### createProxy 里面 proxyFactory.getProxy(getProxyClassLoader())
##### ProxyFactory 里面 getProxy
##### getProxy 里面 createAopProxy().getProxy(classLoader);
##### createAopProxy ：生成 proxy
```java
        @Override
	public AopProxy createAopProxy(AdvisedSupport config) throws AopConfigException {
		if (config.isOptimize() || config.isProxyTargetClass() || hasNoUserSuppliedProxyInterfaces(config)) {
			Class<?> targetClass = config.getTargetClass();
			if (targetClass == null) {
				throw new AopConfigException("TargetSource cannot determine target class: " +
						"Either an interface or a target is required for proxy creation.");
			}
			if (targetClass.isInterface() || Proxy.isProxyClass(targetClass)) {
				return new JdkDynamicAopProxy(config);
			}
			return new ObjenesisCglibAopProxy(config);
		}
		else {
			return new JdkDynamicAopProxy(config);
		}
	}
```