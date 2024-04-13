package kz.hacknu.krcm36;

import kz.hacknu.krcm36.model.Bank;
import kz.hacknu.krcm36.repository.BankCardRepository;
import kz.hacknu.krcm36.repository.BankRepository;
import kz.hacknu.krcm36.repository.CashBackRepository;
import kz.hacknu.krcm36.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class Krcm36Application {
	private final RestTemplate restTemplate;


	public static void main(String[] args) {
		SpringApplication.run(Krcm36Application.class, args);
	}

	@Bean
	CommandLineRunner runner(
			BankRepository bankRepository,
			BankCardRepository cardRepository,
			CashBackRepository cashBackRepository,
			UserRepository userRepository
	) {
		return args -> {
            bankRepository.saveAll(List.of(
                    Bank.builder()
							.name("Kaspi")
                            .build(),
                    Bank.builder()
							.name("Forte")
                            .build()
            ));

			List<Bank> all = bankRepository.findAll();
			System.out.println(all);
		};
	}
}
