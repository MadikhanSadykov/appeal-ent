package kz.testcenter.app.appealent.model.ref;

import kz.testcenter.app.appealent.model.publics.Appeal;
import kz.testcenter.app.appealent.model.publics.StudentTest;
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
@Table(name = "test_server", schema = "ref")
public class TestServer implements Serializable {

    private static final long serialVersionUID = -6512979593349784726L;

    @Id
    private Integer id;

    @Column(name = "name_kaz", nullable = false)
    private String nameKaz;

    @Column(name = "name_rus", nullable = false)
    private String nameRus;

    @OneToMany(mappedBy = "testServer")
    private List<Appeal> appeals = new ArrayList<>();

    @OneToMany(mappedBy = "testServer")
    private List<StudentTest> studentTests = new ArrayList<>();
}
