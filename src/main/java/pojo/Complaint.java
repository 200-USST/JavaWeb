package pojo;

import java.util.Date;

public class Complaint {
    private Integer complaintID;
    private Integer userID;
    private String title;
    private String content;
    private Date time;
    private Boolean handleStatus;

    public Complaint() {
    }

    public Complaint(Integer complaintID, Integer userID, String title, String content, Date time, Boolean handleStatus) {
        this.complaintID = complaintID;
        this.userID = userID;
        this.title = title;
        this.content = content;
        this.time = time;
        this.handleStatus = handleStatus;
    }

    /**
     * 获取
     * @return complaintID
     */
    public Integer getComplaintID() {
        return complaintID;
    }

    /**
     * 设置
     * @param complaintID
     */
    public void setComplaintID(Integer complaintID) {
        this.complaintID = complaintID;
    }

    /**
     * 获取
     * @return userID
     */
    public Integer getUserID() {
        return userID;
    }

    /**
     * 设置
     * @param userID
     */
    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    /**
     * 获取
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取
     * @return time
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置
     * @param time
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取
     * @return handleStatus
     */
    public Boolean getHandleStatus() {
        return handleStatus;
    }

    /**
     * 设置
     * @param handleStatus
     */
    public void setHandleStatus(Boolean handleStatus) {
        this.handleStatus = handleStatus;
    }

    public String toString() {
        return "Complaint{complaintID = " + complaintID + ", userID = " + userID + ", title = " + title + ", content = " + content + ", time = " + time + ", handleStatus = " + handleStatus + "}";
    }
}
