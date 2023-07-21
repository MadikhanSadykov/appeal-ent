package kz.testcenter.app.appealent.model.publics;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"studentTests"})
@EqualsAndHashCode
@Table(name = "user", schema = "public")
public class User implements Serializable {

    private static final long serialVersionUID = 5542744031216835921L;

    // ID пользователя
    @Id
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    // Имя пользователя для входа
    @Column(name = "login", nullable = false, unique = true)
    private String login;

    // Имя пользователя для отображения
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    // Текущий статус пользователя
    @Column(name = "user_status_type_id", nullable = false)
    private Integer userStatusTypId;

    // Пароль на вход
    @Column(name = "password", nullable = false)
    private String password;

    // Дата время добавления пользователя
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @OneToMany(mappedBy = "student")
    private List<StudentTest> studentTests = new ArrayList<>();

}
