package com.app.covw.bean;

import java.io.Serializable;

public class SecurityBean implements Serializable {
    private int security_number;
    private String security_name;
    private int security_pension;
    private int security_medical;
    private int security_inductrial;
    private int security_unemployment;
    private int security_birth;

    public SecurityBean(int security_number, String security_name, int security_pension, int security_medical, int security_inductrial, int security_unemployment, int security_birth) {
        this.security_number = security_number;
        this.security_name = security_name;
        this.security_pension = security_pension;
        this.security_medical = security_medical;
        this.security_inductrial = security_inductrial;
        this.security_unemployment = security_unemployment;
        this.security_birth = security_birth;
    }

    public int getSecurity_number() {
        return security_number;
    }

    public void setSecurity_number(int security_number) {
        this.security_number = security_number;
    }

    public String getSecurity_name() {
        return security_name;
    }

    public void setSecurity_name(String security_name) {
        this.security_name = security_name;
    }

    public int getSecurity_pension() {
        return security_pension;
    }

    public void setSecurity_pension(int security_pension) {
        this.security_pension = security_pension;
    }

    public int getSecurity_medical() {
        return security_medical;
    }

    public void setSecurity_medical(int security_medical) {
        this.security_medical = security_medical;
    }

    public int getSecurity_inductrial() {
        return security_inductrial;
    }

    public void setSecurity_inductrial(int security_inductrial) {
        this.security_inductrial = security_inductrial;
    }

    public int getSecurity_unemployment() {
        return security_unemployment;
    }

    public void setSecurity_unemployment(int security_unemployment) {
        this.security_unemployment = security_unemployment;
    }

    public int getSecurity_birth() {
        return security_birth;
    }

    public void setSecurity_birth(int security_birth) {
        this.security_birth = security_birth;
    }
}
