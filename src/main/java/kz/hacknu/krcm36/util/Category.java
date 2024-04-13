package kz.hacknu.krcm36.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    SUPERMARKETS("Супермаркеты"),
    INSURANCE("Страхование"),
    EDUCATION("Образование"),
    AGRICULTURE("Сельское хозяйство"),
    TICKETS("Билеты"),
    CAFES("Кафе и рестораны "),
    FOOD_DELIVERY("Доставка еды"),
    TAXI("Такси"),
    GOODS_FOR_CHILDREN("Товары для детей"),
    CINEMA_AND_MUSIC("Кино и музыка"),
    GAMING_SERVICES("Игровые сервисы"),
    PETS("Питомцы"),
    INSURANCE_PAYMENT("Оплата услуг по страхованию"),
    TRAVEL("Путешествия"),
    MEDICAL_SERVICES("Медицинские услуги"),
    FURNITURE("Мебель"),
    FITNESS_AND_SPA("Фитнес и SPA"),
    BEAUTY_SALONS("Салоны красоты"),
    COSMETICS("Косметика"),
    ELECTRONICS("Электроники"),
    CLOTHES_AND_SHOES("Одежда и обувь");

    private final String name;

    @Override
    public String toString() {
        return name;
    }
}
