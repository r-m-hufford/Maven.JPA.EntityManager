package services;


import entities.Artist;
import entities.CD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CdService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persist");
    EntityManager em = emf.createEntityManager();

    public CD findById(Long id) {
        return em.find(CD.class, id);
    }

    public List<CD> findAll() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CD> cq = cb.createQuery(CD.class);
        Root<CD> rootEntry = cq.from(CD.class);
        CriteriaQuery<CD> all = cq.select(rootEntry);
        TypedQuery<CD> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    public boolean update(Long id, CD cd) {
        CD revise = em.find(CD.class, id);

        revise.setTitle(cd.getTitle());
        revise.setPrice(cd.getPrice());
        revise.setDescription(cd.getDescription());
        revise.setYear(cd.getYear());

        em.getTransaction().begin();
        em.persist(revise);
        em.getTransaction().commit();

        return true;
    }

    public boolean create(CD cd) {
        em.getTransaction().begin();
        em.persist(cd);
        em.getTransaction().commit();

        return true;
    }


    public void delete(long id) {

        em.getTransaction().begin();
        em.remove(findById(id));
        em.getTransaction().commit();
    }
}
