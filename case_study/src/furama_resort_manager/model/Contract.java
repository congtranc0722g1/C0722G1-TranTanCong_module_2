package furama_resort_manager.model;

public class Contract {
    private String contractNumber;
    private String bookingCode;
    private String deposit;
    private String totalPayment;
    private String serviceCode;
    private String customerCode;

    public Contract() {

    }

    public Contract(String contractNumber, String bookingCode, String deposit, String totalPayment, String serviceCode, String customerCode) {
        this.contractNumber = contractNumber;
        this.bookingCode = bookingCode;
        this.deposit = deposit;
        this.totalPayment = totalPayment;
        this.serviceCode = serviceCode;
        this.customerCode = customerCode;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(String totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }
}
