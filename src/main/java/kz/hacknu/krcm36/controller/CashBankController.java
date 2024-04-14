package kz.hacknu.krcm36.controller;

import kz.hacknu.krcm36.dto.CashBackDto;
import kz.hacknu.krcm36.service.CashBackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cashback")
@RequiredArgsConstructor
public class CashBankController {
    private final CashBackService cashBackService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CashBackDto.CashBackResponse>> findAll() {
        return ResponseEntity.ok(cashBackService.getAllCashBacks());
    }

    @PostMapping("/save")
    public ResponseEntity<CashBackDto.CashBackResponse> create(CashBackDto.CashBackRequest request) {
        return ResponseEntity.ok(cashBackService.create(request));
    }
}
