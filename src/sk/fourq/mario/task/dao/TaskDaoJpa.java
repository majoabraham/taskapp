package sk.fourq.mario.task.dao;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sk.fourq.mario.task.domain.Task;

/**
 * JPA implementation of TaskDao interface to interact with database.
 */
@RequestScoped
public class TaskDaoJpa implements TaskDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Task get(Integer id) {
        Task task = em.find(Task.class, id);
        return task;
    }

    @Override
    public List<Task> getAll() {
        Query query = em.createQuery("SELECT t FROM Task t");
        return query.getResultList();
    }

    @Override
    public void save(Task task) {
        em.persist(task);
    }

    @Override
    public void update(Task task) {
        em.merge(task);
    }

    @Override
    public void delete(Task task) {
        em.remove(task);
    }

    @Override
    public List<Task> filter(String requiredString) {
        StringBuilder sb = new StringBuilder();
        sb.append('%');
        sb.append(requiredString);
        sb.append('%');
        Query query = em.createQuery("SELECT t FROM Task t WHERE t.description LIKE :text").setParameter("text",
                sb.toString());
        return query.getResultList();
    }
}
