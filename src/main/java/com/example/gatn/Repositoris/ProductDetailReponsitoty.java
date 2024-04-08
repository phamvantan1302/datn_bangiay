package com.example.gatn.Repositoris;

import com.example.gatn.Entity.DiscountPeriod;
import com.example.gatn.Entity.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailReponsitoty extends JpaRepository<ProductDetail,Integer> {

    @Query(value = "select pd.id, pd.id_category, pd.id_size, pd.id_product, pd.id_material, pd.id_brand, pd.id_color, pd.id_sole, pd.id_lace, pd.id_sockliner, pd.quantity, pd.describe, pd.gender, pd.price, pd.[status]  from product_detail as pd" +
            " left join category as c on pd.id_category = c.id" +
            " left join size as s on pd.id_size = s.id" +
            " left join product as p on pd.id_product = p.id" +
            " left join material as m on pd.id_material = m.id" +
            " left join brand as b on pd.id_brand = b.id" +
            " left join color as cl on pd.id_color = cl.id" +
            " left join sole as sl on pd.id_sole = sl.id" +
            " left join lace as lc on pd.id_lace = lc.id" +
            " left join sockliner sln on pd.id_sockliner =sln.id" +
            " where c.name like CONCAT('%', :key, '%') or " +
            " p.name like CONCAT('%', :key, '%') or " +
            " m.name like CONCAT('%', :key, '%') or " +
            " b.name like CONCAT('%', :key, '%') or " +
            " cl.name like CONCAT('%', :key, '%') or " +
            " sl.name like CONCAT('%', :key, '%') or " +
            " lc.name like CONCAT('%', :key, '%') or " +
            " sln.name like CONCAT('%', :key, '%') ", nativeQuery = true)
    Page<ProductDetail> search(@Param("key") String key, Pageable pageable);

    @Query(value = "select pd.id, pd.id_category, pd.id_size, pd.id_product, pd.id_material, pd.id_brand, pd.id_color, pd.id_sole, pd.id_lace, pd.id_sockliner, pd.quantity, pd.describe, pd.gender, pd.price, pd.[status]  from product_detail as pd" +
            " left join category as c on pd.id_category = c.id" +
            " left join size as s on pd.id_size = s.id" +
            " left join product as p on pd.id_product = p.id" +
            " left join material as m on pd.id_material = m.id" +
            " left join brand as b on pd.id_brand = b.id" +
            " left join color as cl on pd.id_color = cl.id" +
            " left join sole as sl on pd.id_sole = sl.id" +
            " left join lace as lc on pd.id_lace = lc.id" +
            " left join sockliner sln on pd.id_sockliner =sln.id" +
            " where pd.[status] like CONCAT('%', :key, '%') " , nativeQuery = true)
    Page<ProductDetail> getByStatus(@Param("key") Integer key, Pageable pageable);

    @Query(value = "select pd.id, pd.id_category, pd.id_size, pd.id_product, pd.id_material, pd.id_brand, pd.id_color, pd.id_sole, pd.id_lace, pd.id_sockliner, pd.quantity, pd.describe, pd.gender, pd.price, pd.[status]  from product_detail as pd" +
            " left join category as c on pd.id_category = c.id" +
            " left join size as s on pd.id_size = s.id" +
            " left join product as p on pd.id_product = p.id" +
            " left join material as m on pd.id_material = m.id" +
            " left join brand as b on pd.id_brand = b.id" +
            " left join color as cl on pd.id_color = cl.id" +
            " left join sole as sl on pd.id_sole = sl.id" +
            " left join lace as lc on pd.id_lace = lc.id" +
            " left join sockliner sln on pd.id_sockliner =sln.id" +
            " where pd.[status] like CONCAT('%', :key, '%') AND" +
            " pd.price BETWEEN :a AND :b " , nativeQuery = true)
    Page<ProductDetail> getByMoney(@Param("key") Integer key,
                                   @Param("a") int a, @Param("b") int b, Pageable pageable);

    @Query(value = "select pd.id, pd.id_category, pd.id_size, pd.id_product, pd.id_material, pd.id_brand, pd.id_color, pd.id_sole, pd.id_lace, pd.id_sockliner, pd.quantity, pd.describe, pd.gender, pd.price, pd.[status]  from product_detail as pd" +
            " left join category as c on pd.id_category = c.id" +
            " left join size as s on pd.id_size = s.id" +
            " left join product as p on pd.id_product = p.id" +
            " left join material as m on pd.id_material = m.id" +
            " left join brand as b on pd.id_brand = b.id" +
            " left join color as cl on pd.id_color = cl.id" +
            " left join sole as sl on pd.id_sole = sl.id" +
            " left join lace as lc on pd.id_lace = lc.id" +
            " left join sockliner sln on pd.id_sockliner =sln.id" +
            " where c.name like CONCAT('%', :key, '%') or " +
            " p.name like CONCAT('%', :key, '%') or " +
            " m.name like CONCAT('%', :key, '%') or " +
            " b.name like CONCAT('%', :key, '%') or " +
            " cl.name like CONCAT('%', :key, '%') or " +
            " sl.name like CONCAT('%', :key, '%') or " +
            " lc.name like CONCAT('%', :key, '%') or " +
            " sln.name like CONCAT('%', :key, '%') AND" +
            " pd.[status] like CONCAT('%', :status, '%')", nativeQuery = true)
    Page<ProductDetail> searchHome(@Param("key") String key, @Param("status") Integer status, Pageable pageable);
}
