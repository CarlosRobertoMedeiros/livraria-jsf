package br.com.roberto.estudos.livraria.dao;
/*
 *  @criado em: 26/11/2020 - {23:21}
 *  @projeto  : livraria-jsf
 *  @autor    : roberto
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("livrariaDS");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void close(EntityManager em) {
        em.close();
    }
}
