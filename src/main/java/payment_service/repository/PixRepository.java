package payment_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import payment_service.entities.Pix;

public interface PixRepository extends JpaRepository<Pix, Long> {

}
