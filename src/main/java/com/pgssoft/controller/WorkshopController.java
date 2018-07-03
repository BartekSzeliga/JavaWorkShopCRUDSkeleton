package com.pgssoft.controller;

import com.pgssoft.domain.Workshop;
import com.pgssoft.service.WorkshopService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workshop")
public class WorkshopController {

    private final WorkshopService workshopService;

    public WorkshopController(WorkshopService workshopService) {
        this.workshopService = workshopService;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Workshop saveWorkshop(@RequestBody final Workshop workshop) {
        return workshopService.saveWorkshop(workshop);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Workshop> getWorkshop(@PathVariable(value = "id") String id) {
        return workshopService.getWorkshopById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Workshop> getAllWorkshop() {
        return workshopService.getAllWorkshop();
    }

    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Workshop updateWorkshop(@PathVariable(value = "id") String id, @RequestBody final Workshop workshop) {
        return workshopService.updateWorkshop(id, workshop);
    }

    @DeleteMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void deleteWorkshop(@PathVariable(value = "id") String id) {
        workshopService.deleteWorkshopById(id);
    }

    @PutMapping(value = "addParticipant/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Workshop> addParticipant(@PathVariable(value = "id") String id, @RequestBody final String participant) {
        return workshopService.addParticipant(id, participant);
    }

    @PutMapping(value = "deleteParticipant/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Workshop> deleteParticipant(@PathVariable(value = "id") String id, @RequestBody final String participant) {
        return workshopService.deleteParticipant(id, participant);
    }

}
