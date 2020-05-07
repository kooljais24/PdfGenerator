package Generator.Pdf.generator.controllers;

import Generator.Pdf.generator.models.UserActivityRequestModel;
import Generator.Pdf.generator.services.ActivateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    ActivateUserService activateUserService;

    @RequestMapping(value = "/create" , method = RequestMethod.POST)
    public void activateUser(@RequestBody UserActivityRequestModel userActivityRequestModel){
        activateUserService.activateUser(userActivityRequestModel);
    }

}
