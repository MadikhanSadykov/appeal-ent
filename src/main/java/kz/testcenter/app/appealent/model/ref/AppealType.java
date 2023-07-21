package kz.testcenter.app.appealent.model.ref;

import kz.testcenter.app.appealent.model.publics.Appeal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appeal_type", schema = "ref")
public class AppealType implements Serializable {

    private static final long serialVersionUID = -2017431249124890275L;

    @Id
    private Integer id;

    @Column(name = "name_kaz", nullable = false)
    private String nameKaz;

    @Column(name = "name_rus", nullable = false)
    private String nameRus;

    @OneToMany(mappedBy = "appealType")
    private List<Appeal> appeals = new ArrayList<>();
}
