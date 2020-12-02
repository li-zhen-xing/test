package com.yidu.demo;

import com.yidu.demo.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestJDBC {

    public static List<Employee> testJDBC(){
        //3.获得连接
        Connection conn = DBUtil.getConnection();
        //预处理语句对象
        PreparedStatement preparedStatement = null;
        //结果集
        ResultSet resultSet = null;
        //查询某个部门员工的slq语句
        String sql = "select * from employees where department_id = ?";
        //定义一个员工集合
        List<Employee> employeeList = new ArrayList<>();
        try {
            //4.获取预处理语句对象
            preparedStatement = conn.prepareStatement(sql);
            //为占位符赋值
            preparedStatement.setInt(1,50);
            //5.执行查询获得结果集
            resultSet = preparedStatement.executeQuery();
            //6.操作结果集
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
            DBUtil.closeAll(conn,preparedStatement,resultSet);
        }
        return employeeList;
    }

    public void testInOutParameterProcedure(){
        Connection conn = DBUtil.getConnection();
        CallableStatement callableStatement = null;
        String sql = "{call formatPhoneNumber(?)}";
        String phoneNumber = "070388223456";
        try {
            callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1,phoneNumber);
            callableStatement.registerOutParameter(1,Types.VARCHAR);
            callableStatement.execute();
            phoneNumber = callableStatement.getString("phoneNumber");
            System.out.println("格式化后的phoneNumber:"+phoneNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    /**
     * 测试调用带输入输出的存储过程
     */
    public void testOutParamProcedure(){
        Connection conn = DBUtil.getConnection();
        //定义 可以调用的语句对象
        CallableStatement callableStatement = null;
        String sql = "{call findEmpSalary(?,?)}";
        double salary;
        try {
            //获得可调用的语句对象
            callableStatement = conn.prepareCall(sql);
            //为输入类型参数赋值
            callableStatement.setInt(1,100);
            //为输出类型参数注册类型
            callableStatement.registerOutParameter(2,Types.DOUBLE);
            //执行调用 将结果存入输出类型参数中
            callableStatement.execute();
            //从输出类型参数获取数据
            salary = callableStatement.getDouble(2);
            System.out.println(salary);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(conn,callableStatement,null);
        }
    }

    /**
     * 测试调用函数
     *
     */
    public void tesFunction(double salary){
        Connection conn = DBUtil.getConnection();
        CallableStatement callableStatement = null;
        String sql = "{? = call calPersonTax(?)}";
        double personTax = 0.0D;
        try {
            callableStatement = conn.prepareCall(sql);
            //返回值是输出类型的参数,先注册
            callableStatement.registerOutParameter(1,Types.DOUBLE);
            //为输入类型的参数赋值
            callableStatement.setDouble(2,salary);
            //执行调用
            callableStatement.execute();
            personTax = callableStatement.getDouble(1);
            System.out.println("月薪:"+salary+"应该缴纳的个税是:"+personTax);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(conn,callableStatement,null);
        }
    }

    public static void main(String[] args) {
        List<Employee> employeeList = testJDBC();
        for (Employee employee:employeeList){
            System.out.println(employee);
        }
    }
}