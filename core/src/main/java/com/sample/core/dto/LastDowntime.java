package com.sample.core.dto;

public class LastDowntime {

    private String id;
    private String description;
    private String period;


    public LastDowntime(String id, String description, String period) {
        this.id = id;
        this.description = description;
        this.period = period;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
