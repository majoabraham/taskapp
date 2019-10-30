# TaskApp

TaskApp is a basic task application that provides HTTP REST API to create, edit, delete,
getting one and getting a collection of tasks. 

Application presents description of task and status if task is done.

It is supposed to be deployed on WildFly 16 server.

Application uses H2 database which is shipping with WildFly distribution.

Before starting WildFly 16 server is necessary to start the database:

`java -jar wildfly-16.0.0.Final\modules\system\layers\base\com\h2database\h2\main\h2-1.4.193.jar -webAllowOthers -tcpAllowOthers`

Application produces and consumes JSON, so it is necessary to set Content-Type to application/json value in Headers.

 HTTP REST API:
 - create task: `POST http://127.0.0.1:8080/TaskApp/tasks`
 - get all tasks: `GET http://127.0.0.1:8080/TaskApp/tasks`
 - get one task: `GET http://127.0.0.1:8080/TaskApp/tasks/{id}`
 - delete task: `DELETE http://127.0.0.1:8080/TaskApp/tasks/{id}`
 - update task: `PUT http://127.0.0.1:8080/TaskApp/tasks`
 - get all tasks containing string: `GET http://127.0.0.1:8080/TaskApp/tasks/filter/{text}`
 
 Body in POST looks like:
 
```
{
    "description": "project",
    "done": "false"
}
```

Body in PUT looks like:

```
{
    "description": "project updated",
    "done": true,
    "id": 1
}
```
 