package service;

import pojo.Location;
import model.RideDetail;
import repository.CabDriverRepository;
import repository.RideRepository;
import repository.UserRepository;

public interface RideService {
    public String findRide(String userName, Location start, Location end, UserRepository ur, CabDriverRepository cabDR, RideRepository rr);
    public void chooseRide(String userName,String driverName,RideRepository rr);

    void calculateBill(String userName,RideRepository rr,CabDriverRepository cabDriverRepository,UserRepository ur);
}
