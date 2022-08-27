package service.serviceImpl;

import model.User;
import pojo.Location;
import pojo.PersonDetail;
import repository.UserRepository;
import service.UserService;

import java.util.Arrays;
import java.util.List;
import Utils.Utils;

public class UserServiceImpl implements UserService {

    @Override
    public User addUser(String userDetail,UserRepository ur) {
        List<String> detail = Arrays.stream(userDetail.split(",")).map(String::trim).toList();
        PersonDetail personDetail = new PersonDetail(detail.get(0), detail.get(1), detail.get(2));
        User user = new User(Utils.getUUid(), personDetail, new Location(0, 0));
        ur.addUser(user);
        return user;
    }

    @Override
    public User updateUser(String userName, String updateDetail, UserRepository ur) {
        User currUser=ur.getUser(userName);
        List<String> detail = Arrays.stream(updateDetail.split(",")).map(String::trim).toList();
        PersonDetail personDetail = new PersonDetail(detail.get(0), detail.get(1), detail.get(2));
        currUser.setPersonDetail(personDetail);
        ur.updateUser(currUser);
        return currUser;
    }

    @Override
    public User updateLocation(String userName,int x, int y, UserRepository ur) {
        User currUser=ur.getUser(userName);
        Location loc=new Location(x,y);
        currUser.setLoc(loc);
         ur.updateUser(currUser);
        return currUser;
    }
}
