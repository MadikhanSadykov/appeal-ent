package kz.testcenter.app.appealent.model.ref;

import kz.testcenter.app.appealent.model.publics.StudentTest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lang_local_for_testing", schema = "ref")
public class Language implements Serializable {

    private static final long serialVersionUID = -4934528654695742624L;

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

    // Показывать / Не показывать - smallint - 0 по умолчанию
    @Column(name = "row_status_id", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean rowStatusId;

    @OneToMany(mappedBy = "language")
    private List<StudentTest> studentTests = new ArrayList<>();

}
