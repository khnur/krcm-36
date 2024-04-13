package kz.hacknu.krcm36.model;

import jakarta.persistence.*;
import kz.hacknu.krcm36.util.CashBackCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
            name = "bank_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "bank_cash_back_fk"),
            nullable = false
    )
    private Bank bank;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CashBackCategory category;

    @Column(nullable = false)
    private Float percent;

    @Column(nullable = false)
    private String condition;

    @Column(name = "expiry_date", nullable = false)
    private LocalDateTime expiryDate;

    @Column(nullable = false)
    private String restriction;
}
