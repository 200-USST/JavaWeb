package dao.mapper;

import pojo.Comment;

import java.util.List;


public interface CommentMapper {
    void insertComment(Comment comment);


    List<Comment> selectAllByCount(Integer count);
}
