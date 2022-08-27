package Utils;

import pojo.Location;

import java.util.UUID;

 public  class Utils {
    public static String getUUid(){
        return UUID.randomUUID().toString();
    }
    public static Integer getDistanceSqr(Location start,Location end){
        int x1= start.getX(); int y1= start.getY();
        int x2=end.getX(); int y2=end.getY();
        return (((x1-x2)*(x1-x2))+((y1-y2)*(y1-y2)));
    }
}
