package com.matheuscardoso.course.entities;

import com.matheuscardoso.course.enumerator.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date moment;
    private OrderStatus orderstatus;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

}
