package payment_service.service;

import payment_service.dto.PixDTO;
import payment_service.dto.PixStatus;
import payment_service.entities.PaymentStatus;
import payment_service.entities.Pix;
import payment_service.repository.PaymentStatusRepository;
import payment_service.repository.PixRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PixService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private PaymentStatusRepository paymentStatusRepository;

    @Autowired
    private PixRepository pixRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public PaymentStatus savePix(PixDTO pixDTO) throws JsonProcessingException {
        pixDTO.setStatus(PixStatus.PROCESSED);
        PaymentStatus savedPix = paymentStatusRepository.save(new PaymentStatus(pixDTO));
        String productJson = objectMapper.writeValueAsString(savedPix);
        kafkaTemplate.send("pix-topic", productJson);
        return savedPix;
    }

    public List<Pix> getAllPix() {
        return pixRepository.findAll();
    }
}
