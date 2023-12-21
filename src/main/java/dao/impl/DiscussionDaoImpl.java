package dao.impl;

import dao.DiscussionDao;
import pojo.Discussion;

import java.sql.SQLException;
import java.util.List;

public class DiscussionDaoImpl implements DiscussionDao {

    @Override//插入新记录
    public void insertDiscussion(Discussion discussion) throws SQLException {

    }

    @Override//查询按点赞升序前count条数据
    public List<Discussion> selectByHotLimitAscend(Integer count) throws SQLException{
        return null;
    }

    @Override//查询按时间升序前count条数据
    public List<Discussion> selectByTimeLimitAscend(Integer count) throws SQLException{
        return null;
    }
}
