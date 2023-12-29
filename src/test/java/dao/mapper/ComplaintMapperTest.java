package dao.mapper;

import dao.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pojo.Complaint;
import pojo.Discussion;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ComplaintMapperTest {
    ComplaintMapper complaintMapper;
    @BeforeAll
    public void getMapper(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        complaintMapper = sqlSession.getMapper(ComplaintMapper.class);
    }
    @Test
    void testInsert() throws SQLException {
//        Discussion discussion = new Discussion(1, "dfs", new Date(), 2, "fds", "dfsd", "sdf", 26, 1);
        Complaint complaint = new Complaint(null, 2, "fdsf", "fdsf", new Date(),false);
        complaintMapper.insertNewComplaint(complaint);
    }
    @Test
    void testSelectByTime() throws SQLException {
        List<Complaint> complaints = complaintMapper.selectAll();
        for (Object item :complaints) {
            System.out.println(item);
        }
    }
    @Test
    void testDeletetByID() throws SQLException {
        complaintMapper.deleteById(2);
    }

    @Test
    void testUpdate() throws SQLException {
        complaintMapper.updateStatusByID(3);
    }
}
