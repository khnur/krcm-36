package kz.hacknu.krcm36.service;

import kz.hacknu.krcm36.model.Bank;
import kz.hacknu.krcm36.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {
    private final BankRepository bankRepository;

    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }
}
