package App.Rental;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars_table")
public class CarClass {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "licenseplate")
    private String LicensePlate;

    @Column(name = "brand")
    private String Brand;

    @Column(name = "model")
    private String Model;

    @Column(name = "dailyPrice")
    private int DailyPrice;

    @Column(name = "reserved")
    private Boolean Reserved;

    @Column(name = "begintime")
    private LocalDate BeginTime;

    @Column(name = "endtime")
    private LocalDate EndTime;

    public CarClass(){
        this.Reserved = false;
    }

    public CarClass(Long id, String LicensePlate, String Brand, String Model, int DailyPrice, LocalDate BeginTime, LocalDate EndTime){
        this.id = id;
        this.LicensePlate = LicensePlate;
        this.Brand = Brand;
        this.Model = Model;
        this.DailyPrice = DailyPrice;
        this.BeginTime = BeginTime;
        this.EndTime = EndTime;
        this.Reserved = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return LicensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.LicensePlate = licensePlate;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        this.Brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        this.Model = model;
    }

    public int getDailyPrice() {
        return DailyPrice;
    }

    public void setDailyPrice(int dailyPrice) {
        this.DailyPrice = dailyPrice;
    }

    public Boolean getReserved() {
        return Reserved;
    }

    public void setReserved(Boolean reserved) {
        this.Reserved = reserved;
    }

    public LocalDate getBeginTime() {
        return BeginTime;
    }

    public void setBeginTime(LocalDate beginTime) {
        this.BeginTime = beginTime;
    }

    public LocalDate getEndTime() {
        return EndTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.EndTime = endTime;
    }
}

