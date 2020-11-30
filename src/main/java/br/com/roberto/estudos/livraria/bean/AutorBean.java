package br.com.roberto.estudos.livraria.bean;

import br.com.roberto.estudos.livraria.dao.GenericCrudDAO;
import br.com.roberto.estudos.livraria.modelo.Autor;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
public class AutorBean implements Serializable {

    @Inject
    private GenericCrudDAO<Autor> dao;

    private Autor autor = new Autor();

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
