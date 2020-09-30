package org.pentyugov.app.models;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "emp")
@NamedQuery(name = "Employee.getAll", query = "Select e from Employee e")
public class Employee {

    @Id
    @Column(name = "empno")
    private int id;

    @Column(name = "ename", nullable = false)
    private String name;

    @Column(name = "job", nullable = false)
    private String job;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mgr")
    private  Employee manager;

    @Column(name = "hiredate", nullable = false)
    private Date hiredate;

    @Column(name = "sal", nullable = false)
    private int salary;

    @Column(name = "comm")
    private Integer commissions;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deptno", nullable = false)
    private Department department;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Integer getCommissions() {
        return commissions;
    }

    public void setCommissions(Integer commissions) {
        this.commissions = commissions;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", manager=" + manager +
                ", hiredate=" + hiredate +
                ", salary=" + salary +
                ", commissions=" + commissions +
                ", department=" + department +
                '}';
    }
}
