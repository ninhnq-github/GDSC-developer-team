package mvc_demo;

import java.util.Objects;

public class profileModel {
    private String name, age, exp, major, hire;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getHire() {
        return hire;
    }

    public void setHire(String hire) {
        this.hire = hire;
    }

    public profileModel(String name, String age, String exp, String major, String hire) {
        this.name = name;
        this.age = age;
        this.exp = exp;
        this.major = major;
        this.hire = hire;
    }
    
    public profileModel()
    {
    	this.name = "Ninh";
        this.age = "20";
        this.exp = "0 year";
        this.major = "IT";
        this.hire = "2021";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof profileModel)) return false;
        profileModel that = (profileModel) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getAge(), that.getAge()) && Objects.equals(getExp(), that.getExp()) && Objects.equals(getMajor(), that.getMajor()) && Objects.equals(getHire(), that.getHire());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getExp(), getMajor(), getHire());
    }
}