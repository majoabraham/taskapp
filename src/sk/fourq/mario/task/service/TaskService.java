package sk.fourq.mario.task.service;

import java.util.List;

import javax.ejb.Local;

import sk.fourq.mario.task.domain.Task;

/**
 * TaskService interface serves as business interface for Task domain.
 */
@Local
public interface TaskService {
    /**
     * Get one concrete task from database.
     *
     * @param id ID of task
     * @return required task
     */
    Task get(Integer id);

    /**
     * Get all tasks from database.
     *
     * @return all tasks from database
     */
    List<Task> getAll();

    /**
     * Save new task to database.
     *
     * @param task new task
     */
    void save(Task task);

    /**
     * Update task to database.
     *
     * @param task updated task
     */
    void update(Task task);

    /**
     * Delete task from database.
     *
     * @param task task to delete
     */
    void delete(Integer id);

    /**
     * Get all tasks from database containing required string.
     *
     * @param requiredString required string in task
     * @return all tasks containing required string
     */
    List<Task> filter(String requiredString);
}
