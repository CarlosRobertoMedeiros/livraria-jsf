package br.com.roberto.estudos.livraria.modelo;
/*
 *  @criado em: 26/11/2020 - {23:11}
 *  @projeto  : livraria-jsf
 *  @autor    : roberto
 */

import javax.persistence.*;
import java.lang.annotation.Target;

@Entity
@Table(name = "TB_Autor" , schema = "app")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
