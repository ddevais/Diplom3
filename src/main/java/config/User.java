package config;

import org.apache.commons.lang3.RandomStringUtils;

public class User {
    private String name;
    private String password;
    private String email;

    public User(String email, String password, String name){
        this.email = email;
        this.name = name;
        this.password = password;
    }
    public User(){}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public static User getRandomRegister(){
        return new User(
                RandomStringUtils.randomAlphanumeric(10) + "@ya.ru",
                "11111111",
                RandomStringUtils.randomAlphanumeric(10)
        );
    }
}
