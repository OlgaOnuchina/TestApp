package com.example.testapp.domain.print;

import java.util.List;

public class InfoForkliftPrint {
    private String nameForklift;
    private List<LastDowntimePrint> lastDowntimeList;

    public InfoForkliftPrint(String nameForklift, List<LastDowntimePrint> lastDowntimeList){
        this.nameForklift = nameForklift;
        this.lastDowntimeList = lastDowntimeList;
    }

    public String getNameForklift() {
        return nameForklift;
    }

    public void setNameForklift(String nameForklift) {
        this.nameForklift = nameForklift;
    }

    public List<LastDowntimePrint> getLastDowntimeList(){
        return lastDowntimeList;
    }

    public void setLastDowntimeList(List<LastDowntimePrint> lastDowntimeList){
        this.lastDowntimeList = lastDowntimeList;
    }

}
