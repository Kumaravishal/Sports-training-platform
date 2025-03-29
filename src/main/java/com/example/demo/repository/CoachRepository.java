    package com.example.demo.repository;

    import java.util.List;

    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.Pageable;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;
    import org.springframework.stereotype.Repository;

    import com.example.demo.entity.Coach;

    @Repository
    public interface CoachRepository extends JpaRepository<Coach, Long> {

        // Find coaches by specialization
        List<Coach> findBySpecialization(String specialization);

        // Find coaches with experience greater than a given number of years
        List<Coach> findByExperienceYearsGreaterThan(int years);

        // Custom JPQL query to fetch coaches with a certain specialization
        @Query("SELECT c FROM Coach c WHERE c.specialization = :specialization")
        List<Coach> findCoachesBySpecialization(@Param("specialization") String specialization);

        @Query("SELECT c FROM Coach c LEFT JOIN FETCH c.athletes WHERE c.id = :id")
        Coach findCoachWithAthletes(@Param("id") Long id);

        

        // Pageable method for pagination
        @Override
        Page<Coach> findAll(Pageable pageable);
    }
