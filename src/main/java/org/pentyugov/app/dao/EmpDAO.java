package org.pentyugov.app.dao;

import org.pentyugov.app.models.Department;
import org.pentyugov.app.models.Employee;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class EmpDAO {
    EntityManager em = Persistence.createEntityManagerFactory("TEST").createEntityManager();


    public Employee getEmployee(String id) {
        return em.find(Employee.class, Integer.parseInt(id));
    }

    public List<Employee> getEmployeesByName(String name) {
        em.getTransaction().begin();
        List<Employee> employees =
            em.createQuery("SELECT e FROM Employee e WHERE lower(e.name) LIKE :name")
                    .setParameter("name", name.toLowerCase()).getResultList();
        em.getTransaction().commit();
        return employees;
    }

    public List<Employee> getEmployeesByJob(String job) {
        em.getTransaction().begin();
        List<Employee> employees =
            em.createQuery("SELECT e FROM Employee e WHERE lower(e.job) LIKE :job")
                    .setParameter("job", job.toLowerCase()).getResultList();
        em.getTransaction().commit();
        return employees;
    }


    public void addEmployee(Employee employee) {
        em.getTransaction().begin();
        em.merge(employee);
        em.getTransaction().commit();
    }

    public void deleteEmployee(String id) {
        em.getTransaction().begin();
        em.remove(getEmployee(id));
        em.getTransaction().commit();
    }

    public void updateEmployee(Employee employee) {
        em.getTransaction().begin();
        em.merge(employee);
        em.getTransaction().commit();
    }

    public List<Employee> getAllEmployees() {
//        TypedQuery<Employee> namedQuery = em.createNamedQuery("Employee.getAll", Employee.class);
//        return namedQuery.getResultList();
        em.getTransaction().begin();
        List<Employee> employees = em.createQuery("SELECT e FROM Employee e").getResultList();
        em.getTransaction().commit();
        return employees;
    }
}
