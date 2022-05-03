package com.example.toukmultiplex.Reservation.DTO;

public class TimeInterval {
    private final String beginTimestamp;
    private final String endTimestamp;

    public TimeInterval(String beginTimestamp, String endTimestamp) {
        this.beginTimestamp = beginTimestamp;
        this.endTimestamp = endTimestamp;
    }

    public String getBeginTimestamp() {
        return beginTimestamp;
    }

    public String getEndTimestamp() {
        return endTimestamp;
    }
}
