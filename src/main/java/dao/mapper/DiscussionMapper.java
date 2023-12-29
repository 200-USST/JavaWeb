package dao.mapper;

import pojo.Discussion;

import java.sql.SQLException;
import java.util.List;

public interface DiscussionMapper {
    void insertDiscussion(Discussion discussion) throws SQLException;
    List<Discussion> selectByHotLimitAscend(Integer count) throws SQLException;
    List<Discussion> selectByTimeLimitAscend(Integer count) throws SQLException;
    void deleteByID(Integer id) throws SQLException;
    List<Discussion> selectAll() throws SQLException;

}
