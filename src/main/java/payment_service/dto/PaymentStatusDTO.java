package payment_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentStatusDTO {
    private Long statusId;   
    private PixStatus status;
}
