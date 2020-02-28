/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Entidades.Personadiagrama;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author alumno
 */
public class PersonadiagramaJpaController implements Serializable {

    public PersonadiagramaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    //este es el que agregue
    public PersonadiagramaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("relacionesJPAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Personadiagrama personadiagrama) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(personadiagrama);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Personadiagrama personadiagrama) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            personadiagrama = em.merge(personadiagrama);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = personadiagrama.getIdpersonaDiagrama();
                if (findPersonadiagrama(id) == null) {
                    throw new NonexistentEntityException("The personadiagrama with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Personadiagrama personadiagrama;
            try {
                personadiagrama = em.getReference(Personadiagrama.class, id);
                personadiagrama.getIdpersonaDiagrama();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The personadiagrama with id " + id + " no longer exists.", enfe);
            }
            em.remove(personadiagrama);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Personadiagrama> findPersonadiagramaEntities() {
        return findPersonadiagramaEntities(true, -1, -1);
    }

    public List<Personadiagrama> findPersonadiagramaEntities(int maxResults, int firstResult) {
        return findPersonadiagramaEntities(false, maxResults, firstResult);
    }

    private List<Personadiagrama> findPersonadiagramaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Personadiagrama.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Personadiagrama findPersonadiagrama(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Personadiagrama.class, id);
        } finally {
            em.close();
        }
    }

    public int getPersonadiagramaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Personadiagrama> rt = cq.from(Personadiagrama.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
