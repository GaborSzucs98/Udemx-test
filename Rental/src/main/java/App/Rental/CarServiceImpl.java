package App.Rental;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @Override
    public List<CarClass> getallcars(){
        return carRepository.findAll();
    }

    @Override
    public List<CarClass> getrequestedcars(LocalDate begin, LocalDate end){        
        return carRepository.findByDate(begin, end);
    }

    @Override
    public List<CarClass> getfreecars(){        
        return carRepository.findfreecars();
    }

    @Override
    public CarClass findbyid(Long id){
        return carRepository.findById(id).get();
    }

    @Override
    public CarClass savecar (CarClass carClass){
        return carRepository.save(carClass);
    }

    @Override
    public CarClass updatecar (CarClass carClass){
        return carRepository.save(carClass);
    }

    @Override
    public void deletecarbyid (long id){
        carRepository.deleteById(id);
    }


}