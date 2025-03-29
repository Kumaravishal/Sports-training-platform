
package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TrainingSession;

@Repository
public interface TrainingSessionRepository extends JpaRepository<TrainingSession, Long> {

    // Find sessions by location
    List<TrainingSession> findByLocation(String location);

    // Find training sessions for a specific athlete
    List<TrainingSession> findByAthleteId(Long athleteId);

    // Find training sessions happening after a specific date
    List<TrainingSession> findByDateTimeAfter(LocalDateTime dateTime);

    // Custom JPQL query to fetch training sessions for a specific athlete
    @Query("SELECT ts FROM TrainingSession ts WHERE ts.athlete.id = :athleteId")
    List<TrainingSession> getSessionsByAthleteId(Long athleteId);
    

    // Pagination and sorting support
    @Override
    Page<TrainingSession> findAll(Pageable pageable);
}
