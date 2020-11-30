package br.com.roberto.estudos.livraria.dao;
/*
 *  @criado em: 26/11/2020 - {23:20}
 *  @projeto  : livraria-jsf
 *  @autor    : roberto
 */

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Named
public class GenericCrudDAO<T>{

    private Class<T> classe = null;

    @Inject
    private JPAUtil jpaUtil;

    public GenericCrudDAO() {
    }

    public GenericCrudDAO(Class<T> classe) {
        this.classe = classe;
    }

    public void adiciona(T t) {

        // consegue a entity manager
        EntityManager em = jpaUtil.getEntityManager();

        // abre transacao
        em.getTransaction().begin();

        // persiste o objeto
        em.persist(t);

        // commita a transacao
        em.getTransaction().commit();

        // fecha a entity manager
        em.close();
    }

    public void remove(T t) {
        EntityManager em = jpaUtil.getEntityManager();
        em.getTransaction().begin();

        em.remove(em.merge(t));

        em.getTransaction().commit();
        em.close();
    }

    public void atualiza(T t) {
        EntityManager em = jpaUtil.getEntityManager();
        em.getTransaction().begin();

        em.merge(t);

        em.getTransaction().commit();
        em.close();
    }

    public List<T> listaTodos() {
        CriteriaQuery<T> query = jpaUtil.getEntityManager().getCriteriaBuilder().createQuery(classe);
        query.select(query.from(classe));

        List<T> lista = jpaUtil.getEntityManager().createQuery(query).getResultList();

        jpaUtil.close();
        return lista;
    }

    public T buscaPorId(Integer id) {
        T instancia = jpaUtil.getEntityManager().find(classe, id);
        jpaUtil.close();
        return instancia;
    }

    public int contaTodos() {
        long result = (Long) jpaUtil.getEntityManager().createQuery("select count(n) from livro n")
                .getSingleResult();
        jpaUtil.close();

        return (int) result;
    }

    public List<T> listaTodosPaginada(int firstResult, int maxResults) {
        CriteriaQuery<T> query = jpaUtil.getEntityManager().getCriteriaBuilder().createQuery(classe);
        query.select(query.from(classe));

        List<T> lista = jpaUtil.getEntityManager().createQuery(query).setFirstResult(firstResult)
                .setMaxResults(maxResults).getResultList();

        jpaUtil.close();
        return lista;
    }

}
