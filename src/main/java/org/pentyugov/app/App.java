package org.pentyugov.app;


import org.pentyugov.app.dao.DeptDAO;
import org.pentyugov.app.dao.EmpDAO;
import org.pentyugov.app.models.Department;
import org.pentyugov.app.models.Employee;

import java.util.List;

public class App {
    public static void main(String[] args) {
        EmpDAO empDAO = new EmpDAO();
        List<Employee> list = empDAO.getEmployeesByName("WARD");
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
}
