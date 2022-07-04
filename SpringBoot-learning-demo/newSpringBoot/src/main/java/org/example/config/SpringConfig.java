package org.example.config;

import org.example.vo.Student;
import org.springframework.context.annotation.*;


/**
* '@Configuration:表示当前类作为配置文件使用，用来配置容器
* 位置：在类上面
* 此时这个类就相当于beans.xml文件
* 可以使用数组导入多个配置文件
*/
@Configuration
@ImportResource({"classpath:applicationContext.xml", "classpath:beans.xml"})
@PropertySource(value = "classpath:config.properties", encoding = "UTF-8")
@ComponentScan("org.example.vo")
public class SpringConfig {
    /*
     * 创建方法，方法的返回值是对象，在方法的上面加入@Bean
     * 方法的返回值对象就注入到容器中
     * 作用相当于<bean>
     * 不指定对象名称时：默认是方法名
     * 指定对象名称时：
     * */
    @Bean
    public Student createStudent(){
        Student student = new Student();
        student.setName("张三");
        student.setAge(30);
        student.setSex("男");
        return student;
    }

    @Bean("myStudent2")
    public Student createStudent2(){
        Student student = new Student();
        student.setName("张三三");
        student.setAge(30);
        student.setSex("男");
        return student;
    }
}
