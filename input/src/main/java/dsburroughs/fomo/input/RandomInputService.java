package dsburroughs.fomo.input;

import dsburroughs.fomo.common.service.FomoLevel;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by shanu on 11/20/2017.
 */
@Service
public class RandomInputService implements FomoInputService {

    private final int min = FomoLevel.NONE.getLevel();
    private final int max = FomoLevel.MAX.getLevel();
    private static final List<FomoLevel> VALUES =
            Collections.unmodifiableList(Arrays.asList(FomoLevel.values()));

    @Override
    public FomoLevel getLevel() {
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return VALUES.get(randomNum);
    }
}
