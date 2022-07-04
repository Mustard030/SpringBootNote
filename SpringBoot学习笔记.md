# SpringBoot学习笔记

# 第一章

1. 为什么要使用SpringBoot

   spring、springmvc需要使用大量的配置文件（xml）

   好需要配置各种对象，把各种的对象放入到spring容器中才能使用对象

   需要了解其他框架的配置规则

2. SpringBoot相当于不需要配置文件的Spring+SpringMVC。常用的框架和第三方的库都配置好了

3. SpringBoot开发效率高，使用方便



## 1. Xml和JavaConfig

Spring使用xml作为容器配置文件，在3.0之后加入了JavaConfig。使用java类做配置文件使用



### 1.1 什么是JavaConfig

JavaConfig：是Spring提供的使用java类配置容器。配置SpringIOC容器的纯Java方法。

**优点：**

1. 可以使用面向对象的方式，一个可以继承配置类，可以重写方法
2. 避免繁琐的xml配置

使用两个注解：

1. @Configuration：放在类的上面，表示这个类作为配置文件使用
2. @Bean：声明对象，把对象注入到容器中

```java
/**
* '@Configuration:表示当前类作为配置文件使用，用来配置容器
* 位置：在类上面
* 此时这个类就相当于beans.xml文件
*/
@Configuration
public class SpringConfig {
    /*
     * 创建方法，方法的返回值是对象，在方法的上面加入@Bean
     * 方法的返回值对象就注入到容器中
     * 作用相当于<bean>
     * 不指定对象名称时：默认是方法名
     * */
    @Bean
    public Student createStudent(){
        Student student = new Student();
        student.setName("张三");
        student.setAge(30);
        student.setSex("男");
        return student;
    }

    @Bean("myStudent")
    public Student createStudent2(){
        Student student = new Student();
        student.setName("张三三");
        student.setAge(30);
        student.setSex("男");
        return student;
    }
}

```



### 1.2 @ImportResource

@ImportResource作用是导入已存在的xml配置文件，等于xml中的\<import>标签

```xml
<import	resource="其他配置文件" />
```

例如：

```java
@Configuration
@ImportResource({"classpath:applicationContext.xml", "classpath:beans.xml"})
public class SpringConfig {}
```



### 1.3 @PropertyResource

@PropertyResource：读取properties属性配置文件，使用属性配置文件可以实现外部化配置，在程序之外提供数据



# 第二章 SpringBoot

## 1. 创建Spring Boot项目

1.1 第一种方式，使用Spring提供的初始化器，就是向导创建SpringBoot应用

使用的地址：https://start.spring.io

1.2 第二种方式使用的spring官方提供的国内地址：https://start.springboot.io



### @SpringBootApplication

```java
@SpringBootApplication是一个复合注解，由三个注解组成
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
在@SpringBootConfiguration里又有：
@Configuration  (<-配置文件注解，在Application中声明对象，能注入到容器中)
@Indexed
public @interface SpringBootConfiguration {
    @AliasFor(
        annotation = Configuration.class
    )
    boolean proxyBeanMethods() default true;
}


```



@EnableAutoConfiguration

自动把java对象配置好，注入到容器中，例如Mybatis对象



@ComponentScan

组件扫描器，找到注解，并创建对象

默认扫描的包是@ComponentScan所在的类和所在的包和子包

