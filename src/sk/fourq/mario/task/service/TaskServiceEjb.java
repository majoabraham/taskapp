package sk.fourq.mario.task.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import sk.fourq.mario.task.dao.TaskDao;
import sk.fourq.mario.task.domain.Task;

/**
 * EJB implementation of TaskService interface.
 */
@Stateless
public class TaskServiceEjb implements TaskService {

    @Inject
    private TaskDao taskDao;

    @Override
    public Task get(Integer id) {

        return taskDao.get(id);
    }

    @Override
    public List<Task> getAll() {

        return taskDao.getAll();
    }

    @Override
    public void save(Task task) {

        taskDao.save(task);
    }

    @Override
    public void update(Task task) {

        taskDao.update(task);
    }

    @Override
    public void delete(Integer id) {

        Task task = taskDao.get(id);

        taskDao.delete(task);
    }

    @Override
    public List<Task> filter(String requiredString) {

        return taskDao.filter(requiredString);
    }
}
