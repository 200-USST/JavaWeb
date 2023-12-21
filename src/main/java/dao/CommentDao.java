package dao;

import pojo.Comment;

import java.sql.SQLException;
import java.util.List;


public interface CommentDao {
    void insertComment(Comment comment) throws SQLException;


    List<Comment> selectAllByCount(Integer count) throws SQLException;
}
