package kz.hacknu.krcm36.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "cash_backs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CashBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(
            name = "bank_card_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "bank_card_cash_back_fk"),
            nullable = false
    )
    private BankCard bankCard;

    @Column(nullable = false)
    private Float percent;

    @Column(nullable = false)
    private String condition;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(nullable = false)
    private String restriction;

    @ManyToOne
    @JoinColumn(
            name = "company_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "company_cash_back_fk"),
            nullable = false
    )
    private Company company;
}
