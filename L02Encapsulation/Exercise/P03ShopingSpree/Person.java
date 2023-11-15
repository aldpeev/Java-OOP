package L02Encapsulation.Exercise.P03ShopingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }

    private void setName(String name) {
        CheckForEmptyNameAndMoney.checkName(name);
        this.name = name;
    }

    private void setMoney(double money) {
        CheckForEmptyNameAndMoney.checkMoney(money);
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void buyProduct(Product product){
        if (money - product.getCost() >= 0){
            products.add(product);
            money -= product.getCost();
            System.out.printf("%s bought %s%n", name, product.getName());
        } else {
            System.out.printf("%s can't afford %s%n",name, product.getName());
        }
    }

    public String toString(){

        StringBuilder sb = new StringBuilder();

        sb.append(name).append(" - ");

        if (!products.isEmpty()){
            List<String> productsName = new ArrayList<>();
            for (Product product : products) {
                productsName.add(product.getName());
            }
            sb.append(String.join(", ", productsName));
        } else {
            sb.append("Nothing bought");
        }

        return sb.toString();
    }
}
