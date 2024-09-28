package IPA3;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Resort[] resorts = new Resort[4];
        for(int i=0; i<4; i++) {
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble(); sc.nextLine();
            double e = sc.nextDouble(); sc.nextLine();
            resorts[i] = new Resort(a, b, c, d, e);
        }
        String inputCategory = sc.nextLine();
        double ans = findAvgPriceByCategory(resorts, inputCategory);
        if(ans > 0) {
            System.out.println("Average price of " + inputCategory + " Resort:"  + ans);
        } else {
            System.out.println("There are no such resort.");
        }
        sc.close();
    }
    public static double findAvgPriceByCategory(Resort[] resorts, String inputCategory) {
        double sum  = 0, count = 0;
        for (Resort resort : resorts) {
            if (resort.getCategory().equalsIgnoreCase(inputCategory) && resort.getRating() > 4) {
                sum += resort.getPrice();
                count++;
            }
        }
        return sum/count;
    }
}


class Resort {
    private int resortId;
    private String resortName, category;
    private double price, rating;

    public Resort(int resortId, String resortName, String category, double price, double rating) {
        this.resortId = resortId;
        this.resortName = resortName;
        this.category = category;
        this.price = price;
        this.rating = rating;
    }

    public int getResortId() {
        return resortId;
    }

    public void setResortId(int resortId) {
        this.resortId = resortId;
    }

    public String getResortName() {
        return resortName;
    }

    public void setResortName(String resortName) {
        this.resortName = resortName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
