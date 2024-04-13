package kz.hacknu.krcm36.controller;

import kz.hacknu.krcm36.model.CashBack;
import kz.hacknu.krcm36.repository.CashBackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cashback")
@RequiredArgsConstructor
public class CashBankController {
    private final CashBackRepository cashBackRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CashBack>> findAll() {
        return ResponseEntity.ok(cashBackRepository.findAll());
    }
}
