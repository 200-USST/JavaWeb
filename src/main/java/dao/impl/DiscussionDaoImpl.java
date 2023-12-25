package dao.impl;

import dao.DiscussionDao;
import pojo.Discussion;

import java.sql.SQLException;
import java.util.List;

public class DiscussionDaoImpl implements DiscussionDao {

    @Override//插入新记录
    public void insertDiscussion(Discussion discussion){

    }

    @Override//查询按点赞升序前count条数据
    public List<Discussion> selectByHotLimitAscend(Integer count){
        return null;
    }

    @Override//查询按时间升序前count条数据
    public List<Discussion> selectByTimeLimitAscend(Integer count){
        return null;
    }
}
