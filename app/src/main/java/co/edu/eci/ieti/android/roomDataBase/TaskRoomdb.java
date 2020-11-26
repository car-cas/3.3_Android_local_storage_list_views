package co.edu.eci.ieti.android.roomDataBase;

import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import co.edu.eci.ieti.android.dao.TaskDao;
import co.edu.eci.ieti.android.dao.UserDao;
import co.edu.eci.ieti.android.network.model.Task;
import co.edu.eci.ieti.android.network.model.User;

@Database(entities = {Task.class, User.class}, version = 1 )
public abstract class TaskRoomdb extends RoomDatabase{

    public abstract UserDao userDAO();
    public abstract TaskDao taskDAO();

    private static volatile TaskRoomdb INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static TaskRoomdb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TaskRoomdb.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TaskRoomdb.class, "task_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
