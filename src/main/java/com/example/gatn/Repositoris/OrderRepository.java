package com.example.gatn.Repositoris;

import com.example.gatn.Entity.Order;
import com.example.gatn.Entity.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT [id],[phone_number],[address],[use_name],[email],[item_discount],[total_money],[create_date]" +
            " FROM [dbo].[order]" +
            " WHERE id_client like CONCAT('%', :id, '%')" , nativeQuery = true)
    List<Order> getByClient(@Param("id") Integer id);
}
