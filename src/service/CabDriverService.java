package service;


import model.CabDriver;
import repository.CabDriverRepository;

public interface CabDriverService {
    public CabDriver addCabDriver(String userDetail, String vechicalDetail,int x,int y, CabDriverRepository driverRepo);
    public CabDriver updateCabDriver(String userName, String updateDetails, CabDriverRepository driverRepo);
    public CabDriver updateLocation(String userName,int x,int y, CabDriverRepository driverRepo);
    public void changeDriverStatus(String driverName,String status,CabDriverRepository driverRepo);
    public void findTotalEarning(CabDriverRepository cabDR);
}
