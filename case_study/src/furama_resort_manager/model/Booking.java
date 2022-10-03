package furama_resort_manager.model;

import java.time.LocalDate;

public class Booking {
    private String codeBooking;
    private LocalDate startDay;
    private LocalDate endDay;
    private String codeGuest;
    private String serviceName;
    private String serviceType;

    public Booking() {

    }

    public Booking(String codeBooking, LocalDate startDay, LocalDate endDay, String codeGuest, String serviceName, String serviceType) {
        this.codeBooking = codeBooking;
        this.startDay = startDay;
        this.endDay = endDay;
        this.codeGuest = codeGuest;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
    }

    public String getCodeBooking() {
        return codeBooking;
    }

    public void setCodeBooking(String codeBooking) {
        this.codeBooking = codeBooking;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }

    public String getCodeGuest() {
        return codeGuest;
    }

    public void setCodeGuest(String codeGuest) {
        this.codeGuest = codeGuest;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
}
