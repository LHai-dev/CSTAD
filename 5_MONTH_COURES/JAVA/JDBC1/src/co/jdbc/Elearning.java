package co.jdbc;

public class Elearning {
    private String name;
    private Integer id;
    private String gender;
    private Integer age;
    private String major;

    public Elearning() {

    }



    public Elearning(Integer id, String name, String gender, Integer age, String major) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age ;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Elearning{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                '}';
    }
}
