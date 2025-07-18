package payment_service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import payment_service.dto.PixDTO;
import payment_service.entities.Pix;
import payment_service.repository.PixRepository;

@Component
public class PixListener {

    @Autowired
    private PixRepository pixRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "cart-checkout-topic", groupId = "payment-group")
    public void handleUpdateStatusAfterPaymentConfirmed(String message) throws JsonMappingException, JsonProcessingException {
        try {

        PixDTO pixDTO = objectMapper.readValue(message, PixDTO.class);

        Pix product = pixRepository.findById(pixDTO.getPaymentId())
                .orElse(new Pix());

        product.setPaymentId(pixDTO.getPaymentId());
        product.setOriginKey(pixDTO.getOriginKey());
        product.setDestinationKey(pixDTO.getDestinationKey());
        product.setValue(pixDTO.getValue());
        product.setTransferDate(pixDTO.getTransferDate());
        product.setStatus(pixDTO.getStatus());

        pixRepository.save(product);

        System.out.println("Product paid in pix-service with ID: " + product.getPaymentId());
        } catch (JsonProcessingException e) {
            System.err.println("Error processing payment message: " + e.getMessage());
        }
    }
}
