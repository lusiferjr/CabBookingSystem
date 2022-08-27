package repository;

import model.CabDriver;
import model.RideDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RideRepository {
    public List<RideDetail> rideList;

    public RideRepository() {
        this.rideList = new ArrayList<>();
    }

    public void addRide(RideDetail rideDetail) {
        this.rideList.add(rideDetail);
    }

    public RideDetail getRide(String userName, String driverName) {

        RideDetail rideDetail= this.rideList.parallelStream().filter(x ->
                x.getUser().getPersonDetail().getName().equalsIgnoreCase(userName) && x.getAvailableCabs().parallelStream().filter(y ->
                        y.getStatus() && y.getPersonDetail().getName().equalsIgnoreCase(driverName)).collect(Collectors.toList()).size() > 0).findAny().orElse(null);
        if(rideDetail!=null){
            CabDriver cabDriver=rideDetail.getAvailableCabs().parallelStream().filter(x->x.getPersonDetail().getName().equalsIgnoreCase(driverName)).findAny().orElse(null);

            List<CabDriver> choosedCab=new ArrayList<>();
            choosedCab.add(cabDriver);
            rideDetail.setAvailableCabs(choosedCab);

            updateRide(rideDetail);
        }

        return rideDetail;
    }

    public void updateRide(RideDetail rideDetail) {
        RideDetail old=this.rideList.parallelStream().filter(x->x.getRideDetailId().equalsIgnoreCase(rideDetail.getRideDetailId())).findAny().orElse(null);
        this.rideList.remove(old);
        this.rideList.add(rideDetail);
    }

    public RideDetail getUserRide(String userName) {
        return this.rideList.parallelStream().filter(x->x.getStarted()&&x.getUser().getPersonDetail().getName().equalsIgnoreCase(userName)).findAny().orElse(null);

    }

    public void deleteRide(RideDetail rideDetail) {
        RideDetail old=this.rideList.parallelStream().filter(x->x.getRideDetailId().equalsIgnoreCase(rideDetail.getRideDetailId())).findAny().orElse(null);
        this.rideList.remove(old);
    }
}
