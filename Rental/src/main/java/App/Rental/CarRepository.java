package App.Rental;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@ImportResource({"classpath*:application-context.xml"})
public interface CarRepository extends JpaRepository<CarClass, Long> {

    @Query(value = "select * from cars_table where begintime > ?2 or endtime < ?1 union select * from cars_table where reserved = false" , nativeQuery = true)
    List<CarClass> findByDate(LocalDate begin, LocalDate end);

    @Query(value = "select * from cars_table where reserved = false", nativeQuery = true)
    List<CarClass> findfreecars();
}
