package Generator.Pdf.generator.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddQuestionModel {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("statement")
    private String questionStatement;

    @JsonProperty("tag")
    private String questionTag;

    @JsonProperty("subject")
    private String subject;

}
