package com.example.warehouse.repository;

import com.example.warehouse.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

   @Query(value = "SELECT * from category where parent_category_id=:parentCategoryId", nativeQuery = true)
   List<Category> findAllByParentCategoryId(Integer parentCategoryId);

   Category findByName(String name);
   boolean existsByName(String name);
   boolean existsByParentCategoryId(Integer parentCategoryId);


}
