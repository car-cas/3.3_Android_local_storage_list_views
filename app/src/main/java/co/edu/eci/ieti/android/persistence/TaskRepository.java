package co.edu.eci.ieti.android.persistence;

import android.app.Application;

import java.util.List;

import co.edu.eci.ieti.android.dao.TaskDao;
import co.edu.eci.ieti.android.network.RetrofitNetwork;
import co.edu.eci.ieti.android.network.model.Task;
import co.edu.eci.ieti.android.network.service.TaskService;
import co.edu.eci.ieti.android.roomDataBase.TaskRoomdb;

public class TaskRepository {
    private TaskDao taskDao;
    private List<Task> tasks;
    private TaskService taskService;

    public TaskRepository(String token,Application application){
        taskDao = TaskRoomdb.getDatabase(application).taskDAO();
        tasks = taskDao.getTasks();
        taskService = new RetrofitNetwork(token).getTaskService();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task){
        taskService.addTask(task);
        taskDao.insert(task);
    }

}
