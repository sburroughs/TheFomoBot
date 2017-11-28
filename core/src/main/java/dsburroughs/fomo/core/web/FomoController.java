package dsburroughs.fomo.core.web;

import dsburroughs.fomo.core.FomoProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sburroughs on 10/11/2017.
 */
@RestController
public class FomoController {

    @Autowired
    private FomoProcessingService processor;

    @RequestMapping("/fomo")
    private String getFomoLevel(){
        processor.process();

        final String in = processor.getInputService().getClass().getName();
        final String out = processor.getOutputService().getClass().getName();
        final String message = String.format(
                "Processing Successful: %s -> %s", in, out
        );
        return message;

    }



}
