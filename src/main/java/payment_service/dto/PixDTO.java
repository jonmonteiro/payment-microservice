package payment_service.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PixDTO {
   private Long id;    
   private String originKey;
   private String destinationKey;
   private Double value;
   private LocalDateTime transferDate;
   private PixStatus status;

}
