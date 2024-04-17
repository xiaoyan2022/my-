package Entiry;

import java.io.Serializable;

public class HealthDevelop implements Serializable {
    private String delId;
    private String delMethod;

    public HealthDevelop(String delId, String delMethod) {
        this.delId = delId;
        this.delMethod = delMethod;
    }

    public HealthDevelop() {
        super();
    }

    public String getDelId() {
        return delId;
    }

    public void setDelId(String delId) {
        this.delId = delId;
    }

    public String getDelMethod() {
        return delMethod;
    }

    public void setDelMethod(String delMethod) {
        this.delMethod = delMethod;
    }

    @Override
    public String toString() {
        return "HealthDevelop{" +
                "delId='" + delId + '\'' +
                ", delMethod='" + delMethod + '\'' +
                '}';
    }
}
