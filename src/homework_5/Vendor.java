package homework_5;

public class Vendor {
    private String companyName;
    private String address;
    private String repName;
    private int phoneNr;

    public Vendor(String companyName, String address, String repName, int phoneNr) {
        this.companyName = companyName;
        this.address = address;
        this.repName = repName;
        this.phoneNr = phoneNr;
    }
    public Vendor(){

    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRepName() {
        return repName;
    }

    public void setRepName(String repName) {
        this.repName = repName;
    }

    public int getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(int phoneNr) {
        this.phoneNr = phoneNr;
    }

    @Override
    public String toString() {
        return companyName + '\'' +
                ", address='" + address + '\'' +
                ", rep_name='" + repName + '\'' +
                ", phone_nr=" + phoneNr +
                '}';
    }
}
