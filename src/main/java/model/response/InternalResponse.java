package model.response;

import java.time.LocalDateTime;

public class InternalResponse {
    private LocalDateTime dateTime;
    private String netVolume;
    private String price;

    public InternalResponse() {
    }

    public InternalResponse(LocalDateTime dateTime, String netVolume, String price) {
        this.dateTime = dateTime;
        this.netVolume = netVolume;
        this.price = price;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getNetVolume() {
        return netVolume;
    }

    public void setNetVolume(String netVolume) {
        this.netVolume = netVolume;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
