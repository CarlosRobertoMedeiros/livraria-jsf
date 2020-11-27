package br.com.roberto.estudos.livraria.bean;

import br.com.roberto.estudos.livraria.dao.DAO;
import br.com.roberto.estudos.livraria.modelo.Autor;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.io.Serializable;

@ManagedBean
public class AutorBean implements Serializable {

    private Autor autor = new Autor();

    @Inject
    private DAO<Autor> dao;

    public Autor getAutor() {
        return autor;
    }

    public void gravar() {
        System.out.println("Gravando autor " + this.autor.getNome());

        if (this.autor.getId() == null) {
            this.dao.adiciona(this.autor);
        } else {
            this.dao.atualiza(this.autor);
        }
    }

}
