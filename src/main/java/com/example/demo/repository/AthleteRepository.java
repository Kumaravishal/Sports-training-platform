package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Athlete;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {

    // Find athletes by sport
    List<Athlete> findBySport(String sport);

    // Find athletes by coach ID
    List<Athlete> findByCoachId(Long coachId);

    // Custom JPQL query to fetch athletes above a certain age
    @Query("SELECT a FROM Athlete a WHERE a.age > :age")
    List<Athlete> findAthletesAboveAge(int age);

    // Pagination and sorting support
    @Override
    Page<Athlete> findAll(Pageable pageable);
}
