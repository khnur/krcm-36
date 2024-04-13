package kz.hacknu.krcm36.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CashBackCategory {
    SUPERMARKETS("Супермаркеты");

    private final String name;

    @Override
    public String toString() {
        return name;
    }
}
