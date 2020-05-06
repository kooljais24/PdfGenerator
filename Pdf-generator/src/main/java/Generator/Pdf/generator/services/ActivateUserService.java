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
            entity.setUserId(userActivityRequestModel.getUserId());
            entity.setStartTime(new Timestamp(System.currentTimeMillis()));
            entity.setEndTime(new Timestamp(System.currentTimeMillis() + 5 * 60 * 1000));
            entity.setQuestionTag(userActivityRequestModel.getQuestionInfo().getQuestionTag());
            entity.setQuestionSubject(userActivityRequestModel.getQuestionInfo().getQuestionSubject());
            entity.setStatement(userActivityRequestModel.getQuestionInfo().getQuestionStatement());
            activityTableRepository.save(entity);
        }
        else{
            userActivityEntity.setStartTime(new Timestamp(System.currentTimeMillis()));
            userActivityEntity.setEndTime(new Timestamp(System.currentTimeMillis() + 5 * 60 * 1000));
            activityTableRepository.save(userActivityEntity);
        }
    }
}
