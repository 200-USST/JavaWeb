package pojo;

import java.io.Serializable;

public class Canteen implements Serializable {
    private Integer canteenId;
    private String canteenName;
    private String canteenLocation;
    private String canteenAbstract;

    public Canteen(Integer canteenId, String canteenName, String canteenLocation, String canteenAbstract) {
        this.canteenId = canteenId;
        this.canteenName = canteenName;
        this.canteenLocation = canteenLocation;
        this.canteenAbstract = canteenAbstract;
    }

    public Canteen() {
    }

    public Integer getCanteenId() {
        return canteenId;
    }

    public void setCanteenId(Integer canteenId) {
        this.canteenId = canteenId;
    }

    public String getCanteenName() {
        return canteenName;
    }

    public void setCanteenName(String canteenName) {
        this.canteenName = canteenName;
    }

    public String getCanteenLocation() {
        return canteenLocation;
    }

    public void setCanteenLocation(String canteenLocation) {
        this.canteenLocation = canteenLocation;
    }

    public String getCanteenAbstract() {
        return canteenAbstract;
    }

    public void setCanteenAbstract(String canteenAbstract) {
        this.canteenAbstract = canteenAbstract;
    }
}
