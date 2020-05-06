package Generator.Pdf.generator.models.entity;

import Generator.Pdf.generator.models.QuestionInfo;
import Generator.Pdf.generator.models.UserActivityRequestModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "user_activity")
@Data
public class UserActivityEntity {

    @Id
    private Integer userId;

    private Timestamp startTime;

    private Timestamp endTime;

    private String statement;

    private String questionTag;

    private String questionSubject;



}
