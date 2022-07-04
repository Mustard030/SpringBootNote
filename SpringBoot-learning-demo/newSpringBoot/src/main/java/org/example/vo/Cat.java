package org.example.vo;

public class Cat {
    private String cardId;
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Cat{" +
                "cardId=" + cardId +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String catId) {
        this.cardId = catId;
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
