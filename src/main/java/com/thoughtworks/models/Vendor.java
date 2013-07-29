package com.thoughtworks.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "vendors")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Vendor {
    @Id
    private int vendorId;

    @Column(name = "vendorName")
    String vendorName;

    @Column(name = "mobileNumber")
    String mobileNumber;

    @Column(name = "emailId")
    String emailId;

    @Column(name = "address")
    String address;

    @Column(name = "PanNumber")
    String PanNumber;

    @Column(name = "TinNumber")
    String TinNumber;

    public String getVendorName() {
        return vendorName;
    }
}
