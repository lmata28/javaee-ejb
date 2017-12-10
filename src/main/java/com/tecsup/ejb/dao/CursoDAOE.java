package com.tecsup.ejb.dao;

import com.tecsup.ejb.model.Curso;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class CursoDAOE implements CursoDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Curso> all() {
        TypedQuery<Curso> query
                = em.createQuery("Select a from Curso a", Curso.class);
        return query.getResultList();
    }

    @Override
    public Curso find(Long id) {
        return em.find(Curso.class, id);
    }

    @Override
    public void save(Curso curso) {
        em.persist(curso);
    }

    @Override
    public void update(Curso curso) {
        em.merge(curso);
    }

    @Override
    public void delete(Curso curso) {
        Curso delete = em.merge(curso);
        em.remove(delete);
    }
}
