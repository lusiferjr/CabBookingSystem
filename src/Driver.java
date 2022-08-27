import model.CabDriver;
import model.User;
import pojo.Location;
import repository.CabDriverRepository;
import repository.RideRepository;
import repository.UserRepository;
import service.CabDriverService;
import service.RideService;
import service.UserService;
import service.serviceImpl.CabDriverServiceImpl;
import service.serviceImpl.RideServiceImpl;
import service.serviceImpl.UserServiceImpl;

public class Driver {
    static UserService userService = new UserServiceImpl();
    static CabDriverService cabDriverService = new CabDriverServiceImpl();
    static UserRepository ur = new UserRepository();
    static RideRepository rr=new RideRepository();
    static CabDriverRepository cabr = new CabDriverRepository();
    static RideService rideService=new RideServiceImpl();

    public static void main(String[] args) {

        userService.addUser("Abhishek, M, 23", ur);
        userService.updateLocation("Abhishek", 0, 0, ur);
        userService.addUser("Rahul , M, 29", ur);
        userService.updateLocation("Rahul", 10, 0, ur);
        userService.addUser("Nandini, F, 22", ur);
        userService.updateLocation("Nandini", 15, 6, ur);
//        System.out.println(ur.userList);
        cabDriverService.addCabDriver("Driver1, M, 22", "Swift, KA-01-12345", 10, 1, cabr);
//        System.out.println(cabr.cabDriverList);
        cabDriverService.addCabDriver("Driver2, M, 29", "Swift, KA-02-12345", 11, 10, cabr);
//        System.out.println(cabr.cabDriverList);
        cabDriverService.addCabDriver("Driver3, M, 29", "Swift, KA-03-12345", 5, 3, cabr);
//        System.out.println(cabr.cabDriverList);
        System.out.println(rideService.findRide("Abhishek",new Location(0,0),new Location(20,1),ur,cabr,rr));
        System.out.println(rideService.findRide("Rahul",new Location(10,0),new Location(15,3),ur,cabr,rr));
        rideService.chooseRide("Rahul","Driver1",rr);
//        System.out.println(rr.rideList);
        rideService.calculateBill("Rahul",rr,cabr,ur);

        cabDriverService.changeDriverStatus("Driver1","false",cabr);

        rideService.findRide("Nandini",new Location(10,0),new Location(15,3),ur,cabr,rr);
        cabDriverService.findTotalEarning(cabr);
        //        User user2 = userService.updateUser("Abhishek","Naman, M, 23", ur);
//        userService.updateLocation("Naman",1,2,ur);
    }

}
