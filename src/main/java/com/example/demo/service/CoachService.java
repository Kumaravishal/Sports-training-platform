package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Coach;
import com.example.demo.repository.CoachRepository;

@Service
public class CoachService {

    private final CoachRepository coachRepository;

    public CoachService(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    public Coach createCoach(Coach coach) {
        return coachRepository.save(coach);
    }

    public Optional<Coach> getCoachById(Long id) {
        return coachRepository.findById(id);
    }

    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }

    public Page<Coach> getCoachesPaginated(Pageable pageable) {
        return coachRepository.findAll(pageable);
    }

    public Coach updateCoach(Long id, Coach updatedCoach) {
        if (coachRepository.existsById(id)) {
            updatedCoach.setId(id);
            return coachRepository.save(updatedCoach);
        }
        return null;
    }

    public void deleteCoach(Long id) {
        coachRepository.deleteById(id);
    }
    public List<Coach> findCoachesSpecialization(String specialization){
        return coachRepository.findBySpecialization(specialization);

    }

    public Coach getCoachWithAthletes(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
