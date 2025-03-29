package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Athlete;
import com.example.demo.service.AthleteService;

@RestController
@RequestMapping("/api/athletes")
public class AthleteController {

    private final AthleteService athleteService;

    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }

    @PostMapping("/create")
    public Athlete createAthlete(@RequestBody Athlete athlete) {
        return athleteService.createAthlete(athlete);
    }

    @GetMapping("/{id}")
    public Athlete getAthleteById(@PathVariable Long id) {
        return athleteService.getAthleteById(id).orElse(null);
    }

    @GetMapping("/get")
    public List<Athlete> getAllAthletes() {
        return athleteService.getAllAthletes();
    }

    @GetMapping("/paginate")
    public Page<Athlete> getAthletesPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder) {
        return athleteService.getAthletesPaginated(page, size, sortBy, sortOrder);
    }

    @PutMapping("/{id}")
    public Athlete updateAthlete(@PathVariable Long id, @RequestBody Athlete athlete) {
        return athleteService.updateAthlete(id, athlete);
    }

    @DeleteMapping("/{id}")
    public String deleteAthlete(@PathVariable Long id) {
        athleteService.deleteAthlete(id);
        return "Message deleted Successfully";
    }
}
