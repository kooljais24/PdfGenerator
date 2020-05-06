package Generator.Pdf.generator.controllers;

import Generator.Pdf.generator.models.UserActivityRequestModel;
import Generator.Pdf.generator.services.ActivateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    ActivateUserService activateUserService;

    @RequestMapping("/create")
    public void activateUser(@RequestBody UserActivityRequestModel userActivityRequestModel){
        activateUserService.activateUser(userActivityRequestModel);
    }
}
