# SpringBoot 的启动流程
### 主要是初始化 SpringApplication -涉及- SpringApplicationRunListeners，ApplicationArguments（应用程序参数）,ConfigurableEnvironment(环境)，Banner(打印),context(上下文),exceptionReporters
##### StopWatch 观察 SpringBoot 项目的启动
##### SpringApplicationRunListeners
##### run方法中，加载了一系列SpringApplicationRunListener对象，在创建和更新ApplicationContext方法前后分别调用了listeners对象的started方法和finished方法, 
##### 并在创建和刷新ApplicationContext时，将listeners作为参数传递到了createAndRefreshContext方法中，以便在创建和刷新ApplicationContext的不同阶段，调用listeners的相应方法以执行操作。
##### 所以，所谓的SpringApplicationRunListeners实际上就是在SpringApplication对象的run方法执行的不同阶段，去执行一些操作，并且这些操作是可配置的。
```java
    private SpringApplicationRunListeners getRunListeners(String[] args) {
		Class<?>[] types = new Class<?>[] { SpringApplication.class, String[].class };
		return new SpringApplicationRunListeners(logger, getSpringFactoriesInstances(
				SpringApplicationRunListener.class, types, this, args));
	}
```
```java
	private <T> Collection<T> getSpringFactoriesInstances(Class<T> type,
    			Class<?>[] parameterTypes, Object... args) {
    		ClassLoader classLoader = getClassLoader();
    		// Use names and ensure unique to protect against duplicates
    		Set<String> names = new LinkedHashSet<>(
    				SpringFactoriesLoader.loadFactoryNames(type, classLoader));
    		List<T> instances = createSpringFactoriesInstances(type, parameterTypes,
    				classLoader, args, names);
    		AnnotationAwareOrderComparator.sort(instances);
    		return instances;
    	}
```
##### ApplicationArguments(设置应用程序参数)
```java
    ApplicationArguments applicationArguments = new DefaultApplicationArguments(
    					args);
```
##### ConfigurableEnvironment(准备环境)
```java
    ConfigurableEnvironment environment = prepareEnvironment(listeners,
					applicationArguments);
```
```java
    private ConfigurableEnvironment prepareEnvironment(
    			SpringApplicationRunListeners listeners,
    			ApplicationArguments applicationArguments) {
    		// Create and configure the environment
    		ConfigurableEnvironment environment = getOrCreateEnvironment();
    		configureEnvironment(environment, applicationArguments.getSourceArgs());
    		listeners.environmentPrepared(environment);
    		bindToSpringApplication(environment);
    		if (!this.isCustomEnvironment) {
    			environment = new EnvironmentConverter(getClassLoader())
    					.convertEnvironmentIfNecessary(environment, deduceEnvironmentClass());
    		}
    		ConfigurationPropertySources.attach(environment);
    		return environment;
    	}
```
#### !!!!!!重点 context 上下文!!!!!!
```java
    context = createApplicationContext();
```
```java
    protected ConfigurableApplicationContext createApplicationContext() {
        Class<?> contextClass = this.applicationContextClass;
        if (contextClass == null) {
            try {
                switch (this.webApplicationType) {
                case SERVLET:
                    contextClass = Class.forName(DEFAULT_SERVLET_WEB_CONTEXT_CLASS);
                    break;
                case REACTIVE:
                    contextClass = Class.forName(DEFAULT_REACTIVE_WEB_CONTEXT_CLASS);
                    break;
                default:
                    contextClass = Class.forName(DEFAULT_CONTEXT_CLASS);
                }
            }
            catch (ClassNotFoundException ex) {
                throw new IllegalStateException(
                        "Unable create a default ApplicationContext, "
                                + "please specify an ApplicationContextClass",
                        ex);
            }
        }
        return (ConfigurableApplicationContext) BeanUtils.instantiateClass(contextClass);
    }
```
##### 准备好上下文后要刷新上下文
```java
    refreshContext(context);
    afterRefresh(context, applicationArguments);
```
#### 重点在 refreshContext 此处涉及到 Bean 的初始化
