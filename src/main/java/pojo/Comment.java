package pojo;

public class Comment {
    private Integer commentID;
    private Integer discussionID;
    private Integer userID;
    private String username;
    private String content;

    public Comment() {
    }

    public Comment(Integer commentID, Integer discussionID, Integer userID, String username, String content) {
        this.commentID = commentID;
        this.discussionID = discussionID;
        this.userID = userID;
        this.username = username;
        this.content = content;
    }

    /**
     * 获取
     * @return commentID
     */
    public Integer getCommentID() {
        return commentID;
    }

    /**
     * 设置
     * @param commentID
     */
    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
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
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
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

    public String toString() {
        return "Comment{commentID = " + commentID + ", discussionID = " + discussionID + ", userID = " + userID + ", username = " + username + ", content = " + content + "}";
    }
}
