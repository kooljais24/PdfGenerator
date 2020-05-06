package Generator.Pdf.generator.eventScheduler;

import Generator.Pdf.generator.models.QuestionInfo;
import Generator.Pdf.generator.models.UserActivityRequestModel;
import Generator.Pdf.generator.models.entity.UserActivityEntity;
import Generator.Pdf.generator.repository.ActivityTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class EventScheduler {

    @Autowired
    private ActivityTableRepository activityTableRepository;

    @Scheduled(cron = "0 * * ? * *")
    public void pdfGenerator() {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        List<UserActivityEntity> userActivityEntityList = activityTableRepository.findAllByEndTimeIsLessThanEqual(time);
        List<QuestionInfo> questionInfoList = new ArrayList<>();

        for(int index =0;index<userActivityEntityList.size();index++){
            QuestionInfo questionInfo = new QuestionInfo();
            questionInfo.setQuestionStatement(userActivityEntityList.get(index).getStatement());
            questionInfo.setQuestionSubject(userActivityEntityList.get(index).getQuestionSubject());
            questionInfo.setQuestionTag(userActivityEntityList.get(index).getQuestionTag());
            questionInfoList.add(questionInfo);
        }
//        System.out.println("check...");




    }
}
