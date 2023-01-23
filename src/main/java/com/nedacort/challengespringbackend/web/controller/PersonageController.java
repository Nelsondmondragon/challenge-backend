package com.nedacort.challengespringbackend.web.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characters")
public class PersonageController {
//
//
//    @Autowired
//    private PersonageService personageService;
//
//
//    @GetMapping("/all")
//    @ApiOperation(value = "Listado de personajes mostrando su imagen y nombre")
//    @ApiResponse(code = 200, message = "OK")
//    private ResponseEntity<List<PersonageDtoLimited>> getAll() {
//        return new ResponseEntity<>(personageService.getAllNameAndImage(), HttpStatus.OK);
//    }
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
