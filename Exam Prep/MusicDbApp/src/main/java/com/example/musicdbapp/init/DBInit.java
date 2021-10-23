package com.example.musicdbapp.init;

import com.example.musicdbapp.model.entity.ArtistEntity;
import com.example.musicdbapp.model.entity.enums.ArtistEnum;
import com.example.musicdbapp.repository.ArtistRepository;
import com.example.musicdbapp.utils.Utility;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DBInit implements CommandLineRunner {
    private final ArtistRepository artistRepository;

    public DBInit(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public void run(String... args) {
        if (artistRepository.count() == 0) {
            ArtistEnum[] values = ArtistEnum.values();

            for (int i = 0; i < values.length; i++) {
                ArtistEntity artistEntity = new ArtistEntity();
                artistEntity.setName(values[i]);
                switch (values[i].name()) {
                    case "QUEEN" : artistEntity.setCareerInformation(Utility.QUEEN_CAREER_INFO);
                        break;
                    case "METALLICA" : artistEntity.setCareerInformation(Utility.METALLICA_CAREER_INFO);
                        break;
                    case "MADONNA" : artistEntity.setCareerInformation(Utility.MADONNA_CAREER_INFO);
                        break;
                }

                artistRepository.save(artistEntity);
            }
        }
    }
}
