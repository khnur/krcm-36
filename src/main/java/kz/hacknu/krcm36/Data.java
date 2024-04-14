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
                    Category.builder().name("Товары для детей")
                            .build(),
                    Category.builder().name("Кино и музыка")
                            .build(),
                    Category.builder().name("Игровые сервисы")
                            .build(),
                    Category.builder().name("Питомцы")
                            .build(),
                    Category.builder().name("Оплата услуг по страхованию")
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
                            .name("John")
                            .surname("Stones")
                            .email("stones@gmail.com")
                            .build(),
                    User.builder()
                            .name("Kiliam")
                            .surname("Mbappe")
                            .email("mbappe@gmail.com")
                            .build(),
                    User.builder()
                            .name("Toni")
                            .surname("Kross")
                            .email("kross@gmail.com")
                            .build(),
                    User.builder()
                            .name("Paulo")
                            .surname("Dibala")
                            .email("stones@gmail.com")
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
                            .build(),
                    Bank.builder()
                            .name("BCC")
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
                            .user(userRepository.getReferenceById(3))
                            .build(),
                    BankCard.builder()
                            .bank(bankRepository.getReferenceById(3))
                            .type(CardType.MASTERCARD)
                            .cardNumber("6666-6666-6666-666")
                            .expiryDate(LocalDate.now().plusMonths(5))
                            .user(userRepository.getReferenceById(3))
                            .build(),
                    BankCard.builder()
                            .bank(bankRepository.getReferenceById(3))
                            .type(CardType.MASTERCARD)
                            .cardNumber("6666-6666-6666-666")
                            .expiryDate(LocalDate.now().plusYears(2))
                            .user(userRepository.getReferenceById(4))
                            .build(),
                    BankCard.builder()
                            .bank(bankRepository.getReferenceById(4))
                            .type(CardType.MASTERCARD)
                            .cardNumber("1265-3215-6511-321")
                            .expiryDate(LocalDate.now().plusYears(2))
                            .user(userRepository.getReferenceById(4))
                            .build(),
                    BankCard.builder()
                            .bank(bankRepository.getReferenceById(3))
                            .type(CardType.MASTERCARD)
                            .cardNumber("1265-3215-6511-321")
                            .expiryDate(LocalDate.now().plusYears(2))
                            .user(userRepository.getReferenceById(5))
                            .build(),
                    BankCard.builder()
                            .bank(bankRepository.getReferenceById(4))
                            .type(CardType.MASTERCARD)
                            .cardNumber("1265-3215-6511-321")
                            .expiryDate(LocalDate.now().plusYears(2))
                            .user(userRepository.getReferenceById(6))
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
                            .expiryDate(LocalDate.now().plusYears(1))
                            .restriction("Applicable for flights and hotel bookings")
                            .company(companyRepository.getReferenceById(3))
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(1))
                            .percent(0.1F)
                            .condition("Min. 30$")
                            .expiryDate(LocalDate.now().plusMonths(3))
                            .restriction("Valid for medical consultations only")
                            .company(companyRepository.getReferenceById(3))
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(2))
                            .percent(0.12F)
                            .condition("Min. 40$")
                            .expiryDate(LocalDate.now().plusMonths(4))
                            .restriction("Valid for selected salon services")
                            .company(companyRepository.getReferenceById(3))
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(1))
                            .percent(0.07F)
                            .condition("Min. 200$")
                            .expiryDate(LocalDate.now().plusYears(2))
                            .restriction("Applicable on electronics purchases")
                            .company(companyRepository.getReferenceById(3))
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(2))
                            .percent(0.1F)
                            .condition("Min. 150$")
                            .expiryDate(LocalDate.now().plusMonths(6))
                            .restriction("Valid for adventure tours")
                            .company(companyRepository.getReferenceById(3))
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(1))
                            .percent(0.15F)
                            .condition("Min. 20$")
                            .expiryDate(LocalDate.now().plusMonths(3))
                            .restriction("Valid for pet supplies purchases")
                            .company(companyRepository.getReferenceById(3))
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(2))
                            .percent(0.1F)
                            .condition("Min. 25$")
                            .expiryDate(LocalDate.now().plusMonths(6))
                            .restriction("Valid for cosmetics purchases")
                            .company(companyRepository.getReferenceById(3))
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(1))
                            .percent(0.12F)
                            .condition("Min. 100$")
                            .expiryDate(LocalDate.now().plusYears(1))
                            .restriction("Applicable on furniture purchases")
                            .company(companyRepository.getReferenceById(3))
                            .build(),
                    CashBack.builder()
                            .bankCard(cardRepository.getReferenceById(2))
                            .percent(0.1F)
                            .condition("Min. 50$")
                            .expiryDate(LocalDate.now().plusMonths(3))
                            .restriction("Valid for fitness memberships and spa services")
                            .company(companyRepository.getReferenceById(3))
                            .build()
            ));

        };
    }
}
