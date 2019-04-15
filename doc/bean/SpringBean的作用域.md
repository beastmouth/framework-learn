# Spring Bean 的作用域
##### singleton：Spring的默认作用域，容器里拥有唯一的Bean实例
##### prototype：针对每个getBean请求，容器都会创建一个Bean（此时要注意创建bean的性能消耗）
### 如果是 web 容器的话，还有三种作用域
##### request：会为每个Http请求创建一个Bean实例
##### session：会为每个session创建一个Bean实例
##### globalSession：会为每个全局Http Session创建一个Bean实例，该作用域仅对Portlet有效（Portlet容器-MVCPortlet）