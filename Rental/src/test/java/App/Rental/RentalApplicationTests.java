package App.Rental;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RentalApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
    void CarClassgood() {
		CarClass car = new CarClass();
		car.setBrand("BMW");
		car.setModel("X5");
		car.setBeginTime(LocalDate.parse("2023-03-12"));
		car.setEndTime(LocalDate.parse("2023-03-13"));
		car.setDailyPrice(10000);
		car.setId((long)1);
		car.setLicensePlate("ABC123");
		car.setReserved(false);
		assertEquals("BMW", car.getBrand());
		assertEquals("X5", car.getModel());
		assertEquals(LocalDate.parse("2023-03-12"),car.getBeginTime());
		assertEquals(LocalDate.parse("2023-03-13"),car.getEndTime());
		assertEquals(10000,car.getDailyPrice());
		assertEquals((long)1,car.getId());
		assertEquals("ABC123",car.getLicensePlate());
		assertEquals(false,car.getReserved());
    }

	@Test
    void CarClassgood2() {
		CarClass car = new CarClass((long)1, "ABC123", "BMW", "X5", 10000,  LocalDate.parse("2023-03-12"), LocalDate.parse("2023-03-13") );
		assertEquals("BMW", car.getBrand());
		assertEquals("X5", car.getModel());
		assertEquals(LocalDate.parse("2023-03-12"),car.getBeginTime());
		assertEquals(LocalDate.parse("2023-03-13"),car.getEndTime());
		assertEquals(10000,car.getDailyPrice());
		assertEquals((long)1,car.getId());
		assertEquals("ABC123",car.getLicensePlate());
		assertEquals(false,car.getReserved());
	}

	@Test
    void ReserveClassgood() {
		ReserveClass res = new ReserveClass();
		res.setId((long)1);
		res.setCarId((long)1);
		res.setBeginTime(LocalDate.parse("2023-03-12"));
		res.setEndTime(LocalDate.parse("2023-03-13"));
		res.setName("Gábor");
		res.setEmail("valami@email.com");
		res.setAddress("Nádasdladány");
		res.setPhone("123456789");
		res.setDays(10);
		res.setPrice(10000);
		assertEquals((long)1,res.getId());
		assertEquals((long)1,res.getCarId());
		assertEquals(LocalDate.parse("2023-03-12"),res.getBeginTime());
		assertEquals(LocalDate.parse("2023-03-13"),res.getEndTime());
		assertEquals("Gábor",res.getName());
		assertEquals("valami@email.com",res.getEmail());
		assertEquals("Nádasdladány",res.getAddress());
		assertEquals("123456789",res.getPhone());
		assertEquals(10,res.getDays());
		assertEquals(10000,res.getPrice());
	}

	@Test
	void ReserveClassgood2() {
		ReserveClass res = new ReserveClass((long)1, (long)1, LocalDate.parse("2023-03-12"), LocalDate.parse("2023-03-13"), "Gábor", "valami@email.com", "Nádasdladány", "123456789", 10, 10000);
        assertEquals((long)1,res.getId());
        assertEquals((long)1,res.getCarId());
        assertEquals(LocalDate.parse("2023-03-12"),res.getBeginTime());
        assertEquals(LocalDate.parse("2023-03-13"),res.getEndTime());
        assertEquals("Gábor",res.getName());
        assertEquals("valami@email.com",res.getEmail());
		assertEquals("Nádasdladány",res.getAddress());
		assertEquals("123456789",res.getPhone());
		assertEquals(10,res.getDays());
		assertEquals(10000,res.getPrice());
	}
}