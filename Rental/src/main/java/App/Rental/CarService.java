package App.Rental;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CarService {

    List<CarClass> getallcars();

    List<CarClass> getrequestedcars(LocalDate begin, LocalDate end);

    List<CarClass> getfreecars();

    CarClass findbyid(Long id);

    CarClass savecar (CarClass carClass);

    CarClass updatecar (CarClass carClass);

    void deletecarbyid (long id);
}
