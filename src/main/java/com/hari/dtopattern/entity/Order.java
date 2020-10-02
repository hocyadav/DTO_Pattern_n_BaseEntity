package com.hari.dtopattern.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author HariomYadav
 * @since 02/10/20
 */
@Getter
@Setter
@NoArgsConstructor
@Slf4j
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {//Order is reserve keyword in Hibernate
    String orderName;
    String status;

    @Builder
    public Order(String orderName, String status) {
        this.orderName = orderName;
        this.status = status;
    }
}
