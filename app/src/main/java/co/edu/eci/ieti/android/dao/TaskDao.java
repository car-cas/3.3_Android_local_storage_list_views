package co.edu.eci.ieti.android.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import co.edu.eci.ieti.android.network.model.Task;

@Dao
public interface TaskDao {
    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Task task);

    @Query("SELECT * FROM task_table")
    List<Task> getTasks();

    @Query("DELETE FROM task_table")
    void deleteTask();
}
