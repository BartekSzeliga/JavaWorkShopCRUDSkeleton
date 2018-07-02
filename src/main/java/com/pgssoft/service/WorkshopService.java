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
        return Optional.ofNullable(id).map(s -> workshopRepository.findById(s)).orElse(null);
    }

    public List<Workshop> getAllWorkshop() {
        return workshopRepository.findAll();
    }

    public Workshop saveWorkshop(final Workshop workshop) {
        return workshopRepository.save(workshop);
    }

    public Optional<Workshop> updateWorkshop(String id, final Workshop workshop) {

        return Optional.ofNullable(id).map(projectId ->
                workshopRepository.findById(id).map(original -> {
                    Optional.ofNullable(workshop.getNumber()).ifPresent(original::setNumber);
                    Optional.ofNullable(workshop.getOffice()).ifPresent(original::setOffice);
                    Optional.ofNullable(workshop.getParticipantsNumber()).ifPresent(original::setParticipantsNumber);
                    Optional.ofNullable(workshop.getPresenter()).ifPresent(original::setPresenter);
                    Optional.ofNullable(workshop.getRoom()).ifPresent(original::setRoom);
                    Optional.ofNullable(workshop.isRemote()).ifPresent(original::setRemote);
                    return original;
                }).map(workshopRepository::save)).orElse(null);
    }

    public void deleteWorkshopById(final String id) {
        Optional.ofNullable(id).ifPresent(workshopId -> workshopRepository.deleteById(workshopId));
    }


}
