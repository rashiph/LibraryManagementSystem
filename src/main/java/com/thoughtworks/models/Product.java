package com.thoughtworks.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Product {

    @Id
    private Integer productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "unitPrice")
    private float unitPrice;

    @Column(name = "productUnit")
    private String productUnit;

    @Column(name = "vendorId")
    @ForeignKey(name = "id")
    private Integer vendorId;
}
