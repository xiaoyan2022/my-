package Entiry;

import java.io.Serializable;

public class Person implements Serializable {
    private String staffId;
    private String staffName;

    public Person(String staffId, String staffName) {
        this.staffId = staffId;
        this.staffName = staffName;
    }

    public Person() {
        super();
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "staffId='" + staffId + '\'' +
                ", staffName='" + staffName + '\'' +
                '}';
    }
}
