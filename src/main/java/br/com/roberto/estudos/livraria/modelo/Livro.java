package br.com.roberto.estudos.livraria.modelo;
/*
 *  @criado em: 26/11/2020 - {23:03}
 *  @projeto  : livraria-jsf
 *  @autor    : roberto
 */

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "TB_Livro" , schema = "app")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String titulo;
    private String isbn;
    private double preco;

    @Temporal(TemporalType.DATE)
    private Calendar dataLancamento = Calendar.getInstance();

    @ManyToMany
    private List<Autor> autores = new ArrayList<Autor>();

    public List<Autor> getAutores() {
        return autores;
    }

    public void adicionaAutor(Autor autor) {
        this.autores.add(autor);
    }

    public Livro() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Calendar getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Calendar dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
