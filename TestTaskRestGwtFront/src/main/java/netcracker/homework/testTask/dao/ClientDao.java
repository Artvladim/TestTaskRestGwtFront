package netcracker.homework.testTask.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "client")
public class ClientDao implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    private Integer id;

    @Column
    private String name;

    @Column
    private String sureName;


    @Column
    private String gender;

    @Column
    private String age;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}


