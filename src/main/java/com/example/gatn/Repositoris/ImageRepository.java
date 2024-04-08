package com.example.gatn.Repositoris;

import com.example.gatn.Entity.Image;
import com.example.gatn.Entity.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    @Query(value = "SELECT * FROM [image] WHERE id_productdetail = :idsp", nativeQuery = true)
    List<Image> getByIdSp(@Param("idsp") Integer idsp);
}
