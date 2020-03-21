package com.example.testapp.domain.mapper;

import com.example.testapp.domain.print.ReasonDowntimePrint;
import com.sample.core.dto.ReasonDowntime;

public class ReasonDowntimeMapper extends Mapper<ReasonDowntime, ReasonDowntimePrint> {
    @Override
    protected ReasonDowntimePrint mapImp(ReasonDowntime item) {
        return new ReasonDowntimePrint(
                item.getId(),
                item.getName()
        );
    }
}
