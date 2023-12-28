package pojo;

import java.util.Date;

public class Discussion {
    private Integer discussionID;
    private String title;
    private Date time;
    private Integer userID;
    private String userName;
    private String content;
    private String imagePath;
    private Integer dishID;
    private Integer thumbs;

    public Discussion() {
    }

    public Discussion(Integer discussionID, String title, Date time, Integer userID, String userName, String content, String imagePath, Integer dishID, Integer thumbs) {
        this.discussionID = discussionID;
        this.title = title;
        this.time = time;
        this.userID = userID;
        this.userName = userName;
        this.content = content;
        this.imagePath = imagePath;
        this.dishID = dishID;
        this.thumbs = thumbs;
    }

    /**
     * 获取
     * @return discussionID
     */
    public Integer getDiscussionID() {
        return discussionID;
    }

    /**
     * 设置
     * @param discussionID
     */
    public void setDiscussionID(Integer discussionID) {
        this.discussionID = discussionID;
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
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
     * @return imagePath
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * 设置
     * @param imagePath
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * 获取
     * @return dishID
     */
    public Integer getDishID() {
        return dishID;
    }

    /**
     * 设置
     * @param dishID
     */
    public void setDishID(Integer dishID) {
        this.dishID = dishID;
    }

    /**
     * 获取
     * @return thumbs
     */
    public Integer getThumbs() {
        return thumbs;
    }

    /**
     * 设置
     * @param thumbs
     */
    public void setThumbs(Integer thumbs) {
        this.thumbs = thumbs;
    }

    public String toString() {
        return "Discussion{discussionID = " + discussionID + ", title = " + title + ", time = " + time + ", userID = " + userID + ", userName = " + userName + ", content = " + content + ", imagePath = " + imagePath + ", dishID = " + dishID + ", thumbs = " + thumbs + "}";
    }
}
