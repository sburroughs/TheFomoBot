package dsburroughs.fomo.web;

import dsburroughs.fomo.service.FomoLevelProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sburroughs on 10/11/2017.
 */
@RestController
public class FomoController {

    @Autowired
    private FomoLevelProcessor processor;

    @RequestMapping("/fomo")
    private String getFomoLevel(){
        processor.process();
        return "FUCK YEAH. fomo";

    }



}
