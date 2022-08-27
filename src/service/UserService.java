package service;

import model.User;
import pojo.Location;
import repository.UserRepository;

public interface UserService {
    public User addUser(String userDetail, UserRepository ur);
    public User updateUser(String userName,String updateDetails, UserRepository ur);
    public User updateLocation(String userName,int x,int y, UserRepository ur);
}
