package ntu.viet773092.th9_recylcerV_65134318;

public class LandScape {
    String landImageFileName;
    String landCaption;

    public LandScape(String landImageFileName, String landCaption) {
        this.landImageFileName = landImageFileName;
        this.landCaption = landCaption;
    }

    public String getLandImageFileName() {
        return landImageFileName;
    }

    public void setLandImageFileName(String landImageFileName) {
        this.landImageFileName = landImageFileName;
    }

    public String getLandCaption() {
        return landCaption;
    }

    public void setLandCaption(String landCaption) {
        this.landCaption = landCaption;
    }
}
