package payment_service.controller;

import lombok.RequiredArgsConstructor;
import payment_service.dto.PixDTO;
import payment_service.entities.Pix;
import payment_service.service.PixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/pay")
@RequiredArgsConstructor
public class PixController {
    @Autowired
    private PixService pixService;

    @PostMapping("/pix")
    public ResponseEntity<Pix> salvarPix(@RequestBody PixDTO pixDTO) throws JsonProcessingException {
    Pix savedPix = pixService.savePix(pixDTO);
    return ResponseEntity.ok(savedPix);
    }
}
