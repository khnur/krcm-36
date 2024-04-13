package kz.hacknu.krcm36.service;

import jakarta.validation.Valid;
import kz.hacknu.krcm36.Config;
import kz.hacknu.krcm36.dto.BankCardDto;
import kz.hacknu.krcm36.model.Bank;
import kz.hacknu.krcm36.model.BankCard;
import kz.hacknu.krcm36.model.User;
import kz.hacknu.krcm36.repository.BankCardRepository;
import kz.hacknu.krcm36.repository.BankRepository;
import kz.hacknu.krcm36.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankCardService {
    private final BankCardRepository bankCardRepository;
    private final UserRepository userRepository;
    private final BankRepository bankRepository;
    private final ModelMapper modelMapper = Config.getModelMapper();

    public List<BankCardDto.Response> getBankCardsByUserId(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow();
        return bankCardRepository.findBankCardsByUser(user).stream()
                .map(bankCard -> modelMapper.map(bankCard, BankCardDto.Response.class))
                .toList();
    }

    public List<BankCardDto.Response> getBankCards() {
        return bankCardRepository.findAll().stream()
                .map(bankCard -> modelMapper.map(bankCard, BankCardDto.Response.class))
                .toList();
    }

    public BankCardDto.Response save(@Valid BankCardDto.Request bankCardDto) {
        BankCard card = modelMapper.map(bankCardDto, BankCard.class);
        Bank bank = bankRepository.findById(bankCardDto.getBankId())
                .orElseThrow();
        card.setBank(bank);
        User user = userRepository.findById(bankCardDto.getUserId())
                .orElseThrow();
        card.setUser(user);
        return modelMapper.map(bankCardRepository.save(card), BankCardDto.Response.class);
    }
}
