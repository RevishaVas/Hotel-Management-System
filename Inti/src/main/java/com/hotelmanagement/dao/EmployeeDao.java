package com.hotelmanagement.dao;

import java.sql.SQLException;
import java.util.List;
import com.hotelmanagement.model.Employee;

public interface EmployeeDao {

    void insertEmployee(Employee employee) throws SQLException;

    Employee selectEmployee(long employeeId);

    List<Employee> selectAllEmployees();

    boolean deleteEmployee(long id) throws SQLException;

    boolean updateEmployee(Employee employee) throws SQLException;
}