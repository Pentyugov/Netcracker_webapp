package org.pentyugov.app.controllers;

import org.pentyugov.app.dao.EmpDAO;
import org.pentyugov.app.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller

public class EmployeeWebController {
    @Autowired
    private EmpDAO empDAO;

    @GetMapping("/employees")
    public String showEmpBrowser() {
        return "templates/employees/empbrowser";
    }

    @GetMapping("/employees/findbyid")
    public String findEmployeeById(@RequestParam(value = "empno", required = false) String empno, Model model) {
        List<Employee> employees = null;
        if(empno != null) {
            try {
                employees = new ArrayList<>();
                employees.add(empDAO.getEmployee(empno));
                model.addAttribute("Employees", employees);
                System.out.println(employees);
            } catch (NumberFormatException e) {model.addAttribute("Employees", employees);}
        }
        return "templates/employees/empbrowser";
    }

    @GetMapping("/employees/findbyname")
    public String findEmployeeByName(@RequestParam(value = "empname", required = false) String empname, Model model) {
        List<Employee> employees = empDAO.getEmployeesByName(empname);
        model.addAttribute("Employees", employees);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        return "templates/employees/empbrowser";
    }

    @GetMapping("/employees/findall")
    public String findEmployees(Model model) {
        List<Employee> employees = empDAO.getAllEmployees();
        model.addAttribute("Employees", employees);
        return "templates/employees/empbrowser";
    }

    @PostMapping("/employees/findbyjob")
    public String findEmployeeByJob(@RequestParam(value = "empjob") String empjob, Model model) {
        List<Employee> employees = empDAO.getEmployeesByJob(empjob);
        model.addAttribute("Employees", employees);
        return "templates/employees/empbrowser";
    }

    @GetMapping("/showemp/{id}")
    public String showEmployee(@PathVariable("id") String id, Model model) {
        Employee employee = empDAO.getEmployee(id);
        model.addAttribute("Employee", employee);
        return "templates/employees/showemp";
    }
}
