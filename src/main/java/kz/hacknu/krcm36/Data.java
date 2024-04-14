package kz.hacknu.krcm36;

import kz.hacknu.krcm36.model.*;
import kz.hacknu.krcm36.repository.*;
import kz.hacknu.krcm36.util.CardType;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;


@Component
@RequiredArgsConstructor
public class Data {
    @Primary
    @Bean
    CommandLineRunner runner(
            BankRepository bankRepository,
            BankCardRepository cardRepository,
            CashBackRepository cashBackRepository,
            UserRepository userRepository,
            CompanyRepository companyRepository,
            CategoryRepository categoryRepository
    ) {
        return args -> {
            categoryRepository.saveAll(List.of(
                    Category.builder().name("Супермаркеты")
                            .build(),
                    Category.builder().name("Страхование")
                            .build(),
                    Category.builder().name("Образование")
                            .build(),
                    Category.builder().name("Сельское хозяйство")
                            .build(),
                    Category.builder().name("Билеты")
                            .build(),
                    Category.builder().name("Кафе и рестораны")
                            .build(),
                    Category.builder().name("Доставка еды")
                            .build(),
                    Category.builder().name("Такси")
                            .build(),
                    Category.builder().name("детей")
                            .build(),
                    Category.builder().name("музыка")
                            .build(),
                    Category.builder().name("сервисы")
                            .build(),
                    Category.builder().name("Питомцы")
                            .build(),
                    Category.builder().name("страхованию")
                            .build()
            ));

            companyRepository.saveAll(List.of(
                    Company.builder()
                            .name("ZARA")
                            .category(categoryRepository.getReferenceById(1))
                            .build(),
                    Company.builder()
                            .name("Small")
                            .category(categoryRepository.getReferenceById(2))
                            .build(),
                    Company.builder()
                            .name("Uvu")
                            .category(categoryRepository.getReferenceById(4))
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
                            .build(),
                    Bank.builder()
                            .name("Halyk")
                            .build()
            ));

            cardRepository.saveAll(List.of(
                    BankCard.builder()
                            .bank(bankRepository.getReferenceById(1))
                            .type(CardType.MASTERCARD)
                            .cardNumber("4444-4444-4444-4444")
                            .expiryDate(LocalDate.now())
                            .user(userRepository.getReferenceById(1))
                            .build(),
                    BankCard.builder()
                            .bank(bankRepository.getReferenceById(3))
                            .type(CardType.VISA)
                            .cardNumber("5555-5555-5555-5555")
                            .expiryDate(LocalDate.now())
                            .user(userRepository.getReferenceById(1))
                            .build(),
                    BankCard.builder()
                            .bank(bankRepository.getReferenceById(3))
                            .type(CardType.MASTERCARD)
                            .cardNumber("6666-6666-6666-666")
                            .expiryDate(LocalDate.now().plusMonths(5))
                            .user(userRepository.getReferenceById(2))
                            .build(),
                    BankCard.builder()
                            .bank(bankRepository.getReferenceById(3))
                            .type(CardType.MASTERCARD)
                            .cardNumber("6666-6666-6666-666")
                            .expiryDate(LocalDate.now().plusYears(2))
                            .user(userRepository.getReferenceById(2))
                            .build()
            ));

            cashBackRepository.saveAll(List.of(
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(1))
                            .percent(0.15F)
                            .condition("Min. 10$")
                            .expiryDate(LocalDate.now())
                            .restriction("Weekly on Sundays")
                            .company(companyRepository.getReferenceById(1))
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(1))
                            .percent(0.15F)
                            .condition("Min. 10$")
                            .expiryDate(LocalDate.now())
                            .restriction("Weekly on Sundays")
                            .company(companyRepository.getReferenceById(1))
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(2))
                            .percent(0.1F)
                            .condition("Min. 20$")
                            .expiryDate(LocalDate.now().plusMonths(3))
                            .restriction("Applicable on selected restaurants")
                            .company(companyRepository.getReferenceById(2))
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(1))
                            .percent(0.1F)
                            .condition("Min. 15$")
                            .expiryDate(LocalDate.now().plusYears(1))
                            .restriction("Valid for movie tickets only")
                            .company(companyRepository.getReferenceById(3))
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(1))
                            .percent(0.05F)
                            .condition("Min. 50$")
                            .expiryDate(LocalDate.now().plusMonths(6))
                            .restriction("Valid for in-game purchases only")
                            .company(companyRepository.getReferenceById(3))
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(2))
                            .percent(0.08F)
                            .condition("Min. 100$")
                            .expiryDate(LocalDate.now().plusYears(1)) // Expires in 1 year
                            .restriction("Applicable for flights and hotel bookings")
                            .company(companyRepository.getReferenceById(3)) // Assuming ID 5 represents another company
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(1))
                            .percent(0.1F)
                            .condition("Min. 30$")
                            .expiryDate(LocalDate.now().plusMonths(3)) // Expires in 3 months
                            .restriction("Valid for medical consultations only")
                            .company(companyRepository.getReferenceById(3)) // Assuming ID 6 represents another company
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(2))
                            .percent(0.12F)
                            .condition("Min. 40$")
                            .expiryDate(LocalDate.now().plusMonths(4)) // Expires in 4 months
                            .restriction("Valid for selected salon services")
                            .company(companyRepository.getReferenceById(3)) // Assuming ID 7 represents another company
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(1))
                            .percent(0.07F)
                            .condition("Min. 200$")
                            .expiryDate(LocalDate.now().plusYears(2)) // Expires in 2 years
                            .restriction("Applicable on electronics purchases")
                            .company(companyRepository.getReferenceById(3)) // Assuming ID 8 represents another company
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(2))
                            .percent(0.1F)
                            .condition("Min. 150$")
                            .expiryDate(LocalDate.now().plusMonths(6)) // Expires in 6 months
                            .restriction("Valid for adventure tours")
                            .company(companyRepository.getReferenceById(3)) // Assuming ID 9 represents another company
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(1))
                            .percent(0.15F)
                            .condition("Min. 20$")
                            .expiryDate(LocalDate.now().plusMonths(3)) // Expires in 3 months
                            .restriction("Valid for pet supplies purchases")
                            .company(companyRepository.getReferenceById(3)) // Assuming ID 10 represents another company
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(2))
                            .percent(0.1F)
                            .condition("Min. 25$")
                            .expiryDate(LocalDate.now().plusMonths(6)) // Expires in 6 months
                            .restriction("Valid for cosmetics purchases")
                            .company(companyRepository.getReferenceById(3)) // Assuming ID 11 represents another company
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(1))
                            .percent(0.12F)
                            .condition("Min. 100$")
                            .expiryDate(LocalDate.now().plusYears(1)) // Expires in 1 year
                            .restriction("Applicable on furniture purchases")
                            .company(companyRepository.getReferenceById(3)) // Assuming ID 12 represents another company
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(2))
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
