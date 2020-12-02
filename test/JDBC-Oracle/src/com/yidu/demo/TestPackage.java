package com.yidu.demo;

import com.yidu.demo.util.DBUtil;
import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestPackage {
    public static void main(String[] args) {
        List<Employee> employees = pageQueryEmp(2,10);
        for (Employee employee:employees){
            System.out.println(employee);
        }
    }

    public static List<Employee> pageQueryEmp(int pageIndex,int pageSize){
        Connection connection = DBUtil.getConnection();
        CallableStatement callableStatement =null;
        ResultSet resultSet =null;
        String sql="{call commPkg.pageQuery(?,?,?)}";
        List<Employee> employeeList = new ArrayList<>();
        try {
            callableStatement = connection.prepareCall(sql);
            callableStatement.setInt(1,pageIndex);
            callableStatement.setInt(2,pageSize);
            callableStatement.registerOutParameter(3, OracleTypes.CURSOR );
            callableStatement.execute();
            //从可调用语句对象中获取数据强转为Resultset
            resultSet= (ResultSet) callableStatement.getObject(3);
            while(resultSet.next()){
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getInt("employee_id"));
                employee.setFirsName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setDepartmentId(resultSet.getInt("department_id"));
                employee.setSalary(resultSet.getDouble("salary"));
                employee.setEmail(resultSet.getString("email"));
                employee.setHireDate(resultSet.getDate("hire_date"));
                employee.setCommissionPct(resultSet.getDouble("commission_pct"));
                employee.setJobId(resultSet.getString("job_id"));
                employee.setManagerId(resultSet.getInt("manager_id"));
                employee.setPhoneNumber(resultSet.getString("phone_number"));
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,callableStatement,resultSet);
        }

        return employeeList;
    }
}
