package org.example;

import static org.junit.Assert.assertTrue;

import org.example.config.SpringConfig;
import org.example.vo.Cat;
import org.example.vo.Student;
import org.example.vo.Tiger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {


    @Test
    public void startTest() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Student ming = (Student) ctx.getBean("myStudent");
        System.out.println(ming);
    }

    @Test
    public void testBeanAnno() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Student student = (Student) ctx.getBean("myStudent2");
        System.out.println(student);
    }

    @Test
    public void testMyCat() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Cat cat = (Cat) ctx.getBean("myCat");
        System.out.println(cat);
    }

    @Test
    public void testTiger() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Tiger tiger = (Tiger) ctx.getBean("tiger");
        System.out.println(tiger);
    }


}
