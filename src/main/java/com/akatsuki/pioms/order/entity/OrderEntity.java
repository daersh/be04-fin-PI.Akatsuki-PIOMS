package com.akatsuki.pioms.order.entity;

import com.akatsuki.pioms.franchise.entity.FranchiseEntity;
import com.akatsuki.pioms.order.etc.ORDER_CONDITION;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "request")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class OrderEntity {

    @Id
    @Column(name = "request_code")
    private int orderCode;

    @Column(name = "request_date")
    private Date orderDate;

    @Column(name = "request_total_price")
    private int orderTotalPrice;

    @Column(name = "request_condition")
    @Enumerated(EnumType.STRING)
    private ORDER_CONDITION orderCondition;

    @Column(name = "request_reason")
    private String orderReason;

    @Column(name = "request_status")
    private boolean orderStatus;

    @JoinColumn(name = "franchise_code")
    @OneToOne
    private FranchiseEntity franchise;

}
