package Generator.Pdf.generator.services;

import Generator.Pdf.generator.constants.Constants;
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
            //the endtime has been set as per requirement of the interval of inactivity we need to check
            entity.setEndTime(new Timestamp(System.currentTimeMillis() + Constants.inactivityInterval));
            entity.setQuestionTag(userActivityRequestModel.getQuestionTag());
            entity.setQuestionSubject(userActivityRequestModel.getQuestionSubject());
            entity.setStatement(userActivityRequestModel.getQuestionStatement());
            activityTableRepository.save(entity);
            System.out.println("New Activity happened with entity: "+entity);
        }
        else{
            userActivityEntity.setStartTime(new Timestamp(System.currentTimeMillis()));
            //the endtime has been set as per requirement of the interval of inactivity we need to check
            userActivityEntity.setEndTime(new Timestamp(System.currentTimeMillis() + Constants.inactivityInterval));
            userActivityEntity.setQuestionTag(userActivityRequestModel.getQuestionTag());
            userActivityEntity.setQuestionSubject(userActivityRequestModel.getQuestionSubject());
            userActivityEntity.setStatement(userActivityRequestModel.getQuestionStatement());
            activityTableRepository.save(userActivityEntity);
            System.out.println("Active user Activity happened with entity: "+userActivityEntity);
        }
    }
}
