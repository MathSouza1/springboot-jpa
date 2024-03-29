package com.matheuscardoso.course.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.matheuscardoso.course.enumerators.OrderStatus;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "DD-MM-YYYY'T'HH:mm:ss'Z'", timezone = "GMT-3")
    private Instant moment;

    private Integer orderStatus;

    @Setter
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    @Setter
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client){
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public Double getTotal() {
        double totalOrderPrice = 0.0;
        for (OrderItem orderItem : items) {
            totalOrderPrice += orderItem.getSubTotal();
        }
        return totalOrderPrice;
    }
}
