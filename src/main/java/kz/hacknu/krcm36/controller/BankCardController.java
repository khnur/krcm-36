package kz.hacknu.krcm36.controller;

import kz.hacknu.krcm36.dto.BankCardDto;
import kz.hacknu.krcm36.service.BankCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class BankCardController {
    private final BankCardService bankCardService;

    @GetMapping
    public ResponseEntity<List<BankCardDto.Response>> getAllBankCards() {
        return ResponseEntity.ok(bankCardService.getBankCards());
    }

    @PostMapping("/save")
    public ResponseEntity<BankCardDto.Response> saveBankCard(@RequestBody BankCardDto.Request bankCardDto) {
        return ResponseEntity.ok(bankCardService.save(bankCardDto));
    }
}
