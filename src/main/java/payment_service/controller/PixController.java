package payment_service.controller;

import lombok.RequiredArgsConstructor;
import payment_service.entities.Pix;
import payment_service.service.PixService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
@RequiredArgsConstructor
public class PixController {
    @Autowired
    private PixService pixService;

    @GetMapping("/pix")
    public ResponseEntity<List<Pix>> getAllPix() {
        List<Pix> pixList = pixService.getAllPix();
        return ResponseEntity.ok(pixList);
    }
}