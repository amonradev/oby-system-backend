package com.backend.oby.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Clients {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "satisfaction")
    private String satisfaction;

    @Column(name = "idSys")
    private long idSys;

    public Clients() {

    }

    public Clients(long id, String name, String description, String satisfaction, long idSys) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.satisfaction = satisfaction;
        this.idSys = idSys;
    }

    public long getIdSys() {
        return idSys;
    }

    public void setIdSys(long idSys) {
        this.idSys = idSys;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(String satisfaction) {
        this.satisfaction = satisfaction;
    }
}
