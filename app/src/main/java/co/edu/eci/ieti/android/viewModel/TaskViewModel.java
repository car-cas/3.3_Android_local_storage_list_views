package co.edu.eci.ieti.android.viewModel;

import android.app.Application;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import co.edu.eci.ieti.android.network.model.Task;
import co.edu.eci.ieti.android.persistence.TaskRepository;

public class TaskViewModel extends AndroidViewModel {

    private TaskRepository taskRepository;
    private MutableLiveData<List<Task>> tasks;

    public TaskViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Task>> getTasks(){
        return tasks;
    }

    public void setToken(String token){
        taskRepository = new TaskRepository(token,getApplication());
    }

}
