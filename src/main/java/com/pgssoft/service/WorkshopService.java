package com.pgssoft.service;

import com.pgssoft.domain.Workshop;
import com.pgssoft.repository.WorkshopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkshopService {

    private WorkshopRepository workshopRepository;

    public WorkshopService(WorkshopRepository workshopRepository) {
        this.workshopRepository = workshopRepository;
    }

    public Workshop getWorkshopById(final String id) {
        return workshopRepository.findById(id).orElse(null);
    }

    public List<Workshop> getAllWorshop() {
        return workshopRepository.findAll();
    }

    public Workshop saveWorkshop(final Workshop workshop) {
        return workshopRepository.save(workshop);
    }

    public Workshop updateWorkshop(String id, final Workshop workshop) {
        Workshop original = workshopRepository.findById(id).orElse(null);
        original.setNumber(workshop.getNumber());
        original.setOffice(workshop.getOffice());
        original.setParticipantsNumber(workshop.getParticipantsNumber());
        original.setRemote(workshop.isRemote());
        original.setPresenter(workshop.getPresenter());
        original.setRoom(workshop.getRoom());
        workshopRepository.save(original);

        return original;
    }

    public void deleteWorkshopById(final String id) {
        workshopRepository.deleteById(id);
    }

    public void insertRows(Integer numberOfRows){
        for(int i=0; i<numberOfRows; i++){
            Workshop workshop = new Workshop();
            workshop.setRoom("M3");
            workshop.setPresenter("Bartosz Szeliga");
            workshop.setRemote(false);
            workshop.setParticipantsNumber(12);
            workshop.setOffice("Rzeszow");
            workshop.setNumber(i);
            workshopRepository.save(workshop);
        }
    }
}
