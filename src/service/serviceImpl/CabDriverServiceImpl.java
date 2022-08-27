package service.serviceImpl;

import Utils.Utils;
import model.CabDriver;
import pojo.Location;
import pojo.PersonDetail;
import pojo.VechicalDetail;
import repository.CabDriverRepository;
import service.CabDriverService;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static constant.Constant.FREE;

public class CabDriverServiceImpl implements CabDriverService {


    @Override
    public CabDriver addCabDriver(String userDetail, String vechicalDetail,int x,int y, CabDriverRepository driverRepo) {
        List<String> detail = Arrays.stream(userDetail.split(",")).map(String::trim).toList();
        PersonDetail personDetail = new PersonDetail(detail.get(0), detail.get(1), detail.get(2));
        List<String> vDetail = Arrays.stream(vechicalDetail.split(",")).map(String::trim).toList();
        VechicalDetail vechicalDetail1 = new VechicalDetail(vDetail.get(0), vDetail.get(1));
        CabDriver user = new CabDriver(Utils.getUUid(), personDetail, new Location(x, y), vechicalDetail1, 0, FREE);
        driverRepo.addCabDriver(user);
        return user;
    }

    @Override
    public CabDriver updateCabDriver(String userName, String updateDetails, CabDriverRepository driverRepo) {
         CabDriver currUser=driverRepo.getDriver(userName);
        List<String> detail = Arrays.stream(updateDetails.split(",")).map(String::trim).toList();
        PersonDetail personDetail = new PersonDetail(detail.get(0), detail.get(1), detail.get(2));
        currUser.setPersonDetail(personDetail);
        driverRepo.updateDriver(currUser);
        return currUser;
    }

    @Override
    public CabDriver updateLocation(String userName, int x, int y, CabDriverRepository driverRepo) {
        CabDriver currUser=driverRepo.getDriver(userName);
        Location loc=new Location(x,y);
        currUser.setLoc(loc);
        driverRepo.updateDriver(currUser);
        return currUser;
    }

    @Override
    public void changeDriverStatus(String driverName, String status,CabDriverRepository driverRepo) {
        CabDriver cabDriver=driverRepo.getDriver(driverName);
        if(status.equalsIgnoreCase("false"))
        cabDriver.setStatus(Boolean.FALSE);
        else cabDriver.setStatus(Boolean.TRUE);
        driverRepo.updateDriver(cabDriver);
    }

    @Override
    public void findTotalEarning(CabDriverRepository cabDR) {

        List<CabDriver> cabDriverList=cabDR.getAllDriver();
        cabDriverList.parallelStream().forEach(x->{
            System.out.println(x.getPersonDetail().getName()+" earn "+x.getEarning());
        });

    }
}
