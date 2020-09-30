package org.pentyugov.app.models;

import javax.persistence.*;

@Entity
@Table(name = "dept")
@NamedQuery(name = "Department.getAll", query = "Select d from Department d")
public class Department {

    @Id
    @Column(name = "deptno")
    private int id;
    @Column(name = "dname", nullable = false)
    private String name;
    @Column(name = "loc", nullable = false)
    private String location;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
