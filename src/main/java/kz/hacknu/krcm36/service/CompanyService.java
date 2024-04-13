package kz.hacknu.krcm36.service;

import kz.hacknu.krcm36.Config;
import kz.hacknu.krcm36.dto.CompanyDto;
import kz.hacknu.krcm36.model.Company;
import kz.hacknu.krcm36.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper = Config.getModelMapper();

    public List<CompanyDto> getAllCompanies() {
        return companyRepository.findAll().stream()
                .map(company -> modelMapper.map(company, CompanyDto.class))
                .toList();
    }

    public List<CompanyDto> getCompaniesByName(String name) {
        return companyRepository.findAll().stream()
                .filter(company -> Optional.ofNullable(company)
                        .map(Company::getName)
                        .map(String::toLowerCase)
                        .map(txt -> txt.contains(Optional.ofNullable(name)
                                .filter(StringUtils::isNotBlank)
                                .map(String::toLowerCase)
                                .orElse("")))
                        .orElse(false))
                .map(company -> modelMapper.map(company, CompanyDto.class))
                .toList();
    }
}
