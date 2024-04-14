package kz.hacknu.krcm36.service;

import jakarta.transaction.Transactional;
import kz.hacknu.krcm36.adapter.CompanyDetailFactory;
import kz.hacknu.krcm36.adapter.TokenFactory;
import kz.hacknu.krcm36.domain.CompanyDetail;
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
    private final Object lock = new Object();

    private final TokenFactory tokenFactory;
    private final CompanyDetailFactory companyDetailFactory;

    private final BankRepository bankRepository;
    private final BankCardRepository bankCardRepository;
    private final CategoryRepository categoryRepository;
    private final CashBackRepository cashBackRepository;
    private final CompanyRepository companyRepository;

    @Scheduled(fixedRate = 60000, initialDelay = 10000)
    @Transactional
    public void halykMigrate() {
        synchronized (lock) {
            this.halykBankMigrateCashBack();
        }
    }

    @Scheduled(fixedRate = 60000, initialDelay = 20000)
    @Transactional
    public void forteMigrate() {
        synchronized (lock) {
            this.forteBankMigrateCashBack();
        }
    }


    private void halykBankMigrateCashBack() {
        cashBackRepository.deleteAll();
        String token = tokenFactory.createToken();
        List<CompanyDetail> companyDetails = companyDetailFactory.getCompanyDetail(token);

        companyDetails.stream()
                .filter(companyDetail -> StringUtils.isNotBlank(companyDetail.getCategoryName()) &&
                        StringUtils.isNotBlank(companyDetail.getName()) &&
                        companyDetail.getBonus() != null)
                .forEach(companyDetail -> {
                    String categoryName = companyDetail.getCategoryName();
                    Category category;
                    if (!categoryRepository.existsByName(categoryName)) {
                        category = categoryRepository.save(Category.builder()
                                .name(categoryName)
                                .build());
                    } else {
                        category = categoryRepository.findByName(categoryName);
                    }
                    String companyName = companyDetail.getName();
                    Float bonus = companyDetail.getBonus();
                    String condition = companyDetail.getDescription();

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

    }
}
