package kz.testcenter.app.appealent.model.publics;

import kz.testcenter.app.appealent.model.publics.embeddedid.StudentTestID;
import kz.testcenter.app.appealent.model.ref.Language;
import kz.testcenter.app.appealent.model.ref.TestServer;
import kz.testcenter.app.appealent.model.ref.TestType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_test", schema = "public")
public class StudentTest implements Serializable {

    private static final long serialVersionUID = -7915382198497283410L;

    // Сложный первичный ключ
    @EmbeddedId
    private StudentTestID studentTestID;

    // С какого сервера поступила аппеляция
    @MapsId("testServerId")
    @ManyToOne
    @JoinColumn(name = "test_server_id", nullable = false)
    private TestServer testServer;

    // Вид тестирования (ЕНТ, ПВО, НКТ и т.д.)
    @ManyToOne
    @JoinColumn(name = "test_type_id", nullable = false)
    private TestType testType;

    // Тестируемый
    @ManyToOne
    // Код тестируемого
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    // Номер потока тестирования
    @Column(name = "test_period_num", nullable = false)
    private Integer testPeriodNum;

    // Номер аудитории
    @Column(name = "audit_num", nullable = false)
    private Integer auditNum;

    // Номер места в аудитории
    @Column(name = "place_num", nullable = false)
    private Integer placeNum;

    // Пароль на начало тестирования
    @Column(name = "password", nullable = false)
    private String password;

    // Язык сдачи тестирования
    @ManyToOne
    @JoinColumn(name = "lang_id", nullable = false)
    private Language language;



    // Место тестирования
    // TODO: Найти/Создать таблицу "test_org" - место проведения тестирования или вводится вручную
    @Column(name = "test_org_id", nullable = false)
    private Integer testOrgId;



}
