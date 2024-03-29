package com.nedacort.challengespringbackend.web.controller;

import com.nedacort.challengespringbackend.domain.CharacterDetailsDto;
import com.nedacort.challengespringbackend.domain.CharacterDto;
import com.nedacort.challengespringbackend.domain.CharacterIdMovieDto;
import com.nedacort.challengespringbackend.domain.CharacterListDto;
import com.nedacort.challengespringbackend.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterControllerRest {


    @Autowired
    private CharacterService characterService;


    @GetMapping()
//    @ApiOperation(value = "Listado de personajes mostrando su imagen y nombre")
//    @ApiResponse(code = 200, message = "OK")
    private ResponseEntity<List<?>> findAll(@RequestParam(required = false) String name,
                                            @RequestParam(required = false) Integer age,
                                            @RequestParam(required = false) Long idmovie) {

        if (name != null && age == null && idmovie == null) {
            return new ResponseEntity<>(characterService.findByName(name), HttpStatus.OK);
        }
        if (name == null && age != null && idmovie == null) {
            return new ResponseEntity<>(characterService.findByAge(age), HttpStatus.OK);
        }
        if (name == null && age == null && idmovie != null) {
            return new ResponseEntity<>(characterService.findByIdMovie(idmovie), HttpStatus.OK);
        }

        return new ResponseEntity<>(characterService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    private ResponseEntity<CharacterDetailsDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(characterService.findById(id), HttpStatus.OK);
    }


    @PostMapping()
    private ResponseEntity<CharacterDetailsDto> save(@RequestBody CharacterIdMovieDto characterDto) {
        return new ResponseEntity<>(characterService.save(characterDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<CharacterDto> update(@PathVariable Long id, @RequestBody CharacterIdMovieDto characterIdMovieDto) {
        return new ResponseEntity<>(characterService.update(id, characterIdMovieDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<CharacterDto> delete(@PathVariable Long id) {
        characterService.delete(id);
        return ResponseEntity.noContent().build();
    }


//
//
//    @GetMapping
//    @ApiOperation(value = "Busqueda de personajes por nombre, y filtrar por edad y" +
//            "las peliculas en las que participo ")
//    @ApiResponses(value = {@ApiResponse(code = 201, message = "OK"),
//            @ApiResponse(code = 400, message = "Peticion invalida")})
//    private ResponseEntity<List<PersonageMovieDto>> getSearch(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "age", required = false) Integer age
//            , @RequestParam(value = "movie", required = false) Integer id) {
//        Optional<List<PersonageMovieDto>> optional = null;
//        if (name != null && age == null && id == null) {
//            optional = personageService.findAllByName(name);
//        } else if (name == null && age != null && id == null) {
//            optional = personageService.findAllByAge(age);
//        } else {
//            optional = personageService.findAllByIdMovie(id);
//        }
//        return optional.map(personageMovieDtos -> new ResponseEntity<>(personageMovieDtos, HttpStatus.OK))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//
//    @GetMapping("/detail")
//    @ApiOperation(value = "Listado de Personajes con sus atributos y peliculas relacionadas")
//    @ApiResponse(code = 201, message = "OK")
//    private ResponseEntity<List<PersonageMovieDto>> getAllByPersonageAndMovie() {
//        return personageService.getAllPersonagesAndMovies()
//                .map(personageMovieDtos -> new ResponseEntity<>(personageMovieDtos, HttpStatus.OK))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @PostMapping("/save")
//    @ApiOperation(value = "Creacion de un personaje")
//    @ApiResponses(value = {@ApiResponse(code = 201, message = "Personaje creado"),
//            @ApiResponse(code = 400, message = "Peticion invalida")})
//    public ResponseEntity<PersonageDto> save(@RequestBody PersonageDto personageDto) {
//        return new ResponseEntity<>(personageService.save(personageDto), HttpStatus.CREATED);
//    }
//
//    @PutMapping("/update/{id}")
//    @ApiOperation(value = "Actualizacion de los atributos de un personaje")
//    @ApiResponses(value = {@ApiResponse(code = 201, message = "Actualizacion exitosa"),
//            @ApiResponse(code = 400, message = "Personaje no encontrado")})
//    public ResponseEntity<PersonageDto> update(@RequestBody PersonageDto personageDto, @PathVariable Integer id) {
//        PersonageDto personageDtoActual = personageService.getPersonageById(id).get();
//        personageDtoActual.setName(personageDto.getName());
//        personageDtoActual.setAge(personageDto.getAge());
//        personageDtoActual.setImage(personageDto.getImage());
//        personageDtoActual.setHistory(personageDto.getHistory());
//        return new ResponseEntity<>(personageService.save(personageDtoActual), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    @ApiOperation(value = "Eliminacion de un personaje por Id")
//    @ApiResponses(value = {@ApiResponse(code = 201, message = "Personaje Eliminado"),
//            @ApiResponse(code = 404, message = "Personaje no encontrado")})
//    public ResponseEntity delete(@PathVariable("id") Integer id) {
//        return personageService.delete(id) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
//    }

}
