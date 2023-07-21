package kz.testcenter.app.appealent.model.ref;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "test_type_local_for_testing", schema = "ref")
public class TestType implements Serializable {

    private static final long serialVersionUID = -5987803723997916121L;

    @Id
    private Integer id;

    @Column(name = "name_kaz", nullable = false)
    private String nameKaz;

    @Column(name = "name_rus", nullable = false)
    private String nameRus;

    @Column(name = "short_name_kaz", nullable = false)
    private String shortNameKaz;

    @Column(name = "short_name_rus", nullable = false)
    private String shortNameRus;

}
