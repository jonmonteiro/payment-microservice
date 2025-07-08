package payment_service.service;

import payment_service.dto.PixDTO;
import payment_service.dto.PixStatus;
import payment_service.entities.Pix;
import payment_service.repository.PixRepository;
import java.time.LocalDateTime;
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
    private PixRepository pixRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public Pix savePix(PixDTO pixDTO) throws JsonProcessingException {
        pixDTO.setTransferDate(LocalDateTime.now());
        pixDTO.setStatus(PixStatus.PROCESSING);
        Pix savedPix = pixRepository.save(new Pix(pixDTO)); 
        String productJson = objectMapper.writeValueAsString(savedPix);
        kafkaTemplate.send("pix-topic", productJson);
        return savedPix;
    }

}
