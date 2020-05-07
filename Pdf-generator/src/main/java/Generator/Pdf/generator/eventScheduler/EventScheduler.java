package Generator.Pdf.generator.eventScheduler;

import Generator.Pdf.generator.models.QuestionInfo;
import Generator.Pdf.generator.models.entity.Question;
import Generator.Pdf.generator.models.entity.UserActivityEntity;
import Generator.Pdf.generator.repository.ActivityTableRepository;
import Generator.Pdf.generator.repository.QuestionTableRepository;
import Generator.Pdf.generator.util.PdfGenerator;
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

    @Autowired
    private QuestionTableRepository questionTableRepository;

    @Autowired
    private PdfGenerator pdfGenerator;

    @Scheduled(cron = "0 * * ? * *")
    public void pdfGenerator() {
        Timestamp time1 = new Timestamp(System.currentTimeMillis());
        Timestamp time2 = new Timestamp(System.currentTimeMillis() -  1*60 * 1000);
        List<UserActivityEntity> userActivityEntityList = activityTableRepository.findAllByEndTimeBetween(time2,time1);
        if(userActivityEntityList.size()>0) {
            pdfAsyncGenerator(userActivityEntityList);
        }else {
            System.out.println("Scheduler ran but didn't find any pdf generate condition true");
        }
    }

    public void pdfAsyncGenerator(List<UserActivityEntity> userActivityEntityList) {
        for(int i=0;i<userActivityEntityList.size();i++) {

            String statement = userActivityEntityList.get(i).getStatement();
            String subject = userActivityEntityList.get(i).getQuestionSubject();
            String tag = userActivityEntityList.get(i).getQuestionTag();
            List<Question> questionList = questionTableRepository.findAllByQuestionTagAndSubject(tag, subject);
            List<Question> questionList1 = new ArrayList<>();
            List<QuestionInfo> questionInfoList = new ArrayList<>();

            for(int k=0;k<questionList.size();k++){
                if(!questionList.get(k).getQuestionStatement().equals(statement)) {
                    questionList1.add(questionList.get(k));
                }
            }


            for (int index = 0; index < questionList1.size(); index++) {
                QuestionInfo questionInfo = new QuestionInfo();
                questionInfo.setQuestionStatement(questionList1.get(index).getQuestionStatement());
                questionInfo.setQuestionSubject(questionList1.get(index).getSubject());
                questionInfo.setQuestionTag(questionList1.get(index).getQuestionTag());
                questionInfoList.add(questionInfo);
            }

            pdfGenerator.generatePdf(questionInfoList,userActivityEntityList.get(i).getUserId());
        }
    }
}
