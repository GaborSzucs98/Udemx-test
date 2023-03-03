package App.Rental;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ReserveServiceImpl implements ReserveService{
    
    private final ReserveRepository reserveRepository;

    public ReserveServiceImpl(ReserveRepository reserveRepository) {
        this.reserveRepository = reserveRepository;
    }

    @Override
    public List<ReserveClass>getallReservation(){
        return reserveRepository.findAll();
    }

    @Override
    public ReserveClass addReserve(ReserveClass reserve) {
        return reserveRepository.save(reserve);
    }

    @Override
    public ReserveClass findResByid(Long id) {
        return reserveRepository.findById(id).get();
    }

    @Override
    public void deleteReserve(Long id) {
        reserveRepository.deleteById(id);
    }

    @Override
    public ReserveClass updateReserve(ReserveClass reserve) {
        return reserveRepository.save(reserve);
    }


}
