package org.halogen.Enum;

enum LaptopEnum {
    Macbook(1000), TUF(700), Victus(600), ThinkPad(400);

    private int price;

    LaptopEnum(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

public class EnumAdv {
    public static void main(String[] args) {
        LaptopEnum laptop = LaptopEnum.Macbook;

        System.out.println("My " + laptop + ": " + laptop.getPrice());

        LaptopEnum laptops[] = LaptopEnum.values();
        for (LaptopEnum l : laptops) {
            System.out.println(l + ": " + l.getPrice());
        }
    }
}
