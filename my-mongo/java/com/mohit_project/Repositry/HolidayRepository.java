package com.mohit_project.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit_project.Entity.Holiday;




public interface HolidayRepository extends JpaRepository<Holiday, Long> {

}
