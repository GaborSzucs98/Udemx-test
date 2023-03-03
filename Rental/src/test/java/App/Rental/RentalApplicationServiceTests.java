package App.Rental;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "/test-context.xml")      // I tried
@DataJpaTest
class RentalApplicationServiceTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository carRepository;

    @BeforeEach
    public void setUp() {

        CarClass Testcar1 = new CarClass((long)1, "ABC123", "BMW", "X5", 10000,  LocalDate.parse("2023-03-12"), LocalDate.parse("2023-03-13"));
        entityManager.persist(Testcar1);
        entityManager.flush();

        CarClass Testcar2 = new CarClass((long)2, "CBA123", "BMW", "X5", 10000,  LocalDate.parse("2023-03-12"), LocalDate.parse("2023-03-13"));
        entityManager.persist(Testcar2);
        entityManager.flush();

        CarClass Testcar3 = new CarClass((long)3, "ABC321", "BMW", "X5", 10000,  LocalDate.parse("2023-03-12"), LocalDate.parse("2023-03-13"));
        entityManager.persist(Testcar3);
        entityManager.flush();

        CarClass Testcar4 = new CarClass((long)4, "CBA321", "BMW", "X5", 10000,  LocalDate.parse("2023-03-12"), LocalDate.parse("2023-03-13"));
        entityManager.persist(Testcar4);
        entityManager.flush();
    }

    @Test
    public void testFindAllCars() {

        List<CarClass>Allcars = carRepository.findAll();

        assertEquals(4,Allcars.size());
    }

    @Test
    public void testFindCarById() {
        CarClass Testcar = carRepository.findById((long)1).get();
        assertEquals("ABC123",Testcar.getLicensePlate());
    }

}
