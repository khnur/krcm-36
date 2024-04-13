package kz.hacknu.krcm36.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CardType {
    MASTERCARD("MasterCard Gold"),
    VISA("Visa");

    private final String name;

    @Override
    public String toString() {
        return name;
    }
}
