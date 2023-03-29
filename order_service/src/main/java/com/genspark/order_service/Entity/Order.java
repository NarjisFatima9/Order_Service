package com.genspark.order_service.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;
    private String customerName;
    private String address;
    private String phoneNumber;
    //private List<MenuItem> menuItems;
    @OneToMany(mappedBy="order")
    private List<OrderItem> orderItems;

    private Double orderTotal;
    private LocalDateTime orderDate;
    private int orderStatus;

    public Order() {
    }

    public Order(long orderId, String customerName, String address, String phoneNumber,LocalDateTime orderDate,List<OrderItem> orderItems, Double orderTotal,int orderStatus) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.address = address;
        this.phoneNumber = phoneNumber;
       this.orderItems = orderItems;

        this.orderTotal = orderTotal;
        //LocalDate localDate = LocalDate.now();

        this.orderDate = orderDate;

        this.orderStatus = orderStatus;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //public List<MenuItem> getMenuItems() {
    //    return menuItems;
    //}

    //public void setMenuItems(List<MenuItem> menuItems) {
      //  this.menuItems = menuItems;
    //}

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }


        public void setOrderItems(List<OrderItem> orderItems){

            this.orderItems = orderItems;
            this.orderTotal = orderItems.stream()
                    .map( o -> o.getTotalCost() )
                    .reduce(0.0, Double::sum);
        }



    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {

        this.orderDate = orderDate;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
}

