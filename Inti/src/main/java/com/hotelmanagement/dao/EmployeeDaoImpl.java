package com.hotelmanagement.dao;

import com.hotelmanagement.model.Employee;
import com.hotelmanagement.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private static final String INSERT_EMPLOYEES_SQL = "INSERT INTO employees (firstName, role, shift, status) VALUES (?, ?, ?, ?);";
    private static final String SELECT_EMPLOYEE_BY_ID = "SELECT id, firstName, role, shift, status FROM employees WHERE id = ?";
    private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employees";
    private static final String DELETE_EMPLOYEE_BY_ID = "DELETE FROM employees WHERE id = ?;";
    private static final String UPDATE_EMPLOYEE = "UPDATE employees SET firstName = ?, role = ?, shift = ?, status = ? WHERE id = ?;";

    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEES_SQL)) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getRole());
            preparedStatement.setString(3, employee.getShift());
            preparedStatement.setBoolean(4, employee.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            JDBCUtils.printSQLException(exception);
        }
    }

    @Override
    public Employee selectEmployee(long employeeId) {
        Employee employee = null;
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID)) {
            preparedStatement.setLong(1, employeeId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String firstName = rs.getString("firstName");
                String role = rs.getString("role");
                String shift = rs.getString("shift");
                boolean status = rs.getBoolean("status");
                employee = new Employee(id, firstName, role, shift, status);
            }
        } catch (SQLException exception) {
            JDBCUtils.printSQLException(exception);
        }
        return employee;
    }

    @Override
    public List<Employee> selectAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String firstName = rs.getString("firstName");
                String role = rs.getString("role");
                String shift = rs.getString("shift");
                boolean status = rs.getBoolean("status");
                employees.add(new Employee(id, firstName, role, shift, status));
            }
        } catch (SQLException exception) {
            JDBCUtils.printSQLException(exception);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(long id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_BY_ID)) {
            statement.setLong(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE)) {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getRole());
            statement.setString(3, employee.getShift());
            statement.setBoolean(4, employee.getStatus());
            statement.setLong(5, employee.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
