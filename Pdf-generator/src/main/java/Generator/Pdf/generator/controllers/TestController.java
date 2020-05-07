package Generator.Pdf.generator.controllers;

import Generator.Pdf.generator.models.AddQuestionModel;
import Generator.Pdf.generator.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/questions", method = RequestMethod.POST)
    public void addQuestions(@RequestBody List<AddQuestionModel> addQuestionModelsList) {
        questionService.addQuestionList(addQuestionModelsList);
    }
}
