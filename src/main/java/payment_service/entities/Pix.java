package payment_service.entities;

import java.time.LocalDateTime;
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
@Table(name = "pix") 
public class Pix {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;    
   private String originKey;
   private String destinationKey;
   private Double value;
   private LocalDateTime transferDate;
   private PixStatus status;

   public Pix(PixDTO pixDTO) {
       this.originKey = pixDTO.getOriginKey();
       this.destinationKey = pixDTO.getDestinationKey();
       this.value = pixDTO.getValue();
       this.transferDate = pixDTO.getTransferDate();
       this.status = pixDTO.getStatus();
   }
}
