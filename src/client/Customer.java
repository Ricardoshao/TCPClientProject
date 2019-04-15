package client;

import java.io.Serializable;

public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    public String name;
    public int age;
    public Customer(String name,int age){
        this.name = name;
        this.age = age;
    }

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

}
