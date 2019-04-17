# SpringBoot 的启动流程
### 主要是初始化 SpringApplication -涉及- SpringApplicationRunListeners，ApplicationArguments（应用程序参数）,ConfigurableEnvironment(环境)，Banner(打印),context(上下文),exceptionReporters
### 主要用到的几个类：**SpringApplication.java,AbstractApplicationContext.java,DefaultListableBeanFactory.java,AbstractBeanFactory.java**
### 重点的看 **上下文的注册和刷新（ createApplicationContext ），Bean的初始化（ finishBeanFactoryInitialization ）**
\===========================================================================================
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
                // 根据不同的 webApplicationType 来选择不同的上下文
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
#### 重点在 refreshContext 此处涉及到 Bean 的初始化 （一路点下去 到达 AbstractApplicationContext 的refresh方法）
##### 流程：准备好上下文 --》 准备bean工厂 --》 处理bean工厂 --》 注册bean工厂（作为beans）到上下文中 --》 将消息来源之类的内容注册到bean工厂中 --》 完成bean工厂的初始化（此处任何一步出异常都要销毁原来已经注册的bean）
```java
    @Override
	public void refresh() throws BeansException, IllegalStateException {
		synchronized (this.startupShutdownMonitor) {
			// Prepare this context for refreshing.
			prepareRefresh();

			// Tell the subclass to refresh the internal bean factory.
			ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();

			// Prepare the bean factory for use in this context.
			prepareBeanFactory(beanFactory);

			try {
				// Allows post-processing of the bean factory in context subclasses.
				postProcessBeanFactory(beanFactory);

				// Invoke factory processors registered as beans in the context.
				invokeBeanFactoryPostProcessors(beanFactory);

				// Register bean processors that intercept bean creation.
				registerBeanPostProcessors(beanFactory);

				// Initialize message source for this context.
				initMessageSource();

				// Initialize event multicaster for this context.
				initApplicationEventMulticaster();

				// Initialize other special beans in specific context subclasses.
				onRefresh();

				// Check for listener beans and register them.
				registerListeners();

				// Instantiate all remaining (non-lazy-init) singletons.
				finishBeanFactoryInitialization(beanFactory);

				// Last step: publish corresponding event.
				finishRefresh();
			}

			catch (BeansException ex) {
				if (logger.isWarnEnabled()) {
					logger.warn("Exception encountered during context initialization - " +
							"cancelling refresh attempt: " + ex);
				}

				// Destroy already created singletons to avoid dangling resources.
				destroyBeans();

				// Reset 'active' flag.
				cancelRefresh(ex);

				// Propagate exception to caller.
				throw ex;
			}

			finally {
				// Reset common introspection caches in Spring's core, since we
				// might not ever need metadata for singleton beans anymore...
				resetCommonCaches();
			}
		}
	}
```
##### 在完成bean工厂的初始化这个方法 finishBeanFactoryInitialization 这里会把bean实例和属性注入 进入该方法的最后一行
```java
    // Instantiate all remaining (non-lazy-init) singletons.
    beanFactory.preInstantiateSingletons();
```
```java
    // 来自上一步的 preInstantiateSingletons 方法里面
    RootBeanDefinition bd = getMergedLocalBeanDefinition(beanName);
```
```java
    protected RootBeanDefinition getMergedLocalBeanDefinition(String beanName) throws BeansException {
		// Quick check on the concurrent map first, with minimal locking.
		// 先看原来有没有注册过 如果有的话直接使用
		RootBeanDefinition mbd = this.mergedBeanDefinitions.get(beanName);
		if (mbd != null) {
			return mbd;
		}
		return getMergedBeanDefinition(beanName, getBeanDefinition(beanName));
	}
```
```java
    protected RootBeanDefinition getMergedBeanDefinition(String beanName, BeanDefinition bd)
			throws BeanDefinitionStoreException {

		return getMergedBeanDefinition(beanName, bd, null);
	}
```
```java
    protected RootBeanDefinition getMergedBeanDefinition(
            String beanName, BeanDefinition bd, @Nullable BeanDefinition containingBd)
            throws BeanDefinitionStoreException {
    
        synchronized (this.mergedBeanDefinitions) {
            RootBeanDefinition mbd = null;
    
            // Check with full lock now in order to enforce the same merged instance.
            // 进入 synchronized 方法 再拿一次 如果这时候已经被别人注册进去的话 就可以拿到
            // 否则肯定没有注册进去
            if (containingBd == null) {
                mbd = this.mergedBeanDefinitions.get(beanName);
            }
    
            // 需要跟父bean扯上关系 未仔细看
            if (mbd == null) {
                if (bd.getParentName() == null) {
                    // Use copy of given root bean definition.
                    if (bd instanceof RootBeanDefinition) {
                        mbd = ((RootBeanDefinition) bd).cloneBeanDefinition();
                    }
                    else {
                        mbd = new RootBeanDefinition(bd);
                    }
                }
                else {
                    // Child bean definition: needs to be merged with parent.
                    BeanDefinition pbd;
                    try {
                        String parentBeanName = transformedBeanName(bd.getParentName());
                        if (!beanName.equals(parentBeanName)) {
                            pbd = getMergedBeanDefinition(parentBeanName);
                        }
                        else {
                            BeanFactory parent = getParentBeanFactory();
                            if (parent instanceof ConfigurableBeanFactory) {
                                pbd = ((ConfigurableBeanFactory) parent).getMergedBeanDefinition(parentBeanName);
                            }
                            else {
                                throw new NoSuchBeanDefinitionException(parentBeanName,
                                        "Parent name '" + parentBeanName + "' is equal to bean name '" + beanName +
                                        "': cannot be resolved without an AbstractBeanFactory parent");
                            }
                        }
                    }
                    catch (NoSuchBeanDefinitionException ex) {
                        throw new BeanDefinitionStoreException(bd.getResourceDescription(), beanName,
                                "Could not resolve parent bean definition '" + bd.getParentName() + "'", ex);
                    }
                    // Deep copy with overridden values.
                    mbd = new RootBeanDefinition(pbd);
                    mbd.overrideFrom(bd);
                }
    
                // Set default singleton scope, if not configured before.
                if (!StringUtils.hasLength(mbd.getScope())) {
                    mbd.setScope(RootBeanDefinition.SCOPE_SINGLETON);
                }
    
                // A bean contained in a non-singleton bean cannot be a singleton itself.
                // Let's correct this on the fly here, since this might be the result of
                // parent-child merging for the outer bean, in which case the original inner bean
                // definition will not have inherited the merged outer bean's singleton status.
                if (containingBd != null && !containingBd.isSingleton() && mbd.isSingleton()) {
                    mbd.setScope(containingBd.getScope());
                }
    
                // Cache the merged bean definition for the time being
                // (it might still get re-merged later on in order to pick up metadata changes)
                if (containingBd == null && isCacheBeanMetadata()) {
                    // 放进 map 中 以便下一次使用 无需重新注册
                    this.mergedBeanDefinitions.put(beanName, mbd);
                }
            }
    
            return mbd;
        }
	}
```