package kz.testcenter.app.appealent.model.publics;

import kz.testcenter.app.appealent.model.publics.embeddedid.AppealID;
import kz.testcenter.app.appealent.model.ref.AppealType;
import kz.testcenter.app.appealent.model.ref.TestServer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

// Заявление на апплляцию по техническим причинам
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appeal", schema = "public")
public class Appeal implements Serializable {

    private static final long serialVersionUID = -576193034562922744L;

    // Сложный первичный ключ
    @EmbeddedId
    private AppealID appealId;

    // С какого сервера поступила аппеляция
    @MapsId("testServerId")
    @ManyToOne
    @JoinColumn(name = "test_server_id", nullable = false)
    private TestServer testServer;

    // Вид аппеляции
    @MapsId("appealTypeId")
    @ManyToOne
    @JoinColumn(name = "appeal_type_id", nullable = false)
    private AppealType appealType;



}
