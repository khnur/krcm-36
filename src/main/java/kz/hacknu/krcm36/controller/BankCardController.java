package kz.hacknu.krcm36.controller;

import kz.hacknu.krcm36.dto.BankCardDto;
import kz.hacknu.krcm36.service.BankCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class BankCardController {
    private final BankCardService bankCardService;

    @GetMapping
    public ResponseEntity<List<BankCardDto>> getAllBankCards() {
        return ResponseEntity.ok(bankCardService.getBankCards());
    }
}
