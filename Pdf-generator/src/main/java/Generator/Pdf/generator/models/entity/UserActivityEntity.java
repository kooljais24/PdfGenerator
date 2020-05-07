package Generator.Pdf.generator.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_activity")
@Data
public class UserActivityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "end_time")
    private Timestamp endTime;

    @Column(name = "statement")
    private String statement;

    @Column(name = "question_tag")
    private String questionTag;

    @Column(name = "question_subject")
    private String questionSubject;



}
