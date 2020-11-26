package co.edu.eci.ieti.android.persistence;


import android.app.Application;

import java.util.List;

import co.edu.eci.ieti.android.dao.UserDao;
import co.edu.eci.ieti.android.network.model.User;
import co.edu.eci.ieti.android.roomDataBase.TaskRoomdb;

public class UserRepository {
    private UserDao userDao;

    public UserRepository(Application application){
        userDao = TaskRoomdb.getDatabase(application).userDAO();
    }

    public List<User> getUsers(){
        return userDao.getUsers();
    }

    public void addUser(User user){
        userDao.insert(user);
    }

}
