package payment_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import payment_service.entities.PaymentStatus;

@Repository
public interface PaymentStatusRepository extends JpaRepository<PaymentStatus, Long> {

}
