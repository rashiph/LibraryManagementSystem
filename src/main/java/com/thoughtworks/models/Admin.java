package com.thoughtworks.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "admin")
public class Admin extends BaseEntity
{
    @NotEmpty
    @Column(name = "employeeId",unique = true)
    private int employeeId;

    @NotEmpty
    @Column(name = "userName")
    private String userName;

    @NotEmpty
    @Column(name = "isActive")
    private boolean isActive;

    public int getEmployeeId() {
        return employeeId;
    }

    public String getUserName() {
        return userName;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public Admin() {

    }

    public Admin(int employeeId, String userName,boolean isActive) {
        this.employeeId = employeeId;
        this.userName = userName;
        this.isActive = isActive;
    }
}