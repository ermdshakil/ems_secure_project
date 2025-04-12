package com.mohit_project.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohit_project.Entity.Profile;

@Repository
public interface ProfileREpo extends JpaRepository<Profile, Long> {

}
