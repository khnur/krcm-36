package kz.hacknu.krcm36;

import kz.hacknu.krcm36.model.*;
import kz.hacknu.krcm36.repository.*;
import kz.hacknu.krcm36.util.CardType;
import kz.hacknu.krcm36.util.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;


@Component
@RequiredArgsConstructor
public class Data {
    private final RestTemplate restTemplate;

    @Bean
    CommandLineRunner runner(
            BankRepository bankRepository,
            BankCardRepository cardRepository,
            CashBackRepository cashBackRepository,
            UserRepository userRepository,
            CompanyRepository companyRepository
    ) {
        return args -> {
            companyRepository.saveAll(List.of(
                    Company.builder()
                            .name("ZARA")
                            .category(Category.CLOTHES_AND_SHOES)
                            .build(),
                    Company.builder()
                            .name("Small")
                            .category(Category.SUPERMARKETS)
                            .build(),
                    Company.builder()
                            .name("Uvu")
                            .category(Category.TAXI)
                            .build()
            ));
            userRepository.saveAll(List.of(
                    User.builder()
                            .name("Nurzhan")
                            .surname("Kozhamuratov")
                            .email("nurzhan@gmail.com")
                            .build(),
                    User.builder()
                            .name("Not")
                            .surname("osmth")
                            .email("nurzhan@gmail.com")
                            .build()
            ));
            bankRepository.saveAll(List.of(
                    Bank.builder()
                            .name("Kaspi")
                            .build(),
                    Bank.builder()
                            .name("Forte")
                            .build()
            ));

            cardRepository.saveAll(List.of(
                    BankCard.builder()
                            .bank(bankRepository.getReferenceById(1))
                            .type(CardType.MASTERCARD)
                            .cardNumber("123")
                            .expiryDate(LocalDate.now())
                            .user(userRepository.getReferenceById(1))
                            .build(),
                    BankCard.builder()
                            .bank(bankRepository.getReferenceById(2))
                            .type(CardType.VISA)
                            .cardNumber("321")
                            .expiryDate(LocalDate.now())
                            .user(userRepository.getReferenceById(1))
                            .build(),
                    BankCard.builder()
                            .bank(bankRepository.getReferenceById(2))
                            .type(CardType.MASTERCARD)
                            .cardNumber("444")
                            .expiryDate(LocalDate.now())
                            .user(userRepository.getReferenceById(2))
                            .build()
            ));

            cashBackRepository.saveAll(List.of(
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(1))
                            .category(Category.SUPERMARKETS)
                            .percent(0.15F)
                            .condition("Min. 10$")
                            .expiryDate(LocalDate.now())
                            .restriction("Weekly on Sundays")
                            .company(companyRepository.getReferenceById(1))
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(1))
                            .category(Category.SUPERMARKETS)
                            .percent(0.15F)
                            .condition("Min. 10$")
                            .expiryDate(LocalDate.now())
                            .restriction("Weekly on Sundays")
                            .company(companyRepository.getReferenceById(1))
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(2))
                            .category(Category.FOOD_DELIVERY)
                            .percent(0.1F)
                            .condition("Min. 20$")
                            .expiryDate(LocalDate.now().plusMonths(3))
                            .restriction("Applicable on selected restaurants")
                            .company(companyRepository.getReferenceById(2))
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(1))
                            .category(Category.CINEMA_AND_MUSIC)
                            .percent(0.1F)
                            .condition("Min. 15$")
                            .expiryDate(LocalDate.now().plusYears(1))
                            .restriction("Valid for movie tickets only")
                            .company(companyRepository.getReferenceById(3))
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(1))
                            .category(Category.GAMING_SERVICES)
                            .percent(0.05F)
                            .condition("Min. 50$")
                            .expiryDate(LocalDate.now().plusMonths(6))
                            .restriction("Valid for in-game purchases only")
                            .company(companyRepository.getReferenceById(3))
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(2))
                            .category(Category.TRAVEL)
                            .percent(0.08F)
                            .condition("Min. 100$")
                            .expiryDate(LocalDate.now().plusYears(1)) // Expires in 1 year
                            .restriction("Applicable for flights and hotel bookings")
                            .company(companyRepository.getReferenceById(3)) // Assuming ID 5 represents another company
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(1))
                            .category(Category.MEDICAL_SERVICES)
                            .percent(0.1F)
                            .condition("Min. 30$")
                            .expiryDate(LocalDate.now().plusMonths(3)) // Expires in 3 months
                            .restriction("Valid for medical consultations only")
                            .company(companyRepository.getReferenceById(3)) // Assuming ID 6 represents another company
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(2))
                            .category(Category.BEAUTY_SALONS)
                            .percent(0.12F)
                            .condition("Min. 40$")
                            .expiryDate(LocalDate.now().plusMonths(4)) // Expires in 4 months
                            .restriction("Valid for selected salon services")
                            .company(companyRepository.getReferenceById(3)) // Assuming ID 7 represents another company
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(1))
                            .category(Category.ELECTRONICS)
                            .percent(0.07F)
                            .condition("Min. 200$")
                            .expiryDate(LocalDate.now().plusYears(2)) // Expires in 2 years
                            .restriction("Applicable on electronics purchases")
                            .company(companyRepository.getReferenceById(3)) // Assuming ID 8 represents another company
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(2))
                            .category(Category.TRAVEL)
                            .percent(0.1F)
                            .condition("Min. 150$")
                            .expiryDate(LocalDate.now().plusMonths(6)) // Expires in 6 months
                            .restriction("Valid for adventure tours")
                            .company(companyRepository.getReferenceById(3)) // Assuming ID 9 represents another company
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(1))
                            .category(Category.PETS)
                            .percent(0.15F)
                            .condition("Min. 20$")
                            .expiryDate(LocalDate.now().plusMonths(3)) // Expires in 3 months
                            .restriction("Valid for pet supplies purchases")
                            .company(companyRepository.getReferenceById(3)) // Assuming ID 10 represents another company
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(2))
                            .category(Category.COSMETICS)
                            .percent(0.1F)
                            .condition("Min. 25$")
                            .expiryDate(LocalDate.now().plusMonths(6)) // Expires in 6 months
                            .restriction("Valid for cosmetics purchases")
                            .company(companyRepository.getReferenceById(3)) // Assuming ID 11 represents another company
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(1))
                            .category(Category.FURNITURE)
                            .percent(0.12F)
                            .condition("Min. 100$")
                            .expiryDate(LocalDate.now().plusYears(1)) // Expires in 1 year
                            .restriction("Applicable on furniture purchases")
                            .company(companyRepository.getReferenceById(3)) // Assuming ID 12 represents another company
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(2))
                            .category(Category.FITNESS_AND_SPA)
                            .percent(0.1F)
                            .condition("Min. 50$")
                            .expiryDate(LocalDate.now().plusMonths(3)) // Expires in 3 months
                            .restriction("Valid for fitness memberships and spa services")
                            .company(companyRepository.getReferenceById(3)) // Assuming ID 13 represents another company
                            .build()
            ));

        };
    }
}
