package uxmaro.gabrielaquilarque.retrofit2;

/**
 * Created by gabrielaquilarque on 9/10/17.
 */

public class User {

    private Integer id;
    private String name;
    private String email;
    private int age;
    private String[] topics;
    // private String topics;

    public User (String name, String email, int age, String[] topics){
        this.name = name;
        this.email = email;
        this.age = age;
        this.topics = topics;
    }

    public Integer getId(){
        return id;
    }
    public String getName(){
        return name;
    }

}

