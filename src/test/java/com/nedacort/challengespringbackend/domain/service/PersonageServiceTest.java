package com.nedacort.challengespringbackend.domain.service;

import com.nedacort.challengespringbackend.domain.PersonageDto;
import com.nedacort.challengespringbackend.domain.repository.PersonageDtoLimitedRepository;
import com.nedacort.challengespringbackend.domain.repository.PersonageDtoRepository;
import com.nedacort.challengespringbackend.domain.repository.PersonageMovieDtoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PersonageServiceTest {

    @Mock
    private PersonageDtoLimitedRepository personageDtoLimitedRepository;

    @Mock
    private PersonageMovieDtoRepository personageMovieDtoRepository;

    @Mock
    private PersonageDtoRepository personageDtoRepository;

    @InjectMocks
    private PersonageService personageService;

    @Captor
    private ArgumentCaptor<PersonageDto> argumentCaptor;

    @Test
    void get_all_personages_and_movies() {
        personageService.getAllPersonagesAndMovies();
        verify(personageMovieDtoRepository).findAllPersonagesAndMovies();
    }

    @Test
    void get_all_personages_by_name_and_image() {
        personageService.getAllNameAndImage();
        verify(personageDtoLimitedRepository).getAllLimited();
    }

    @Test
    void get_personage_by_id() {
        personageService.getPersonageById(1);
        verify(personageDtoRepository).getPersonageById(1);
    }

    @Test
    void get_all_personages_by_name() {
        personageService.findAllByName("Nelson");
        verify(personageMovieDtoRepository).findAllByName("Nelson");
    }

    @Test
    void find_all_by_age() {
        personageService.findAllByAge(12);
        verify(personageMovieDtoRepository).findAllByAge(12);
    }

    @Test
    void findAllByIdMovie() {
        personageService.findAllByIdMovie(12);
        verify(personageMovieDtoRepository).findAllByIdMovie(12);
    }

    @Test
    void save() {
        PersonageDto personageDto = PersonageDto.builder()
                .id(1)
                .image(new byte[1])
                .name("Nelson")
                .history("Nelson")
                .peso(34)
                .build();
        personageService.save(personageDto);
        argumentCaptor = ArgumentCaptor.forClass(PersonageDto.class);
        verify(personageDtoRepository).save(argumentCaptor.capture());
        assertThat(personageDto).isEqualTo(argumentCaptor.getValue());
    }

    @Test
    void delete() {
        PersonageDto personageDto = PersonageDto.builder()
                .id(1)
                .image(new byte[1])
                .name("Nelson")
                .history("Nelson")
                .peso(34)
                .build();

        Mockito.when(personageService.getPersonageById(1))
                .thenReturn(Optional.of(personageDto));


        personageService.delete(personageDto.getId());
        verify(personageDtoRepository).delete(1);
    }

}