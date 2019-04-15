package threadtest;

import java.io.Serializable;

public class BeanTest implements Serializable {
    private static final long serialVersionUID = 1L;

    public String name;
    public int age;
    public BeanTest(String name, int age){
        this.name=name;
        this.age=age;
    }
}
