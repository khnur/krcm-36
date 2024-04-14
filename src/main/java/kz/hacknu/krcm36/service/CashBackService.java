package kz.hacknu.krcm36.service;

import kz.hacknu.krcm36.Config;
import kz.hacknu.krcm36.dto.CashBackDto;
import kz.hacknu.krcm36.model.BankCard;
import kz.hacknu.krcm36.model.CashBack;
import kz.hacknu.krcm36.model.Company;
import kz.hacknu.krcm36.repository.BankCardRepository;
import kz.hacknu.krcm36.repository.CashBackRepository;
import kz.hacknu.krcm36.repository.CompanyRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CashBackService {
    private final ModelMapper modelMapper = Config.getModelMapper();
    private final CashBackRepository cashBackRepository;
    private final BankCardRepository bankCardRepository;
    private final CompanyRepository companyRepository;

    public List<CashBackDto.CashBackResponse> getAllCashBacks() {
        return cashBackRepository.findAll().stream()
                .map(cashBack -> modelMapper.map(cashBack, CashBackDto.CashBackResponse.class))
                .toList();
    }

    public List<CashBackDto.CashBackResponse> findCashBacksByCompanyId(@NonNull Integer companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow();
        return cashBackRepository.findCashBackByCompany(company).stream()
                .map(cashBack -> modelMapper.map(cashBack, CashBackDto.CashBackResponse.class))
                .sorted((a, b) -> Float.compare(b.getPercent(), a.getPercent()))
                .toList();
    }

    public CashBackDto.CashBackResponse create(CashBackDto.CashBackRequest request) {
        CashBack cashBack = modelMapper.map(request, CashBack.class);
        BankCard card = bankCardRepository.findById(request.getBankCardId())
                .orElseThrow();
        cashBack.setBankCard(card);
        Company company = companyRepository.findById(request.getCompanyId())
                .orElseThrow();
        cashBack.setCompany(company);
        return modelMapper.map(cashBack, CashBackDto.CashBackResponse.class);
    }
}
