package kz.hacknu.krcm36.service;

import jakarta.transaction.Transactional;
import kz.hacknu.krcm36.adapter.CompanyDetailFactory;
import kz.hacknu.krcm36.adapter.TokenFactory;
import kz.hacknu.krcm36.domain.ForteDetails;
import kz.hacknu.krcm36.domain.HalykDetails;
import kz.hacknu.krcm36.model.*;
import kz.hacknu.krcm36.repository.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MigrationService {
    private final TokenFactory tokenFactory;
    private final CompanyDetailFactory companyDetailFactory;

    private final BankRepository bankRepository;
    private final BankCardRepository bankCardRepository;
    private final CategoryRepository categoryRepository;
    private final CashBackRepository cashBackRepository;
    private final CompanyRepository companyRepository;

    @Scheduled(fixedRate = 60000, initialDelay = 10000)
    @Transactional
    public void migrate() {
        cashBackRepository.deleteAll();
        this.halykBankMigrateCashBack();
//        this.forteBankMigrateCashBack();
    }

    private void halykBankMigrateCashBack() {
        String token = tokenFactory.createToken();
        List<HalykDetails> companyDetails = companyDetailFactory.getHalykDetails(token);

        companyDetails.stream()
                .filter(halykDetails -> StringUtils.isNotBlank(halykDetails.getCategoryName()) &&
                        StringUtils.isNotBlank(halykDetails.getName()) &&
                        halykDetails.getBonus() != null)
                .forEach(halykDetails -> {
                    String categoryName = halykDetails.getCategoryName();
                    Category category;
                    if (!categoryRepository.existsByName(categoryName)) {
                        category = categoryRepository.save(Category.builder()
                                .name(categoryName)
                                .build());
                    } else {
                        category = categoryRepository.findByName(categoryName);
                    }
                    String companyName = halykDetails.getName();
                    Float bonus = halykDetails.getBonus();
                    String condition = halykDetails.getDescription();

                    Bank bank = bankRepository.findByName("Halyk");
                    List<BankCard> bankCards = bankCardRepository.findBankCardsByBank(bank);

                    Company company;
                    if (!companyRepository.existsCompanyByName(companyName)) {
                        company = companyRepository.save(Company.builder()
                                .name(companyName)
                                .category(category)
                                .build());
                    } else {
                        company = companyRepository.findCompanyByName(companyName);
                    }

                    bankCards.forEach(bankCard -> {
                        CashBack cashBack = CashBack.builder()
                                .bankCard(bankCard)
                                .percent(bonus)
                                .condition(condition)
                                .company(company)
                                .build();
                        cashBackRepository.save(cashBack);
                    });
                });
    }

    private void forteBankMigrateCashBack() {
        List<ForteDetails> companyDetails = companyDetailFactory.getForteDetails();
        companyDetails.stream()
                .filter(forteDetails -> forteDetails.getCashback() != null && forteDetails.getCashback() > 0
                        && StringUtils.isNotBlank(forteDetails.getCategory()) && StringUtils.isNotBlank(forteDetails.getName()))
                .forEach(forteDetails -> {
                    String companyName = forteDetails.getName();
                    String categoryName = forteDetails.getName();
                    Float bonus = forteDetails.getCashback();

                    Category category;
                    if (!categoryRepository.existsByName(categoryName)) {
                        category = categoryRepository.save(Category.builder()
                                .name(categoryName)
                                .build());
                    } else {
                        category = categoryRepository.findByName(categoryName);
                    }

                    Bank bank = bankRepository.findByName("Forte");
                    List<BankCard> bankCards = bankCardRepository.findBankCardsByBank(bank);

                    Company company;
                    if (!companyRepository.existsCompanyByName(companyName)) {
                        company = companyRepository.save(Company.builder()
                                .name(companyName)
                                .category(category)
                                .build());
                    } else {
                        company = companyRepository.findCompanyByName(companyName);
                    }

                    bankCards.forEach(bankCard -> {
                        CashBack cashBack = CashBack.builder()
                                .bankCard(bankCard)
                                .percent(bonus)
                                .company(company)
                                .build();
                        cashBackRepository.save(cashBack);
                    });
                });
    }
}
