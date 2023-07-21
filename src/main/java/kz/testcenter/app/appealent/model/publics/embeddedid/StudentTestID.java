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
public class StudentTestID implements Serializable {

    private static final long serialVersionUID = 5967663540029340978L;

    // Код записи
    private Integer id;

    private Integer testServerId;

}
