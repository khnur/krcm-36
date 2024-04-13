package kz.hacknu.krcm36.model;

import jakarta.persistence.*;
import kz.hacknu.krcm36.util.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "bank_cards")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(
            name = "bank_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "bank_bank_card_fk"),
            nullable = false
    )
    private Bank bank;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardType type;

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Column(name = "expity_date", nullable = false)
    private LocalDate expiryDate;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "user_bank_card_fk"),
            nullable = false
    )
    private User user;
}
