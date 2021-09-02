package com.nedacort.challengespringbackend.web.controller;

import com.nedacort.challengespringbackend.domain.MovieDto;
import com.nedacort.challengespringbackend.domain.MovieDtoDetail;
import com.nedacort.challengespringbackend.domain.MovieDtoLimited;
import com.nedacort.challengespringbackend.domain.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {


    @Autowired
    private MovieService movieService;


    @GetMapping("/all")
    private ResponseEntity<List<MovieDtoLimited>> getAll() {
        return new ResponseEntity<>(movieService.getAllLimited(), HttpStatus.OK);
    }

    @GetMapping("/detail")
    private ResponseEntity<List<MovieDtoDetail>> getAllP() {
        return new ResponseEntity<>(movieService.getAllDetails(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<MovieDto> save(@RequestBody MovieDto movieDto) {
        return new ResponseEntity<>(movieService.save(movieDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MovieDto> update(@RequestBody MovieDto movieDto, @PathVariable Integer id) {
        MovieDto movieDtoActual = movieService.getById(id).get();
        movieDtoActual.setImage(movieDto.getImage());
        movieDtoActual.setTittle(movieDto.getTittle());
        movieDtoActual.setCreationDate(movieDto.getCreationDate());
        movieDtoActual.setIdGenus(movieDto.getIdGenus());
        movieDtoActual.setIdQualification(movieDto.getIdQualification());
        return new ResponseEntity<>(movieService.save(movieDtoActual), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        return movieService.delete(id) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
