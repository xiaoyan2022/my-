package Entiry;

import java.io.Serializable;

public class HealMes implements Serializable {
    private String id;
    private String realName;
    private String realPhone;
    private int realAge;
    private String realText;

    public HealMes(String id, String realName, String realPhone, int realAge, String realText) {
        this.id = id;
        this.realName = realName;
        this.realPhone = realPhone;
        this.realAge = realAge;
        this.realText = realText;
    }

    public HealMes() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRealPhone() {
        return realPhone;
    }

    public void setRealPhone(String realPhone) {
        this.realPhone = realPhone;
    }

    public int getRealAge() {
        return realAge;
    }

    public void setRealAge(int realAge) {
        this.realAge = realAge;
    }

    public String getRealText() {
        return realText;
    }

    public void setRealText(String realText) {
        this.realText = realText;
    }

    @Override
    public String toString() {
        return "HealMes{" +
                "id='" + id + '\'' +
                ", realName='" + realName + '\'' +
                ", realPhone='" + realPhone + '\'' +
                ", realAge=" + realAge +
                ", realText='" + realText + '\'' +
                '}';
    }
}
