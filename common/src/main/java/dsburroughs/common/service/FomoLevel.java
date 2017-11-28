package dsburroughs.common.service;

/**
 * Created by Sburroughs on 10/11/2017.
 */
public enum FomoLevel {

    NONE(0), LOW(1), MEDIUM(2), HIGH(3), ULTRA(4), MAX(5);

    private int level;

    FomoLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

}
