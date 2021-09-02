package com.nedacort.challengespringbackend.web.controller;

import com.nedacort.challengespringbackend.domain.PersonageDto;
import com.nedacort.challengespringbackend.domain.PersonageDtoLimited;
import com.nedacort.challengespringbackend.domain.service.PersonageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class PersonageController {


    @Autowired
    private PersonageService personageService;


    @GetMapping("/all")
    private ResponseEntity<List<PersonageDtoLimited>> getAll() {
        return new ResponseEntity<>(personageService.getAllNameAndImage(), HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity<PersonageDto> save(@RequestBody PersonageDto personageDto) {
        return new ResponseEntity<>(personageService.save(personageDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PersonageDto> update(@RequestBody PersonageDto personageDto, @PathVariable Integer id) {
        PersonageDto personageDtoActual = personageService.getPersonageById(id).get();
        personageDtoActual.setName(personageDto.getName());
        personageDtoActual.setAge(personageDto.getAge());
        personageDtoActual.setImage(personageDto.getImage());
        personageDtoActual.setHistory(personageDto.getHistory());
        return new ResponseEntity<>(personageService.save(personageDtoActual), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        return personageService.delete(id) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
