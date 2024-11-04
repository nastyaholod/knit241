package org.lab5;

// Класс для представления товара в магазине
public class ShopItem {
    private String name; // Наименование товара
    private int price; // Цена товара (целое число)
    private int quantity; // Количество товара
    private String color; // Цвет товара

    public ShopItem(String name, int price, int quantity, String color) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getColor() {
        return color;
    }

    // Метод для представления данных о товаре
    @Override
    public String toString() {
        return String.format("%s: %d руб. за штуку, цвет: %s, количество: %d", name, price, color, quantity);
    }

    // Переопределение equals и hashCode для правильного сравнения объектов
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ShopItem)) return false;

        ShopItem other = (ShopItem) obj;
        return name.equals(other.name) && price == other.price && color.equals(other.color);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + price + color.hashCode();
    }
}
