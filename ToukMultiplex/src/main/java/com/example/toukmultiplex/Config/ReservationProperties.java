package com.example.toukmultiplex.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="reservation")
public class ReservationProperties {
    int expireLimitBookingMinutes;
    int expireLimitAppearInPersonMinutes;

    public int getExpireLimitBookingMinutes() {
        return expireLimitBookingMinutes;
    }

    public void setExpireLimitBookingMinutes(int expireLimitBookingMinutes) {
        this.expireLimitBookingMinutes = expireLimitBookingMinutes;
    }

    public int getExpireLimitOfAppearingInPersonMinutes() {
        return expireLimitAppearInPersonMinutes;
    }

    public void setExpireLimitAppearInPersonMinutes(int expireLimitAppearInPersonMinutes) {
        this.expireLimitAppearInPersonMinutes = expireLimitAppearInPersonMinutes;
    }
}
