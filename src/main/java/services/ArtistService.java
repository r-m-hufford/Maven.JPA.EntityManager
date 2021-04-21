package services;

import entities.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class ArtistService {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persist");
    EntityManager em = emf.createEntityManager();

    public Artist findById(Long id) {
        return em.find(Artist.class, id);
    }

    public List findAll() {
        //return em.createQuery("SELECT * FROM artist").getResultList();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Artist> cq = cb.createQuery(Artist.class);
        Root<Artist> rootEntry = cq.from(Artist.class);
        CriteriaQuery<Artist> all = cq.select(rootEntry);
        TypedQuery<Artist> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    public boolean update(Long id, Artist artist) {
        Artist revise = em.find(Artist.class, id);

        revise.setFirstName(artist.getFirstName());
        revise.setLastName(artist.getLastName());
        revise.setInstrument(artist.getInstrument());

        em.getTransaction().begin();
        em.persist(revise);
        em.getTransaction().commit();

        return true;
    }

    public boolean create(Artist artist) {
        em.getTransaction().begin();
        em.persist(artist);
        em.getTransaction().commit();

        return true;
    }


    public boolean delete(Long id) {
        em.getTransaction().begin();
        em.remove(findById(id));
        em.getTransaction().commit();

        return true;
    }



}
