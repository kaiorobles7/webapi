package kaio.webapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    private String login;
    @Getter
    private String password;
    @Getter @Setter
    @ManyToOne
    private Setor setor;
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
                ",setor='" + setor + '\''  +
                '}';
    }

}
