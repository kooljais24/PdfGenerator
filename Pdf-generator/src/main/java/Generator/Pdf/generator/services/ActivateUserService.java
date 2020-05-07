package Generator.Pdf.generator.services;

import Generator.Pdf.generator.models.UserActivityRequestModel;
import Generator.Pdf.generator.models.entity.UserActivityEntity;
import Generator.Pdf.generator.repository.ActivityTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ActivateUserService {

    @Autowired
    private ActivityTableRepository activityTableRepository;

    public void activateUser(UserActivityRequestModel userActivityRequestModel){
        UserActivityEntity userActivityEntity =
                activityTableRepository.findByUserId(userActivityRequestModel.getUserId());
        if(userActivityEntity==null) {
            UserActivityEntity entity = new UserActivityEntity();
            entity.setStartTime(new Timestamp(System.currentTimeMillis()));
            entity.setEndTime(new Timestamp(System.currentTimeMillis() + 2 * 60 * 1000));
            entity.setQuestionTag(userActivityRequestModel.getQuestionTag());
            entity.setQuestionSubject(userActivityRequestModel.getQuestionSubject());
            entity.setStatement(userActivityRequestModel.getQuestionStatement());
            activityTableRepository.save(entity);
            System.out.println("New Activity happened with entity: "+entity);
        }
        else{
            userActivityEntity.setStartTime(new Timestamp(System.currentTimeMillis()));
            userActivityEntity.setEndTime(new Timestamp(System.currentTimeMillis() + 2 * 60 * 1000));
            userActivityEntity.setQuestionTag(userActivityRequestModel.getQuestionTag());
            userActivityEntity.setQuestionSubject(userActivityRequestModel.getQuestionSubject());
            userActivityEntity.setStatement(userActivityRequestModel.getQuestionStatement());
            activityTableRepository.save(userActivityEntity);
            System.out.println("Active user Activity happened with entity: "+userActivityEntity);
        }
    }
}
