package org.pentyugov.app.dao;

import org.pentyugov.app.models.Department;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class DeptDAO {

   EntityManager em = Persistence.createEntityManagerFactory("TEST").createEntityManager();

    public Department getDepartment(int id) {
        return em.find(Department.class, id);
    }

    public void addDepartment(Department department) {
        em.getTransaction().begin();
        em.merge(department);
        em.getTransaction().commit();
    }

    public void deleteDepartment(Integer id) {
        em.getTransaction().begin();
        em.remove(getDepartment(id));
    }

    public void updateDepartment(Department department) {
        em.getTransaction().begin();
        em.merge(department);
        em.getTransaction().commit();
    }

    public List<Department> getAllDepartments() {
        TypedQuery<Department> namedQuery = em.createNamedQuery("Department.getAll", Department.class);
        return namedQuery.getResultList();
    }

}
