package com.example.demo.service;

import com.example.demo.entity.Athlete;
import com.example.demo.repository.AthleteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AthleteService {

    private final AthleteRepository athleteRepository;

    public AthleteService(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    public Athlete createAthlete(Athlete athlete) {
        return athleteRepository.save(athlete);
    }

    public Optional<Athlete> getAthleteById(Long id) {
        return athleteRepository.findById(id);
    }

    public List<Athlete> getAllAthletes() {
        return athleteRepository.findAll();
    }

    public Page<Athlete> getAthletesPaginated(int page, int size, String sortBy, String sortOrder) {
        Sort sort = sortOrder.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        return athleteRepository.findAll(PageRequest.of(page, size, sort));
    }

    public Athlete updateAthlete(Long id, Athlete updatedAthlete) {
        if (athleteRepository.existsById(id)) {
            updatedAthlete.setId(id);
            return athleteRepository.save(updatedAthlete);
        }
        return null;
    }

    public void deleteAthlete(Long id) {
        athleteRepository.deleteById(id);
    }
}
