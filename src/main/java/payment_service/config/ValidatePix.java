package payment_service.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import payment_service.dto.PixDTO;
import payment_service.dto.PixStatus;

@Service
public class ValidatePix {

    @KafkaListener(topics = "pix-topic", groupId = "payment-group")

    public void process(PixDTO pixDTO) {
        System.out.println(pixDTO);

        if (pixDTO.getValue() != null && pixDTO.getValue() > 0) {
            pixDTO.setStatus(PixStatus.PROCESSED);
        } else  {
            pixDTO.setStatus(PixStatus.ERROR);
            throw new RuntimeException();
        }
    }
}
