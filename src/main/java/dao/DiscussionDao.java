package dao;

import pojo.Discussion;

import java.sql.SQLException;
import java.util.List;

public interface DiscussionDao {
    void insertDiscussion(Discussion discussion);
    List<Discussion> selectByHotLimitAscend(Integer count);
    List<Discussion> selectByTimeLimitAscend(Integer count);
}
