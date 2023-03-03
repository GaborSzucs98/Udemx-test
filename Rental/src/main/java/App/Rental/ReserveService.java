package App.Rental;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ReserveService {

    List<ReserveClass> getallReservation();

    ReserveClass findResByid(Long id);

    ReserveClass addReserve(ReserveClass reserve);

    ReserveClass updateReserve(ReserveClass reserve);

    void deleteReserve(Long id);
     
}
