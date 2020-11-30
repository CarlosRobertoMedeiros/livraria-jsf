package br.com.roberto.estudos.livraria.dao;
/*
 *  @criado em: 26/11/2020 - {23:21}
 *  @projeto  : livraria-jsf
 *  @autor    : roberto
 */

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@Named
public class JPAUtil {

    @PersistenceContext(unitName = "livrariaDS")
    private EntityManager emf;

//    private static EntityManagerFactory emf = Persistence
//            .createEntityManagerFactory("livrariaDS");

    public EntityManager getEntityManager() {
//        return emf.createEntityManager();
        return emf;
    }

    public void close() {
        emf.close();
    }
}
