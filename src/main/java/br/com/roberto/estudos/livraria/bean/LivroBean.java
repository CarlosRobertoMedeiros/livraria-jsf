package br.com.roberto.estudos.livraria.bean;

import br.com.roberto.estudos.livraria.dao.DAO;
import br.com.roberto.estudos.livraria.modelo.Autor;
import br.com.roberto.estudos.livraria.modelo.Livro;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

@ManagedBean
public class LivroBean {

    private Livro livro = new Livro();

    @Inject
    private DAO<Livro> dao;

    public Livro getLivro() {
        return livro;
    }

    public void gravar() {
        System.out.println("Gravando livro "+ this.livro.getTitulo());

        if (livro.getAutores().isEmpty()){
            throw  new RuntimeException("Livro Deve ter pelo menos 1 Autor");
        }

        if (this.livro.getId() == null) {
            this.dao.adiciona(this.livro);
        } else {
            this.dao.atualiza(this.livro);
        }

    }

}
