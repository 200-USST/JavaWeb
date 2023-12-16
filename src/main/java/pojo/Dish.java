package pojo;

public class Dish {
    private String dishName;
    private String dishClass;
    private double dishPrice;
    private String dishInfo;
    private String dishCanteen;

    public Dish() {
    }

    public Dish(String dishName, String dishClass, double dishPrice, String dishInfo, String dishCanteen) {
        this.dishName = dishName;
        this.dishClass = dishClass;
        this.dishPrice = dishPrice;
        this.dishInfo = dishInfo;
        this.dishCanteen = dishCanteen;
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

    public double getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(double dishPrice) {
        this.dishPrice = dishPrice;
    }

    public String getDishInfo() {
        return dishInfo;
    }

    public void setDishInfo(String dishInfo) {
        this.dishInfo = dishInfo;
    }

    public String getDishCanteen() {
        return dishCanteen;
    }

    public void setDishCanteen(String dishCanteen) {
        this.dishCanteen = dishCanteen;
    }
}
