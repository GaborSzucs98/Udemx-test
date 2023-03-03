package App.Rental;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservations")
public class ReserveClass {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "carid")
    private Long carId;

    @Column(name = "begintime")
    private LocalDate BeginTime;

    @Column(name = "endtime")
    private LocalDate EndTime;

    @Column(name = "name")
    private String Name;

    @Column(name = "email")
    private String Email;

    @Column(name = "address")
    private String Address;

    @Column(name = "phone")
    private String Phone;

    @Column(name = "days")
    private int days;

    @Column(name = "price")
    private int price;

    public ReserveClass() {
    }

    public ReserveClass(Long id , Long carId, LocalDate BeginTime, LocalDate EndTime, String Name, String Email, String Address, String Phone, int days, int price) {
        this.id = id;
        this.carId = carId;
        this.BeginTime = BeginTime;
        this.EndTime = EndTime;
        this.Name = Name;
        this.Email = Email;
        this.Address = Address;
        this.Phone = Phone;
        this.days = days;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public LocalDate getBeginTime() {
        return BeginTime;
    }

    public void setBeginTime(LocalDate BeginTime) {
        this.BeginTime = BeginTime;
    }

    public LocalDate getEndTime() {
        return EndTime;
    }

    public void setEndTime(LocalDate EndTime) {
        this.EndTime = EndTime;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
