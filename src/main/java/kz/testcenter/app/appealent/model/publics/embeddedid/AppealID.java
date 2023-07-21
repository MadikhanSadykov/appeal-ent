package kz.testcenter.app.appealent.model.publics.embeddedid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppealID implements Serializable {

    private static final long serialVersionUID = 1776812457268911399L;

    // Код записи
    private Integer id;

    private Integer appealTypeId;

    private Integer testServerId;

}
