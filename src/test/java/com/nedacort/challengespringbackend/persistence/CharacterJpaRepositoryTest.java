package com.nedacort.challengespringbackend.persistence;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CharacterJpaRepositoryTest {

//
//    @Mock
//    private CharacterRepository characterRepository;
//
//    @Mock
//    private PersonajePeliculaCrudRepository personajePeliculaCrudRepository;
//
//    @Mock
//    private PersonageDtoMapper personageDtoMapper;
//
//    @Mock
//    private PersonageDtoLimitedMapper personageDtoLimitedMapper;
//
//    @InjectMocks
//    private PersonageRepository personageRepository;
//
//    @Captor
//    private ArgumentCaptor<Character> argumentCaptor;
//
//    private static Integer id = 1;
//
//    private static Integer age = 21;
//
//    private static String name = "Nelson";
//
//    @Test
//    void get_all_personages_with_the_image_and_the_name() {
//        personageRepository.getAllLimited();
//        verify(characterRepository).findAll();
//    }
//
//    @Test
//    void get_personage_by_id() {
//        personageRepository.getPersonageById(id);
//        verify(characterRepository).findById(id);
//    }
//
//    @Test
//    void get_all_personages_and_movies() {
//        personageRepository.findAllPersonagesAndMovies();
//        verify(personajePeliculaCrudRepository).findAllPersonajesAndPeliculas();
//    }
//
//    @Test
//    void get_all_personages_by_name() {
//        personageRepository.findAllByName(name);
//        verify(personajePeliculaCrudRepository).findAllByNombre(name);
//    }
//
//    @Test
//    void get_all_personages_by_age() {
//        personageRepository.findAllByAge(age);
//        verify(personajePeliculaCrudRepository).findAllByEdad(age);
//    }
//
//    @Test
//    void get_all_personages_by_id_movie() {
//        personageRepository.findAllByIdMovie(id);
//        verify(personajePeliculaCrudRepository).findAllByIdPelicula(id);
//    }
//
//    @Test
//    void save() {
//        PersonageDto personageDto = PersonageDto.builder()
//                .id(id)
//                .image(new byte[2])
//                .name("Nelson")
//                .age(12)
//                .peso(234)
//                .history("Ojo con esoo")
//                .build();
//
//        Mockito.when(personageDtoMapper.toPersonaje(personageDto)).thenReturn(
//                Character.builder()
//                        .id(personageDto.getId())
//                        .image(personageDto.getImage())
//                        .name(personageDto.getName())
//                        .age(personageDto.getAge())
//                        .history(personageDto.getHistory())
//                        .build()
//        );
//
//        personageRepository.save(personageDto);
//        argumentCaptor = ArgumentCaptor.forClass(Character.class);
//        verify(characterRepository).save(argumentCaptor.capture());
//        Assertions.assertThat(personageDto.getId()).isEqualTo(argumentCaptor.getValue().getId());
//
//    }
//
//    @Test
//    void delete() {
//        personageRepository.delete(id);
//        verify(characterRepository).deleteById(id);
//    }
}