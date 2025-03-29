package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Coach;
import com.example.demo.service.CoachService;

@RestController
@RequestMapping("/coaches")
public class CoachController {

    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @PostMapping("/post")
    public Coach createCoach(@RequestBody Coach coach) {
        return coachService.createCoach(coach);
    }

    @GetMapping("/{id}")
    public Coach getCoachById(@PathVariable Long id) {
        return coachService.getCoachById(id).orElse(null);
    }

    @GetMapping("/all")
    public List<Coach> getAllCoaches() {
        return coachService.getAllCoaches();
    }

    @GetMapping("/paginate")
    public Page<Coach> getCoachesPaginated(Pageable pageable) {
        return coachService.getCoachesPaginated(pageable);
    }
                    
    @PutMapping("/{id}")
    public Coach updateCoach(@PathVariable Long id, @RequestBody Coach coach) {
        return coachService.updateCoach(id, coach);
    }

    @DeleteMapping("/{id}")
    public String deleteCoach(@PathVariable Long id) {
        coachService.deleteCoach(id);
        return "Message deleted Successfully";
    }
    @GetMapping("/specialization/{specialilzation}")
        public List<Coach> findCoachesSpecialization(@PathVariable String specialilzation)
        {
           return coachService.findCoachesSpecialization(specialilzation);
        }
}
