package App.Rental;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReserveRepository extends JpaRepository<ReserveClass,Long>{
    
}
