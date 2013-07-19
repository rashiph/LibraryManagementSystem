package com.thoughtworks.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Order {
    @Id
    private int orderId;

    @Column(name = "orderDate")
    private Date orderDate;

    @Column(name = "vendorId")
    private int vendorId;

    @Column(name = "productOrderId")
    private List<Integer> productOrderId;

    @Column(name = "orderPlaced")
    private boolean orderPlaced;

}
