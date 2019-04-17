# SpringBoot 的启动流程
### 主要是初始化 SpringApplication 对象的成员变量 listeners,sources,webEnvironment,initializers,mainApplicationClass
```java
private SpringApplicationRunListeners getRunListeners(String[] args) {
		Class<?>[] types = new Class<?>[] { SpringApplication.class, String[].class };
		return new SpringApplicationRunListeners(logger, getSpringFactoriesInstances(
				SpringApplicationRunListener.class, types, this, args));
	}
```