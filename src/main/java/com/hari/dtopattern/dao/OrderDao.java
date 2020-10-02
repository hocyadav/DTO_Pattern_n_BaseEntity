package com.hari.dtopattern.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hari.dtopattern.entity.Order;

/**
 * @author HariomYadav
 * @since 02/10/20
 */
@Repository
public interface OrderDao extends JpaRepository<Order, Long> {}
