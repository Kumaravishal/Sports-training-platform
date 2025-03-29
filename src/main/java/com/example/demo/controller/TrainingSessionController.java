package com.example.demo.controller;

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

import com.example.demo.entity.TrainingSession;
import com.example.demo.service.TrainingSessionService;

@RestController
@RequestMapping("/training")
public class TrainingSessionController {

    private final TrainingSessionService trainingSessionService;

    public TrainingSessionController(TrainingSessionService trainingSessionService) {
        this.trainingSessionService = trainingSessionService;
    }

    @PostMapping("/post")
    public TrainingSession createTrainingSession(@RequestBody TrainingSession trainingSession) {
        return trainingSessionService.createTrainingSession(trainingSession);
    }

    @GetMapping("/{id}")
    public TrainingSession getTrainingSessionById(@PathVariable Long id) {
        return trainingSessionService.getTrainingSessionById(id).orElse(null);
    }

    @GetMapping("/all")
    public Page<TrainingSession> getAllTrainingSessions(Pageable pageable) {
        return trainingSessionService.getAllTrainingSessions(pageable);
    }

    @PutMapping("/{id}")
    public TrainingSession updateTrainingSession(@PathVariable Long id, @RequestBody TrainingSession trainingSession) {
        return trainingSessionService.updateTrainingSession(id, trainingSession);
    }

    @DeleteMapping("/{id}")
    public void deleteTrainingSession(@PathVariable Long id) {
        trainingSessionService.deleteTrainingSession(id);
    }
}
