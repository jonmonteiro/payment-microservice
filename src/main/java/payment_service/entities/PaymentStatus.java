package payment_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import payment_service.dto.PixDTO;
import payment_service.dto.PixStatus;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "payment_status") 
public class PaymentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statusId;   
    private PixStatus status;

    public PaymentStatus(PixDTO pixDTO) {
    this.status = pixDTO.getStatus();
   }
}
