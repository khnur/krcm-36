package kz.hacknu.krcm36.service;

import kz.hacknu.krcm36.Config;
import kz.hacknu.krcm36.dto.CashBackDto;
import kz.hacknu.krcm36.model.Company;
import kz.hacknu.krcm36.repository.CashBackRepository;
import kz.hacknu.krcm36.repository.CompanyRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CashBackService {
    private final ModelMapper modelMapper = Config.getModelMapper();
    private final CashBackRepository cashBackRepository;
    private final CompanyRepository companyRepository;

    public List<CashBackDto.Response> findCashBacksByCompanyId(@NonNull Integer companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow();
        return cashBackRepository.findCashBackByCompany(company).stream()
                .map(cashBack -> modelMapper.map(cashBack, CashBackDto.Response.class))
                .toList();
    }
}
