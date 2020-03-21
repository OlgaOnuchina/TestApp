package com.example.testapp.domain.print;

public class LastDowntimePrint {

    private String description;
    private String period;

    public LastDowntimePrint(String description, String period){
        this.description = description;
        this.period = period;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPeriod(){
        return this.period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
