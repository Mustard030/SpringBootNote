package org.example.vo;

public class Student {
    private String sex;
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Student{" +
                "sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}