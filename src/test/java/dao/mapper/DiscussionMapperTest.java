package dao.mapper;

import com.google.gson.GsonBuilder;
import dao.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pojo.Discussion;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class DiscussionMapperTest {
    DiscussionMapper discussionMapper;
    @BeforeAll
    public void getMapper(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        discussionMapper = sqlSession.getMapper(DiscussionMapper.class);
    }
    @Test
    void testInsert() throws SQLException {
        Discussion discussion = new Discussion(1, "dfs", new Date(), 2, "fds", "dfsd", "sdf", 26, 1);
        discussionMapper.insertDiscussion(discussion);
    }
    @Test
    void testSelectByTime() throws SQLException {
        List<Discussion> discussions = discussionMapper.selectByTimeLimitAscend(5);
        for (Object item :discussions) {
            System.out.println(item);
        }
    }
    @Test
    void testDeleteByID() throws SQLException {

        discussionMapper.deleteByID(8);
    }
    @Test
    void testSelectAll() throws SQLException{
        List<Discussion> discussions = discussionMapper.selectAll();
        for (Object item :discussions) {
            System.out.println(item);
        }


    }

}
