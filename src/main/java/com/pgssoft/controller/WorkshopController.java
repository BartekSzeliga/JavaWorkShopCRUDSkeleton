package com.pgssoft.controller;

import com.pgssoft.domain.Workshop;
import com.pgssoft.service.WorkshopService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Workshop getWorkshop(@PathVariable(value = "id") String id) {
        return workshopService.getWorkshopById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Workshop> getAllUpSkill() {
        return workshopService.getAllWorshop();
    }

    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Workshop updateWorkshop(@PathVariable(value = "id") String id, @RequestBody final Workshop workshop) {
        return workshopService.updateWorkshop(id, workshop);
    }

    @DeleteMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void deleteWorkshop(@PathVariable(value = "id") String id) {
        workshopService.deleteWorkshopById(id);
    }

    @PutMapping(value = "insertRows/{numberOfRows}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void insertRows(@PathVariable(value = "numberOfRows") Integer numberOfRows) {
         workshopService.insertRows(numberOfRows);
    }
}
