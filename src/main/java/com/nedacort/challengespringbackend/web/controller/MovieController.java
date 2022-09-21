package com.nedacort.challengespringbackend.web.controller;

import com.nedacort.challengespringbackend.domain.MovieDto;
import com.nedacort.challengespringbackend.domain.MovieDtoDetail;
import com.nedacort.challengespringbackend.domain.MovieDtoLimited;
import com.nedacort.challengespringbackend.domain.MoviePersonageDto;
import com.nedacort.challengespringbackend.domain.service.MovieService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {


    @Autowired
    private MovieService movieService;


    @GetMapping("/all")
    @ApiOperation(value = "Listado de peliculas con los campos imagen, titulo" +
            "y fecha de creacion")
    @ApiResponse(code = 201, message = "OK")
    public ResponseEntity<List<MovieDtoLimited>> getAll() {
        return new ResponseEntity<>(movieService.getAllLimited(), HttpStatus.OK);
    }

    @GetMapping("/detail")
    @ApiOperation(value = "Listado de Peliculas junto a sus personajes asociados")
    public ResponseEntity<List<MoviePersonageDto>> getAllP() {
        return new ResponseEntity<>(movieService.getAllMovieAndPersonage().get(), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "Busqueda de personajes por nombre, y filtrar por edad y " +
            "las peliculas en las que participo ")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "OK"),
            @ApiResponse(code = 400, message = "Peticion invalida")})
    public ResponseEntity<List<MovieDto>> getSearch(@RequestParam(value = "name", required = false) String name,
                                                    @RequestParam(value = "genre", required = false) Integer id,
                                                    @RequestParam(value = "order", required = false) String order) {
        Optional<List<MovieDto>> optional = null;
        if (name != null && id == null && order == null) {
            optional = movieService.getByName(name);
        }
        if (name == null && id != null && order == null) {
            optional = movieService.getByIdGenre(id);
        }
        if (name == null && id == null && order != null) {
            if (order.equalsIgnoreCase("desc")) {
                optional = movieService.findAllByCreationDateDesc();
            } else {
                optional = movieService.findAllByCreationDateAsc();
            }
        }
        return optional.map(movieDtos -> new ResponseEntity<>(movieDtos, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @ApiOperation(value = "Creacion de una pelicula")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Pelicua creada"),
            @ApiResponse(code = 400, message = "peticion invalida")})
    public ResponseEntity<MovieDto> save(@RequestBody MovieDto movieDto) {
        return new ResponseEntity<>(movieService.save(movieDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "Edicion de los atributos de una Pelicula")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Pelicua actualizada"),
            @ApiResponse(code = 404, message = "Pelicula no encontrada")})
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
    @ApiOperation(value = "Eliminar pelicula por Id")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "OK"),
            @ApiResponse(code = 404, message = "Pelicula no encontrada")})
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        return movieService.delete(id) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
