package com.beanbiscuit.moneytree.brokerclient.api.request;

import java.time.LocalDateTime;

public class TimePeriod {

    private LocalDateTime to = LocalDateTime.now();
    private LocalDateTime from = LocalDateTime.now();

    public LocalDateTime getTo() {
        return to;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }
}
