package com.alessandro.promo.DTO;

import com.alessandro.promo.models.Promo;

import java.util.Objects;

public class PromoDTO {

    private Long id;
    private String descricao;
    private String link;
    private Double preco;

    public PromoDTO() {
    }

    public PromoDTO(Long id, String descricao, String link, Double preco) {
        this.id = id;
        this.descricao = descricao;
        this.link = link;
        this.preco = preco;
    }

    public PromoDTO(Promo promo) {
        id = promo.getId();
        descricao = promo.getDescricao();
        link = promo.getLink();
        preco = promo.getPreco();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PromoDTO promo = (PromoDTO) o;
        return Objects.equals(id, promo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
