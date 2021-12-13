package com.alessandro.promo.services;

import com.alessandro.promo.models.Promo;
import com.alessandro.promo.repositories.PromoRepository;
import com.alessandro.promo.services.exceptions.DatabaseException;
import com.alessandro.promo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PromoService {

    @Autowired
    PromoRepository repository;

    public Promo findById(Long id) {
        Optional<Promo> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Page<Promo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Promo Cadastrar(Promo promo) {
        return repository.save(promo);
    }

    public Promo update(Long id, Promo promo) {
        try {
            Promo entity = findById(id);
            updateData(entity, promo);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Promo entity, Promo promo) {
        entity.setDescricao(promo.getDescricao());
        entity.setLink(promo.getLink());
        entity.setPreco(promo.getPreco());
    }

    public List<Promo> findByDescricao(String descricao) {
        return repository.findByDescricao(descricao);
    }

    public void deletar(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
