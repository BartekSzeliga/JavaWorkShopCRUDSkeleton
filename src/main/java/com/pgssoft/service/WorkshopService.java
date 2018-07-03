package com.pgssoft.service;

import com.pgssoft.domain.Workshop;
import com.pgssoft.repository.WorkshopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkshopService {

    private WorkshopRepository workshopRepository;

    public WorkshopService(WorkshopRepository workshopRepository) {
        this.workshopRepository = workshopRepository;
    }

    public Optional<Workshop> getWorkshopById(final String id) {
        return Optional.ofNullable(id).flatMap(s -> workshopRepository.findById(s));
    }

    public List<Workshop> getAllWorkshop() {
        return workshopRepository.findAll();
    }

    public Workshop saveWorkshop(final Workshop workshop) {
        return workshopRepository.save(workshop);
    }

    public Workshop updateWorkshop(String id, final Workshop workshop) {
        workshop.setId(id);
        return workshopRepository.save(workshop);
    }

    public void deleteWorkshopById(final String id) {
        Optional.ofNullable(id).ifPresent(workshopId -> workshopRepository.deleteById(workshopId));
    }

    public Optional<Workshop> addParticipant(String id, String participant) {
        return workshopRepository.findById(id).map(original -> {
            original.getParticipants().add(participant);
            return original;
        }).map(workshopRepository::save);
    }


    public Optional<Workshop> deleteParticipant(String id, String participant) {
        return workshopRepository.findById(id).map(original -> {
            original.getParticipants().remove(participant);
            return original;
        }).map(workshopRepository::save);
    }
}
