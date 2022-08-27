package pojo;

public class VechicalDetail {
    private String carName;
    private String carNumber;

    @Override
    public String toString() {
        return "VechicalDetail{" +
                "carName='" + carName + '\'' +
                ", carNumber='" + carNumber + '\'' +
                '}';
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public VechicalDetail(String carName, String carNumber) {
        this.carName = carName;
        this.carNumber = carNumber;
    }
}
