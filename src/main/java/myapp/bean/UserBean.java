package myapp.bean;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import myapp.entity.User;

import java.util.List;

@Stateless
public class UserStatelessBean {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public void createUser(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    public User readUser(Long id) {
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, id);
        em.close();
        return user;
    }

    public void updateUser(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(user); // Use merge to update the user
        em.getTransaction().commit();
        em.close();
    }

    public void deleteUser(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<User> findAllUsers() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
        List<User> users = query.getResultList();
        em.close();
        return users;
    }

    public User findById(Long id) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createNamedQuery("User.findById", User.class);
        query.setParameter("id", id);
        User user = query.getSingleResult();
        em.close();
        return user;
    }
}
