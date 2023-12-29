package dao.mapper;

import pojo.Complaint;

import java.sql.SQLException;
import java.util.List;

public interface ComplaintMapper{
    void insertNewComplaint(Complaint complaint) throws SQLException;
    List<Complaint> selectAll()throws SQLException;
    List<Complaint> selectAllById(Integer id)throws SQLException;
    void deleteById(Integer id) throws SQLException;
    void updateStatusByID(Integer id) throws SQLException;

}
