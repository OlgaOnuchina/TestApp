package com.example.testapp.domain.mapper;

import com.example.testapp.domain.print.LastDowntimePrint;
import com.sample.core.dto.LastDowntime;

public class LastDowntimeMapper extends Mapper<LastDowntime, LastDowntimePrint> {
    @Override
    protected LastDowntimePrint mapImp(LastDowntime item) {
        return new LastDowntimePrint(
                item.getDescription(),
                item.getPeriod()
        );
    }
}
