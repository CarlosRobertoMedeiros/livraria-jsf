package br.com.roberto.estudos.livraria.modelo;
/*
 *  @criado em: 26/11/2020 - {23:11}
 *  @projeto  : livraria-jsf
 *  @autor    : roberto
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Autor {

    @Id
    @GeneratedValue
    private Integer id;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
