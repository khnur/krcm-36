package kz.hacknu.krcm36.service;

import kz.hacknu.krcm36.Config;
import kz.hacknu.krcm36.dto.BankCardDto;
import kz.hacknu.krcm36.model.User;
import kz.hacknu.krcm36.repository.BankCardRepository;
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
    private final ModelMapper modelMapper = Config.getModelMapper();

    public List<BankCardDto> getBankCardsByUserId(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow();
        return bankCardRepository.findBankCardsByUser(user).stream()
                .map(bankCard -> modelMapper.map(bankCard, BankCardDto.class))
                .toList();
    }

    public List<BankCardDto> getBankCards() {
        return bankCardRepository.findAll().stream()
                .map(bankCard -> modelMapper.map(bankCard, BankCardDto.class))
                .toList();
    }
}
