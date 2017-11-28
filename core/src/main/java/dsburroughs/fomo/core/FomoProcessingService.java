package dsburroughs.fomo.core;

import dsburroughs.fomo.FomoOutputService;
import dsburroughs.fomo.input.FomoInputService;

/**
 * Created by Sburroughs on 10/13/2017.
 */
public interface FomoProcessingService {
    void process();

    FomoInputService getInputService();

    FomoOutputService getOutputService();
}
