package pojo;

public class PersonDetail {
    private String name;
    private String gender;
    private String age;

    public PersonDetail(String name, String gender, String age) {
        this.name = name;
        this.gender = gender;
        this.age = age;

    }





    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "PersonDetail{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
