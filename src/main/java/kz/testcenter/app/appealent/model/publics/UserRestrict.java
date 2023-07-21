package kz.testcenter.app.appealent.model.publics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_restrict", schema = "public")
public class UserRestrict implements Serializable {

    private static final long serialVersionUID = -3665339599524645278L;

    // Порядковый номер записи в таблице
    @Id
    @SequenceGenerator(name = "user_restrict_id_seq", sequenceName = "user_restrict_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_restrict_id_seq")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    // ID Пользователя
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    // Тип модуля (тестирование, оператор и т.д.)
    @Column(name = "org_type_id", nullable = false)
    private Integer orgTypeId;

    // Организаяция (конкретное место тестирования или др.)
    @Column(name = "org_id")
    private Integer orgId;

    // Код роли
    @Column(name = "user_role_type_id", nullable = false)
    private Integer userRoleTypeId;

    // Разрешенные операции в пределах модуля
    @Type(type = "list-array")
    @Column(name = "user_permissions", columnDefinition = "smallint[]")
    private List<Integer> userPermissions;

    // Вид мероприятия (тестирования)
    @Column(name = "test_type_id", nullable = false)
    private Integer testTypeId;

}
