package com.alessandro.promo.tests;


import com.alessandro.promo.models.Promo;
import com.alessandro.promo.repositories.PromoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class Teste implements CommandLineRunner {

    @Autowired
    private final PromoRepository repository;

    public Teste(PromoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        Promo p1 = new Promo(null, "sofa", "www.casasbahia.com", 555.00);
        Promo p2 = new Promo(null, "cama", "www.pontofrio.com", 1555.00);
        Promo p3 = new Promo(null, "tv", "www.americanas.com", 5585.00);


        repository.saveAll(Arrays.asList(p1,p2,p3));


    }
}
