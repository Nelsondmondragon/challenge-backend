package com.nedacort.challengespringbackend.web.controller;

import com.nedacort.challengespringbackend.domain.PersonageDto;
import com.nedacort.challengespringbackend.domain.PersonageDto1;
import com.nedacort.challengespringbackend.domain.service.PersonageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonageController {


    @Autowired
    private PersonageService personageService;


    @GetMapping("/characters")
    private ResponseEntity<List<PersonageDto1>> getAll() {
        return new ResponseEntity<>(personageService.getAllNameAndImage(), HttpStatus.OK);
    }


}
