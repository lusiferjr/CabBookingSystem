package repository;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public List<User> userList;

    public UserRepository() {
        this.userList = new ArrayList<>();
    }

    public void addUser(User user) {
        this.userList.add(user);
    }

    public User getUser(String userName) {
        return this.userList.parallelStream().filter(user ->
                user.getPersonDetail().getName().equalsIgnoreCase(userName)
        ).findAny().orElse(null);
    }

    public void updateUser(User updatedUser) {
        User user1 = getUser(updatedUser.getPersonDetail().getName());
        if (user1 != null) {
            this.userList.remove(user1);
        }
        addUser(updatedUser);
    }

}
