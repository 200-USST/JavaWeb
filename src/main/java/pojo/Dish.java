package pojo;

public class Dish {
    private Integer dishId;
    private String dishName;
    private String dishClass;
    private Double dishPrice;
    private String dishInfo;
    private Integer dishCanteenId;
    private String dishPic;

    public String getDishPic() {
        return dishPic;
    }

    public Integer getDishCanteenId() {
        return dishCanteenId;
    }

    public void setDishCanteenId(Integer dishCanteenId) {
        this.dishCanteenId = dishCanteenId;
    }

    public Dish(Integer dishId, String dishName, String dishClass, Double dishPrice, String dishInfo, Integer dishCanteenId, String dishPic) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishClass = dishClass;
        this.dishPrice = dishPrice;
        this.dishInfo = dishInfo;
        this.dishCanteenId = dishCanteenId;
        this.dishPic = dishPic;
    }

    public void setDishPic(String dishPic) {
        this.dishPic = dishPic;
    }

    public Dish() {
    }


    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishClass() {
        return dishClass;
    }

    public void setDishClass(String dishClass) {
        this.dishClass = dishClass;
    }

    public Double getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(Double dishPrice) {
        this.dishPrice = dishPrice;
    }

    public String getDishInfo() {
        return dishInfo;
    }

    public void setDishInfo(String dishInfo) {
        this.dishInfo = dishInfo;
    }

}
