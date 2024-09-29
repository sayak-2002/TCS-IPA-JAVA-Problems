package IPA5;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Laptop[] laptops = new Laptop[4];
        for(int i=0; i<4; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();
            sc.nextLine();
            int e = sc.nextInt();
            sc.nextLine();
            laptops[i] = new Laptop(a, b, c, d, e);
        }
        String brand = sc.nextLine();
        String os = sc.nextLine();
        int ans1 = countOfLaptopByBrand(laptops, brand);
        if(ans1 != 0) {
            System.out.println(ans1);
        } else {
            System.out.println("The given Brand is not available.");
        }
        Laptop[] ans2 = searchLaptopByOsType(laptops, os);
        if(ans2 != null) {
            for(Laptop laptop : ans2) {
                System.out.println(laptop.getId());
                System.out.println(laptop.getRating());
            }
        } else {
            System.out.println("The given os type is not available.");
        }
    }
    public static int countOfLaptopByBrand(Laptop[] laptops, String brand) {
        int count = 0;
        for(Laptop laptop : laptops) {
            if(laptop.getBrand().equalsIgnoreCase(brand) && laptop.getRating() > 3) {
                count++;
            }
        }
        return count;
    }
    public static Laptop[] searchLaptopByOsType(Laptop[] laptops, String os) {
        List<Laptop> result = new ArrayList<>();
        for(Laptop laptop : laptops) {
            if(laptop.getOs().equalsIgnoreCase(os)) {
                result.add(laptop);
            }
        }
        Collections.sort(result, (l1, l2) -> Integer.compare(l2.getId(), l1.getId()));

        return result.isEmpty() ? null : result.toArray(new Laptop[0]);
    }
}


class Laptop {
    private int id;
    private String os, brand;
    private double price;
    private int rating;

    public Laptop(int id, String os, String brand, double price, int rating) {
        this.id = id;
        this.os = os;
        this.brand = brand;
        this.price = price;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
