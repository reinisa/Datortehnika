package com.example.datortehnikawebsystem.dataLoader;

import com.example.datortehnikawebsystem.model.Pieprasijums;
import com.example.datortehnikawebsystem.model.Tehnika;
import com.example.datortehnikawebsystem.paramsEnum.Params;
import com.example.datortehnikawebsystem.repository.PieprasijumsRepository;
import com.example.datortehnikawebsystem.repository.TehnikaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final PieprasijumsRepository pieprasijumsRepository;
    private final TehnikaRepository tehnikaRepository;

    public DataLoader(PieprasijumsRepository pieprasijumsRepository, TehnikaRepository tehnikaRepository) {
        this.pieprasijumsRepository = pieprasijumsRepository;
        this.tehnikaRepository = tehnikaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create Tehnika objects
        Tehnika tehnika1 = new Tehnika();
        tehnika1.setId(1L);
        tehnika1.setNosaukums("Tehnika 1");
        tehnika1.setApraksts("Description for Tehnika 1");
        tehnikaRepository.save(tehnika1);

        Tehnika tehnika2 = new Tehnika();
        tehnika2.setId(2L);
        tehnika2.setNosaukums("Tehnika 2");
        tehnika2.setApraksts("Description for Tehnika 2");
        tehnikaRepository.save(tehnika2);

        // Create Pieprasijums (Request) objects
        Pieprasijums pieprasijums1 = new Pieprasijums();
        pieprasijums1.setId(1L);
        pieprasijums1.setTehnika(tehnika1);
        pieprasijums1.setDatums(LocalDateTime.now());
        pieprasijums1.setPamatojums("Reason for Pieprasijums 1");
        pieprasijums1.setParametri(Params.LIETOTS);
        pieprasijumsRepository.save(pieprasijums1);

        Pieprasijums pieprasijums2 = new Pieprasijums();
        pieprasijums2.setId(2L);
        pieprasijums2.setTehnika(tehnika2);
        pieprasijums2.setDatums(LocalDateTime.now().plusDays(1));
        pieprasijums2.setPamatojums("Reason for Pieprasijums 2");
        pieprasijums2.setParametri(Params.MAZLIETOTS);
        pieprasijumsRepository.save(pieprasijums2);
    }
}
