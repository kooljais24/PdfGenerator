package Generator.Pdf.generator.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String questionStatement;

    private String questionTag;

    private String subject;

}
