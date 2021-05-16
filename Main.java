package main;

import java.util.Scanner;

class NormalBurger {

    protected String name;
    protected String typeOfMeat;
    protected String typeOfBread;
    protected double price = 0;
    protected String additions[] = {"Cheese", "Pepsi", "Potatoes", "Tomatoes"};
    protected int additionsPrices[] = {10, 8, 15, 5};
    protected int amounts[] = new int[4];
    Scanner sc = new Scanner(System.in);

    public NormalBurger(String name) {
        this.name = name;

    }

    void typeOfBread(int a) {
        if (a == 1) {
            typeOfBread = "White Bread";
            this.price += 10; // 10 is the price of white bread
        } else if (a == 2) {
            typeOfBread = "Brown Bread";
            this.price += 15; // 15 is the price of brown bread
        }
    }

    void typeOfMeat(int a) {
        if (a == 1) {
            this.typeOfMeat = "Meat";
            this.price += 25; // 25 is the price meat
        } else if (a == 2) {
            this.typeOfMeat = "Chicken";
            this.price += 20; // 20 is the price of chicken
        }
    }

    void getaddition() {

        System.out.println("We have 4 additions for you Cheese,Pepsi,Potatoes and Tomatoes");
        for (int i = 0; i < amounts.length; i++) {
            System.out.println("Enter the amount of " + additions[i] + " that you want");
            amounts[i] = sc.nextInt();
        }
    }

    void totalPrice(int a) { // 0 for no additions and 1 for addition
        System.out.println("Your bill are :");
        System.out.println("Your sandwitch is :\n" + name + "\t" + typeOfBread + "\t" + typeOfMeat + "\t" + price + " LE");
        switch (a) {
            case 0:
                System.out.println("Your total price = " + price);
            case 1:
                System.out.println("Your additions are :");
                for (int i = 0; i < amounts.length; i++) {
                    int x = amounts[i] * additionsPrices[i];
                    System.out.println(amounts[i] + "\t" + additions[i] + "\t" + x + " LE");
                    price += x;
                }
                System.out.println("Your total bill = " + price + " LE");
        }
    }
}

class HealthyBurger extends NormalBurger {

    public HealthyBurger(String name) {
        super(name);
        typeOfBread = "Brown Bread";
        price += 15;
    }

    @Override
    void getaddition() {
        System.out.println("We have 4 additions for you");
        for (int i = 0; i < additions.length; i++) {
            System.out.println("press " + (i + 1) + "for " + additions[i]);
        }
        System.out.println("You can choose only 2 additions");

        for (int i = 0; i < 2; i++) {
            System.out.println("Enter the number of the additions that you want :");
            int x =sc.nextInt();
            System.out.println("Enter the amount");
            int y =sc.nextInt();
            amounts[x - 1] = y;
            if (i == 0) {
                System.out.println("Do you want other addition? press 1 for Yes or 2 for No");
                int z =sc.nextInt();
                if (z == 2) {
                    break;
                }
            }
        }

    }

    @Override
    void totalPrice(int a) {
        System.out.println("Your bill are :");
        System.out.println("Your sandwitch is :\n" + name + "\t" + typeOfBread + "\t" + typeOfMeat + "\t" + price + " LE");
        switch (a) {
            case 0:
                System.out.println("Your total price = " + price);
            case 1:
                System.out.println("Your additions are :");
                for (int i = 0; i < amounts.length; i++) {
                    if (amounts[i] != 0) {
                        int x = amounts[i] * additionsPrices[i];
                        System.out.println(amounts[i] + "\t" + additions[i] + "\t" + x + " LE");
                        price += x;
                    }
                }
                System.out.println("Your total bill = " + price + " LE");
        }
    }

}
class DeluxeBurger extends NormalBurger{
    
    public DeluxeBurger(String name){
        super(name);
        typeOfBread="White Bread";
        typeOfMeat="Meat";
        price=60;
    }
    
    void totalPrice(){
        System.out.println("Your bill are :");
        System.out.println("Your sandwitch is :\n" + name + "\t" + typeOfBread + "\t" + typeOfMeat );
        System.out.println("the additions :\nchips\npepsi");
       System.out.println("Your total price = " + price+"LE");
}
}

public class Main {

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        System.out.println("Welcome In Our Burger Restaurant,Please Choose your Sandwitch");
        System.out.println("1 for Normal Burger\n2 for Healthy Burger\n3 for Deluxe Burger");
        int burger = ss.nextInt();
        if (burger == 1) {

            NormalBurger n = new NormalBurger("Normal Burger");
            System.out.println("Enter your type of bread :\n1 for white bread\n2 for browen bread");
            n.typeOfBread(ss.nextInt());
            System.out.println("Enter your type of meat :\n1 for meat\n2 for chicken");
            n.typeOfMeat(ss.nextInt());
            System.out.println("Do you want any additions?\nIf yes press 1 else press 0");
            int check = ss.nextInt();
            if (check == 1) {
                n.getaddition();
            }
            n.totalPrice(check);
            System.out.println("Your order 'll be ready in 30m");
        }
        else if (burger == 2) {
            HealthyBurger h = new HealthyBurger("Healthy Burger");
            System.out.println("Enter your type of meat :\n1 for meat\n2 for chicken");
            h.typeOfMeat(ss.nextInt());
            System.out.println("Do you want any additions?\nIf yes press 1 else press 0");
            int check = ss.nextInt();
            if (check == 1) {
                h.getaddition();
            }
            h.totalPrice(check);
            System.out.println("Your order 'll be ready in 30m");
        }
        else if(burger==3){
            DeluxeBurger d = new DeluxeBurger("Deluxe Burger");
            d.totalPrice();
        }

    }

}
