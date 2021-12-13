package com.alessandro.promo.repositories;

import com.alessandro.promo.models.Promo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromoRepository extends JpaRepository<Promo, Long> {

    Page<Promo> findAll(Pageable pageable);

    List<Promo> findByDescricao(String descricao);
}
