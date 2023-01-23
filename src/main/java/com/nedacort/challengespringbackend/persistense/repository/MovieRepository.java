package com.nedacort.challengespringbackend.persistense.repository;

//@Repository
public class MovieRepository {}
// implements MovieDtoLimitedRepository, MovieDtoRepository, MoviePersonageDtoRepository {
//
//    @Autowired
//    private MovieCrudRepository peliculaCrudRepository;
//
//    @Autowired
//    private PersonajePeliculaCrudRepository personajePeliculaCrudRepository;
//
//    @Autowired
//    private MovieDtoLimitedMapper movieDtoLimitedMapper;
//
//    @Autowired
//    PersonageMovieDtoMapper personageMovieDtoMapper;
//
//    @Autowired
//    private MovieDtoMapper movieDtoMapper;
//
//    @Autowired
//    private MoviePersonageDtoMapper moviePersonageDtoMapper;
//
//    @Override
//    public List<MovieDtoLimited> getAllLimited() {
//        return movieDtoLimitedMapper.toMovieDtoLimiteds((List<Movie>) peliculaCrudRepository.findAll());
//    }
//
//    @Override
//    public Optional<MovieDto> getById(Integer id) {
//        return peliculaCrudRepository.findById(id)
//                .map(pelicula -> movieDtoMapper.toMovieDto(pelicula));
//    }
//
//    @Override
//    public Optional<List<MovieDto>> getByName(String name) {
//        return peliculaCrudRepository.findByName(name)
//                .map(peliculas -> movieDtoMapper.toMovieDtos(peliculas));
//    }
//
//    @Override
//    public Optional<List<MovieDto>> getByIdGenre(Integer id) {
//        return peliculaCrudRepository.findByIdGenero(id)
//                .map(peliculas -> movieDtoMapper.toMovieDtos(peliculas));
//    }
//
//    @Override
//    public Optional<List<MovieDto>> findAllByCreationDateDesc() {
//        return peliculaCrudRepository.findAllByFechaCreacionDesc()
//                .map(peliculas -> movieDtoMapper.toMovieDtos(peliculas));
//    }
//
//    @Override
//    public Optional<List<MovieDto>> findAllByCreationDateAsc() {
//        return peliculaCrudRepository.findAllByFechaCreacionAsc()
//                .map(peliculas -> movieDtoMapper.toMovieDtos(peliculas));
//    }
//
//    @Override
//    public MovieDto save(MovieDto movieDto) {
//        return movieDtoMapper.toMovieDto(peliculaCrudRepository.save(movieDtoMapper.toPelicula(movieDto)));
//    }
//
//    @Override
//    public void delete(Integer id) {
//        peliculaCrudRepository.deleteById(id);
//    }
//
//    @Override
//    public Optional<List<MoviePersonageDto>> findAllMoviesAndPersonage() {
//        return personajePeliculaCrudRepository.findAllPersonajesAndPeliculas()
//                .map(personajePeliculas -> moviePersonageDtoMapper.toMoviePersonageDtos(personajePeliculas));
//    }
//}
