package com.mohit_project.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;



import org.springframework.stereotype.Repository;

import com.mohit_project.Entity.Category;



@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

}
