package Generator.Pdf.generator.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionInfo {

    private String questionStatement;

    private String questionTag;

    private String questionSubject;
}
