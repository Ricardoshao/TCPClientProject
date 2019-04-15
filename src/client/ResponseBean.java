package client;

import java.io.Serializable;

/**
 *
 */
public class ResponseBean implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String pwd;
    private int age;
    private String sex;
    /**
     *
     */
    public ResponseBean() {

    }
    /**
     * @param id
     * @param name
     * @param pwd
     * @param age
     * @param sex
     */
    public ResponseBean(int id, String name, String pwd, int age, String sex) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.age = age;
        this.sex = sex;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPwd() {
        return this.pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
}
