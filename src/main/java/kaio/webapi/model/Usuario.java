package kaio.webapi.model;

import lombok.Getter;

public class Usuario {
    @Getter
    private Integer id;
    @Getter
    private String login;
    @Getter
    private String password;
    public Usuario() {}
    public Usuario(String login, String password) {
        this.login = login;
        this.password = password;
    }
    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
