package dao;

import pojo.Discussion;

import java.sql.SQLException;
import java.util.List;

public interface DiscussionDao {
    void insertDiscussion(Discussion discussion) throws SQLException;
    List<Discussion> selectByHotLimitAscend(Integer count) throws SQLException;
    List<Discussion> selectByTimeLimitAscend(Integer count) throws SQLException;
}
