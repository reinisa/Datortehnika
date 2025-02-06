package com.example.datortehnikawebsystem.service;

import com.example.datortehnikawebsystem.model.Pieprasijums;
import com.example.datortehnikawebsystem.model.Tehnika;
import com.example.datortehnikawebsystem.paramsEnum.Params;
import com.example.datortehnikawebsystem.paramsEnum.Status;
import com.example.datortehnikawebsystem.repository.PieprasijumsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

class PieprasijumsServiceTest {

    @Mock
    private PieprasijumsRepository pieprasijumsRepository;

    @InjectMocks
    private PieprasijumsService pieprasijumsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private Tehnika getTehnika() {
        Tehnika tehnika = new Tehnika();
        tehnika.setId(1L);
        tehnika.setNosaukums("nosaukums");
        tehnika.setApraksts("apraksts");
        return tehnika;
    }

    private Pieprasijums getPieprasijums() {
        Pieprasijums pieprasijums = new Pieprasijums();
        pieprasijums.setId(1L);
        pieprasijums.setTehnika(getTehnika());
        pieprasijums.setDatums(LocalDateTime.of(2025, 2, 5, 0, 0));
        pieprasijums.setParametri(Params.JAUNS);
        pieprasijums.setPamatojums("pamatojums");
        pieprasijums.setStatus(Status.IESNIEGTS);
        return pieprasijums;
    }

    @Test
    void findAll() {
        Pieprasijums pieprasijums1 = getPieprasijums();
        Pieprasijums pieprasijums2 = getPieprasijums();
        pieprasijums2.setId(2L);
        pieprasijums2.setPamatojums("pamatojums2");

        List<Pieprasijums> mockPieprasijumi = List.of(pieprasijums1, pieprasijums2);

        when(pieprasijumsRepository.findAll()).thenReturn(mockPieprasijumi);

        List<Pieprasijums> pieprasijumsList = pieprasijumsService.findAll();

        assertFalse(pieprasijumsList.isEmpty());
        assertEquals(2, pieprasijumsList.size());
        assertEquals(1L, pieprasijumsList.get(0).getId());
        assertEquals("pamatojums", pieprasijumsList.get(0).getPamatojums());

        assertEquals(2L, pieprasijumsList.get(1).getId());
        assertEquals("pamatojums2", pieprasijumsList.get(1).getPamatojums());
    }


    @Test
    void createPieprasijums_successfull() {
        Pieprasijums pieprasijums = getPieprasijums();
        pieprasijums.setId(null);

        when(pieprasijumsRepository.save(pieprasijums)).thenReturn(getPieprasijums());

        Pieprasijums result = pieprasijumsService.createPieprasijums(pieprasijums);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("pamatojums", result.getPamatojums());

        verify(pieprasijumsRepository, times(1)).save(pieprasijums);
    }

    @Test
    void createPieprasijums_invalid() {
        Pieprasijums pieprasijums = getPieprasijums();
        pieprasijums.setId(99L);
        pieprasijums.setPamatojums("Invalid");

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> pieprasijumsService.createPieprasijums(pieprasijums)
        );

        assertEquals("ID should not be provided when creating a new Pieprasijums.", exception.getMessage());

        verify(pieprasijumsRepository, never()).save(any());
    }

    @Test
    void findById() {
        Pieprasijums pieprasijums = getPieprasijums();

        when(pieprasijumsRepository.findById(1L)).thenReturn(Optional.of(pieprasijums));

        Pieprasijums foundPieprasijums = pieprasijumsService.findById(1L);

        assertNotNull(foundPieprasijums);
        assertEquals(1L, foundPieprasijums.getId());
        assertEquals("pamatojums", foundPieprasijums.getPamatojums());
    }

    @Test
    void updatePieprasijums() {
        Pieprasijums pieprasijums = getPieprasijums();

        Pieprasijums updatedPieprasijums = new Pieprasijums();
        updatedPieprasijums.setId(1L);
        updatedPieprasijums.setStatus(Status.APSTIPRINATS);

        when(pieprasijumsRepository.findById(1L)).thenReturn(Optional.of(pieprasijums));
        when(pieprasijumsRepository.save(pieprasijums)).thenReturn(updatedPieprasijums);

        Pieprasijums result = pieprasijumsService.updatePieprasijums(1L, Status.APSTIPRINATS);

        assertNotNull(result);
        assertEquals(Status.APSTIPRINATS, result.getStatus());

        verify(pieprasijumsRepository, times(1)).findById(1L);
        verify(pieprasijumsRepository, times(1)).save(pieprasijums);
    }

    @Test
    void deletePieprasijums() {
        Pieprasijums pieprasijums = getPieprasijums();

        when(pieprasijumsRepository.findById(1L)).thenReturn(Optional.of(pieprasijums));

        String result = pieprasijumsService.deletePieprasijums(1L);

        assertEquals("Pieprasijums deleted", result);
        verify(pieprasijumsRepository, times(1)).delete(pieprasijums);
    }
}