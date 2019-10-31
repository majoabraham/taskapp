package sk.fourq.mario.task.api;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import sk.fourq.mario.task.domain.Task;
import sk.fourq.mario.task.service.TaskService;

/**
 * JAX-RS resources for Task domain.
 */
@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ResourceApi {

    @EJB
    private TaskService taskService;

    @GET
    public Response getTasks() {

        List<Task> tasks = taskService.getAll();

        return Response.ok(tasks).build();
    }

    @Path("/{id}")
    @GET
    public Response getTask(@PathParam("id") Integer id) {

        Task task = taskService.get(id);

        return Response.ok(task).build();
    }

    @POST
    public Response createTask(Task task) {

        taskService.save(task);

        return Response.ok().status(Response.Status.CREATED).build();

    }

    @Path("/{id}")
    @DELETE
    public Response deleteTask(@PathParam("id") Integer id) {

        taskService.delete(id);

        return Response.ok().build();
    }

    @PUT
    public Response updateTask(Task task) {

        taskService.update(task);

        return Response.ok().build();
    }

    @Path("/filter/{text}")
    @GET
    public Response filterTasks(@PathParam("text") String text) {

        List<Task> tasks = taskService.filter(text);

        return Response.ok(tasks).build();
    }
}
