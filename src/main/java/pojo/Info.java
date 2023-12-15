package pojo;

public class Info {
    private Boolean flag;
    private String description;

    public Info() {
    }

    public Info(Boolean flag, String description) {
        this.flag = flag;
        this.description = description;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
