package Generator.Pdf.generator.models.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "question")
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "statement")
    private String questionStatement;

    @Column(name = "tag")
    private String questionTag;

    @Column(name = "subject")
    private String subject;

}
