package model;

import pojo.Location;
import pojo.PersonDetail;
import pojo.VechicalDetail;

public class CabDriver extends User{
    private VechicalDetail vechicalDetail;
    private Integer earning;
    private Boolean status;

    public CabDriver(String id, PersonDetail personDetail, Location loc, VechicalDetail vechicalDetail, Integer earning, Boolean status) {
        super(id, personDetail, loc);
        this.vechicalDetail = vechicalDetail;
        this.earning = earning;
        this.status = status;
    }

    public VechicalDetail getVechicalDetail() {
        return vechicalDetail;
    }

    public void setVechicalDetail(VechicalDetail vechicalDetail) {
        this.vechicalDetail = vechicalDetail;
    }

    public Integer getEarning() {
        return earning;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setEarning(Integer earning) {
        this.earning = earning;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CabDriver{" +
                "user="+super.toString() +
                "vechicalDetail=" + vechicalDetail +
                ", earning=" + earning +
                ", status=" + status +
                '}';
    }
}
