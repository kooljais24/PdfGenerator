package Generator.Pdf.generator.services;

import Generator.Pdf.generator.models.AddQuestionModel;
import Generator.Pdf.generator.models.entity.Question;
import Generator.Pdf.generator.repository.QuestionTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {


    @Autowired
    private QuestionTableRepository questionTableRepository;



    public void addQuestionList(List<AddQuestionModel> questionModelList) {

        for(int index =0; index<questionModelList.size(); index++){
            Question questionEntity = new Question();
            questionEntity.setQuestionStatement(questionModelList.get(index).getQuestionStatement());
            questionEntity.setQuestionTag(questionModelList.get(index).getQuestionTag());
            questionEntity.setSubject(questionModelList.get(index).getSubject());
            questionEntity.setId(questionModelList.get(index).getId());
            questionTableRepository.save(questionEntity);
        }
        System.out.println("questions has been added");
    }
}
