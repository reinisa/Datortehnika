package com.example.datortehnikawebsystem.dataLoader;

import com.example.datortehnikawebsystem.model.Pieprasijums;
import com.example.datortehnikawebsystem.model.Tehnika;
import com.example.datortehnikawebsystem.paramsEnum.Params;
import com.example.datortehnikawebsystem.paramsEnum.Status;
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
    public void run(String... args) {
        Tehnika tehnika1 = new Tehnika();
        tehnika1.setNosaukums("Portatīvais dators");
        tehnika1.setApraksts("Apple Macbook Pro M1 ar 13,3 collu ekrānu un ilgstošu akumulatora darbību");
        tehnikaRepository.save(tehnika1);

        Tehnika tehnika2 = new Tehnika();
        tehnika2.setNosaukums("Lāzerprinteris");
        tehnika2.setApraksts("Augstas izšķirtspējas LaserJet M110w HP ar automātisko divpusējo drukāšanu");
        tehnikaRepository.save(tehnika2);

        Tehnika tehnika3 = new Tehnika();
        tehnika3.setNosaukums("3D skeneris");
        tehnika3.setApraksts("Revopoint Range 2 objektu digitalizēšanai ar augstu detalizācijas pakāpi un plašu pielietojumu");
        tehnikaRepository.save(tehnika3);

        Tehnika tehnika4 = new Tehnika();
        tehnika4.setNosaukums("Tastatūra");
        tehnika4.setApraksts("Bezvadu Logitech MX ar ergonomisku dizainu, klusiem taustiņiem un pielāgojamu izgaismojumu");
        tehnikaRepository.save(tehnika4);

        Tehnika tehnika5 = new Tehnika();
        tehnika5.setNosaukums("Skeneris");
        tehnika5.setApraksts("Epson DS-1630 ar OCR tehnoloģiju, kas ļauj pārvērst papīra dokumentus rediģējamos failos");
        tehnikaRepository.save(tehnika5);

        Tehnika tehnika6 = new Tehnika();
        tehnika6.setNosaukums("Viedpulkstenis");
        tehnika6.setApraksts("SmartWatch Z3, kas ļauj uzraudzīt veselību un saņemt paziņojumus");
        tehnikaRepository.save(tehnika6);

        Pieprasijums pieprasijums1 = new Pieprasijums();
        pieprasijums1.setTehnika(tehnika1);
        pieprasijums1.setDatums(LocalDateTime.now());
        pieprasijums1.setPamatojums("Pamatojums Pieprasijums 1");
        pieprasijums1.setParametri(Params.LIETOTS);
        pieprasijums1.setStatus(Status.IESNIEGTS);
        pieprasijumsRepository.save(pieprasijums1);

        Pieprasijums pieprasijums2 = new Pieprasijums();
        pieprasijums2.setTehnika(tehnika2);
        pieprasijums2.setDatums(LocalDateTime.now().plusDays(1));
        pieprasijums2.setPamatojums("Pamatojums Pieprasijums 2");
        pieprasijums2.setParametri(Params.MAZLIETOTS);
        pieprasijums2.setStatus(Status.IESNIEGTS);
        pieprasijumsRepository.save(pieprasijums2);

        Pieprasijums pieprasijums3 = new Pieprasijums();
        pieprasijums3.setTehnika(tehnika3);
        pieprasijums3.setDatums(LocalDateTime.now().plusDays(2));
        pieprasijums3.setPamatojums("Pamatojums Pieprasijums 3");
        pieprasijums3.setParametri(Params.MAZLIETOTS);
        pieprasijums3.setStatus(Status.IESNIEGTS);
        pieprasijumsRepository.save(pieprasijums3);

        Pieprasijums pieprasijums4 = new Pieprasijums();
        pieprasijums4.setTehnika(tehnika2);
        pieprasijums4.setDatums(LocalDateTime.now());
        pieprasijums4.setPamatojums("Pamatojums Pieprasijums 4");
        pieprasijums4.setParametri(Params.JAUNS);
        pieprasijums4.setStatus(Status.IESNIEGTS);
        pieprasijumsRepository.save(pieprasijums4);

        Pieprasijums pieprasijums5 = new Pieprasijums();
        pieprasijums5.setTehnika(tehnika4);
        pieprasijums5.setDatums(LocalDateTime.now().plusDays(1));
        pieprasijums5.setPamatojums("Pamatojums Pieprasijums 5");
        pieprasijums5.setParametri(Params.LIETOTS);
        pieprasijums5.setStatus(Status.IESNIEGTS);
        pieprasijumsRepository.save(pieprasijums5);

        Pieprasijums pieprasijums6 = new Pieprasijums();
        pieprasijums6.setTehnika(tehnika6);
        pieprasijums6.setDatums(LocalDateTime.now().plusDays(3));
        pieprasijums6.setPamatojums("Pamatojums Pieprasijums 6");
        pieprasijums6.setParametri(Params.MAZLIETOTS);
        pieprasijums6.setStatus(Status.IESNIEGTS);
        pieprasijumsRepository.save(pieprasijums6);

        Pieprasijums pieprasijums7 = new Pieprasijums();
        pieprasijums7.setTehnika(tehnika5);
        pieprasijums7.setDatums(LocalDateTime.now().plusDays(1));
        pieprasijums7.setPamatojums("Pamatojums Pieprasijums 7");
        pieprasijums7.setParametri(Params.LIETOTS);
        pieprasijums7.setStatus(Status.IESNIEGTS);
        pieprasijumsRepository.save(pieprasijums7);

        Pieprasijums pieprasijums8 = new Pieprasijums();
        pieprasijums8.setTehnika(tehnika1);
        pieprasijums8.setDatums(LocalDateTime.now().minusDays(1));
        pieprasijums8.setPamatojums("Pamatojums Pieprasijums 8");
        pieprasijums8.setParametri(Params.JAUNS);
        pieprasijums8.setStatus(Status.IESNIEGTS);
        pieprasijumsRepository.save(pieprasijums8);

        Pieprasijums pieprasijums9 = new Pieprasijums();
        pieprasijums9.setTehnika(tehnika3);
        pieprasijums9.setDatums(LocalDateTime.now().minusDays(2));
        pieprasijums9.setPamatojums("Pamatojums Pieprasijums 9");
        pieprasijums9.setParametri(Params.JAUNS);
        pieprasijums9.setStatus(Status.IESNIEGTS);
        pieprasijumsRepository.save(pieprasijums9);

        Pieprasijums pieprasijums10 = new Pieprasijums();
        pieprasijums10.setTehnika(tehnika5);
        pieprasijums10.setDatums(LocalDateTime.now().plusDays(4).minusYears(1));
        pieprasijums10.setPamatojums("Pamatojums Pieprasijums 10");
        pieprasijums10.setParametri(Params.MAZLIETOTS);
        pieprasijums10.setStatus(Status.IESNIEGTS);
        pieprasijumsRepository.save(pieprasijums10);
    }
}
