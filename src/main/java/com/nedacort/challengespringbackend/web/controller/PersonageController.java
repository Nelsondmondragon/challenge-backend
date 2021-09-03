package com.nedacort.challengespringbackend.web.controller;

import com.nedacort.challengespringbackend.domain.MovieDto;
import com.nedacort.challengespringbackend.domain.PersonageDto;
import com.nedacort.challengespringbackend.domain.PersonageDtoLimited;
import com.nedacort.challengespringbackend.domain.PersonageMovieDto;
import com.nedacort.challengespringbackend.domain.service.PersonageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/characters")
public class PersonageController {


    @Autowired
    private PersonageService personageService;


    @GetMapping("/all")
    private ResponseEntity<List<PersonageDtoLimited>> getAll() {
        return new ResponseEntity<>(personageService.getAllNameAndImage(), HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<PersonageMovieDto>> getSearch(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "age", required = false) Integer age
            , @RequestParam(value = "movie", required = false) Integer id) {
        Optional<List<PersonageMovieDto>> optional = null;
        if (name != null && age == null && id == null) {
            optional = personageService.findAllByName(name);
        } else if (name == null && age != null && id == null) {
            optional = personageService.findAllByAge(age);
        } else {
            optional = personageService.findAllByIdMovie(id);
        }
        return optional.map(personageMovieDtos -> new ResponseEntity<>(personageMovieDtos, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/detail")
    private ResponseEntity<List<PersonageMovieDto>> getAllByPersonageAndMovie() {
        return personageService.getAllPersonagesAndMovies()
                .map(personageMovieDtos -> new ResponseEntity<>(personageMovieDtos, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
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
