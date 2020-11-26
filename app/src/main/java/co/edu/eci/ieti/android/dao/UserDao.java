package co.edu.eci.ieti.android.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import co.edu.eci.ieti.android.network.model.User;

@Dao
public interface UserDao {
    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(User user);

    @Query("SELECT * FROM user_table")
    List<User> getUsers();

    @Delete
    void deleteUser(User user);
}
