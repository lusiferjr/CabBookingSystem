package service.serviceImpl;

import model.CabDriver;
import model.User;
import pojo.Location;
import model.RideDetail;
import repository.CabDriverRepository;
import repository.RideRepository;
import repository.UserRepository;
import service.RideService;

import java.util.List;

import static Utils.Utils.getDistanceSqr;
import static Utils.Utils.getUUid;

public class RideServiceImpl implements RideService {


    @Override
    public String findRide(String userName, Location start, Location end, UserRepository ur, CabDriverRepository cabDR, RideRepository rr) {
        User user = ur.getUser(userName);
        RideDetail rideDetail = new RideDetail();
        String response="";
        List<CabDriver> availDriver = cabDR.getDriverAroundLocation(start);
        if (availDriver.size() > 0) {
            rideDetail.setStatus(true);
            rideDetail.setEnd(end);
            rideDetail.setStart(start);
            rideDetail.setRideDetailId(getUUid());
            rideDetail.setUser(user);
            rideDetail.setAvailableCabs(availDriver);
            rideDetail.setStarted(false);
            rr.addRide(rideDetail);
            availDriver.parallelStream().forEach(x->{
                System.out.println(x.getPersonDetail().getName()+" "+"[Available]");
            });
        } else {
            rideDetail.setStatus(false);
            rideDetail.setEnd(end);
            rideDetail.setStart(start);
            rideDetail.setRideDetailId(getUUid());
            rideDetail.setUser(user);
            rideDetail.setStarted(false);
            rideDetail.setAvailableCabs(availDriver);
            System.out.println("No ride found [Since all the driver are more than 5 units away from user]");
        }

        return "";
    }

    @Override
    public void chooseRide(String userName, String driverName, RideRepository rr) {
        RideDetail rideDetail = rr.getRide(userName, driverName);
        rideDetail.setStarted(true);
        rr.updateRide(rideDetail);
        System.out.println("ride Started");
    }

    @Override
    public void calculateBill(String userName, RideRepository rr, CabDriverRepository cabDR, UserRepository ur) {
        RideDetail rideDetail = rr.getUserRide(userName);
        User user = ur.getUser(userName);
        user.setLoc(rideDetail.getEnd());
        ur.updateUser(user);
        CabDriver cabDriver = rideDetail.getAvailableCabs().get(0);
        cabDriver.setEarning((int) Math.ceil(Math.sqrt(getDistanceSqr(rideDetail.getStart(), rideDetail.getEnd()))));
        cabDriver.setLoc(rideDetail.getEnd());
        cabDR.updateDriver(cabDriver);
        rr.deleteRide(rideDetail);
        System.out.println("ride Ended bill amount $ "+cabDriver.getEarning());
    }
}
