# GetBean 方法解析
### 方法：AbstractBeanFactory的doGetBean方法：
##### 1.转化bean的名称	
![image1](../images/getBeanImages/getBean-image1.png)
##### 2.通过getSingleton获取实例
#####   * 获取到的话 则取获取对应的bean实例（获取方法：从缓存中获取或者从bean工厂中获取）
![image2](../images/getBeanImages/getBean-image2.png)
![image3](../images/getBeanImages/getBean-image3.png)
#####   * 获取不到则从ParentBeanFactory中获取
![image4](../images/getBeanImages/getBean-image4.png)
##### 3.获取bean的定义（递归）
![image5](../images/getBeanImages/getBean-image5.png)
##### 4.检查bean的作用域 来决定创建bean的情况
![image6](../images/getBeanImages/getBean-image6.png)
![image7](../images/getBeanImages/getBean-image7.png)
##### 5.检验创建的bean类型是否符合需要的实例 是的话就返回
![image8](../images/getBeanImages/getBean-image8.png)
##### getBean 全流程
![image9](../images/getBeanImages/getBean-image9.jpg)