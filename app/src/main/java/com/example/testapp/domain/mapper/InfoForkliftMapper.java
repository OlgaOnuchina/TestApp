package com.example.testapp.domain.mapper;

import com.example.testapp.domain.print.InfoForkliftPrint;
import com.example.testapp.domain.print.LastDowntimePrint;
import com.sample.core.dto.InfoForklift;
import com.sample.core.dto.LastDowntime;

import java.util.ArrayList;
import java.util.List;

public class InfoForkliftMapper extends Mapper<InfoForklift, InfoForkliftPrint> {

    private final LastDowntimeMapper lastDowntimeMapper = new LastDowntimeMapper();

    @Override
    protected InfoForkliftPrint mapImp(InfoForklift item) {

        String nameForklift = item.getNameForklift();
        List<LastDowntime> list = item.getLastDowntimeList();
        List<LastDowntimePrint> listPrint = new ArrayList<>();
        for(LastDowntime element : list){
            LastDowntimePrint elementPrint = lastDowntimeMapper.map(element);
            listPrint.add(elementPrint);
        }

        return new InfoForkliftPrint(
                nameForklift,
                listPrint
        );
    }
}
