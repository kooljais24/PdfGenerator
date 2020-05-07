package Generator.Pdf.generator.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserActivityRequestModel {

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("statement")
    private String questionStatement;

    @JsonProperty("tag")
    private String questionTag;

    @JsonProperty("subject")
    private String questionSubject;
}
