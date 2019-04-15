package client;

import java.io.Serializable;

/**
 *
 */
public class RequestBean implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    //可以放任何类型的数据
    private String name;
    private String password;

    /**
     *
     */
    public RequestBean() {

    }

    /**
     * @param name
     * @param password
     */
    public RequestBean(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
