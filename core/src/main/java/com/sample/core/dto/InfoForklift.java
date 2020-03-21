package com.sample.core.dto;

import java.util.List;

public class InfoForklift {
    private String nameForklift;
    private List<LastDowntime> lastDowntimeList;

    public InfoForklift(String nameForklift, List<LastDowntime> lastDowntimeList){
        this.nameForklift = nameForklift;
        this.lastDowntimeList = lastDowntimeList;
    }

    public String getNameForklift() {
        return nameForklift;
    }

    public void setNameForklift(String nameForklift) {
        this.nameForklift = nameForklift;
    }

    public List<LastDowntime> getLastDowntimeList(){
        return lastDowntimeList;
    }

    public void setLastDowntimeList(List<LastDowntime> lastDowntimeList){
        this.lastDowntimeList = lastDowntimeList;
    }

}
