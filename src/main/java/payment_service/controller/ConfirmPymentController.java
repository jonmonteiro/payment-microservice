package payment_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.RequiredArgsConstructor;
import payment_service.dto.PixDTO;
import payment_service.entities.PaymentStatus;
import payment_service.service.PixService;

@RestController
@RequestMapping("/confirm")
@RequiredArgsConstructor
public class ConfirmPymentController {
    @Autowired
    private PixService pixService;

    @PostMapping("/pix")
    public ResponseEntity<PaymentStatus> savePix(@RequestBody PixDTO pixDTO) throws JsonProcessingException {
    PaymentStatus savedPix = pixService.savePix(pixDTO);
    return ResponseEntity.ok(savedPix);
    }
}
