package aa;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 8683452581334592189L;
    private String name;
    private int age;
    private int score;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "name:" + name + " age:" + age + " score:" + score;
    }




}
