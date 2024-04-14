package kz.hacknu.krcm36.controller;

import kz.hacknu.krcm36.dto.BankCardDto;
import kz.hacknu.krcm36.service.BankCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final BankCardService bankCardService;

    @GetMapping("/{id}/cards")
    public ResponseEntity<List<BankCardDto.BankCardResponse>> getAllUsers(@PathVariable int id) {
        return ResponseEntity.ok(bankCardService.getBankCardsByUserId(id));
    }
}
