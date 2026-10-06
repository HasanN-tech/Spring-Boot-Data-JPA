package com.hasan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hasan.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	@Query("Select o from Order o where o.category = :category")
	List<Order> diaplayCategory(@Param("category") String category);

	@Query("Select o from Order o where o.paymentMode = :payment")
	List<Order> displayPayment(@Param("payment") String payment);

	@Query("Select o from Order o where o.amount > :amt")
	List<Order> aboveAmount(@Param("amt") Double amt);

}
