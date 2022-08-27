package model;

import pojo.Location;

import java.util.List;

public class RideDetail {
    private String rideDetailId;
    private Boolean status;
    private Location start;
    private Location end;
    private User user;
    private Boolean started;
    private List<CabDriver> availableCabs;

    @Override
    public String toString() {
        return "RideDetail{" +
                "rideDetailId='" + rideDetailId + '\'' +
                ", status=" + status +
                ", start=" + start +
                ", end=" + end +
                ", user=" + user +
                ", started=" + started +
                ", availableCabs=" + availableCabs +
                '}';
    }

    public Boolean getStarted() {
        return started;
    }

    public void setStarted(Boolean started) {
        this.started = started;
    }

    public Location getStart() {
        return start;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public Location getEnd() {
        return end;
    }

    public void setEnd(Location end) {
        this.end = end;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<CabDriver> getAvailableCabs() {
        return availableCabs;
    }

    public void setAvailableCabs(List<CabDriver> availableCabs) {
        this.availableCabs = availableCabs;
    }

    public String getRideDetailId() {
        return rideDetailId;
    }

    public void setRideDetailId(String rideDetailId) {
        this.rideDetailId = rideDetailId;
    }
}
