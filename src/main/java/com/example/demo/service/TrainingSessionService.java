
package com.example.demo.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TrainingSession;
import com.example.demo.repository.TrainingSessionRepository;

@Service
public class TrainingSessionService {

    private final TrainingSessionRepository trainingSessionRepository;

    public TrainingSessionService(TrainingSessionRepository trainingSessionRepository) {
        this.trainingSessionRepository = trainingSessionRepository;
    }

    public TrainingSession createTrainingSession(TrainingSession trainingSession) {
        return trainingSessionRepository.save(trainingSession);
    }

    public Optional<TrainingSession> getTrainingSessionById(Long id) {
        return trainingSessionRepository.findById(id);
    }

    public Page<TrainingSession> getAllTrainingSessions(Pageable pageable) {
        return trainingSessionRepository.findAll(pageable);
    }

    public TrainingSession updateTrainingSession(Long id, TrainingSession updatedTrainingSession) {
        if (trainingSessionRepository.existsById(id)) {
            updatedTrainingSession.setId(id);
            return trainingSessionRepository.save(updatedTrainingSession);
        }
        return null;
    }

    public void deleteTrainingSession(Long id) {
        trainingSessionRepository.deleteById(id);
    }
}
