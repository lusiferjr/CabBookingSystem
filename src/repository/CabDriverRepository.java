package repository;

import model.CabDriver;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static Utils.Utils.getDistanceSqr;
import static constant.Constant.MINDISTANCE;

public class CabDriverRepository {
    public List<CabDriver> cabDriverList;

    public CabDriverRepository() {
        this.cabDriverList = new ArrayList<>();
    }
    public void addCabDriver(CabDriver cabDriver) {
        this.cabDriverList.add(cabDriver);
    }

    public CabDriver getDriver(String userName) {
        return this.cabDriverList.parallelStream().filter(user ->
                user.getPersonDetail().getName().equalsIgnoreCase(userName)
        ).findAny().orElse(null);
    }

    public void updateDriver(CabDriver updateCabDriver) {
        CabDriver user1 = this.cabDriverList.parallelStream().filter(driver ->
                driver.getPersonDetail().getName().equalsIgnoreCase(updateCabDriver.getPersonDetail().getName())
        ).findAny().orElse(null);
        if (user1 != null) {
            this.cabDriverList.remove(user1);
        }
        addCabDriver(updateCabDriver);
    }

    public List<CabDriver> getDriverAroundLocation(Location start) {
       return this.cabDriverList.parallelStream().filter(x->
            x.getStatus() && getDistanceSqr(start,x.getLoc())<MINDISTANCE
        ).collect(Collectors.toList());
    }

    public List<CabDriver> getAllDriver() {
        return this.cabDriverList;
    }
}
