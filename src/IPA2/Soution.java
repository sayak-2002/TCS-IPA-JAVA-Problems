package IPA2;

import java.util.*;

public class Soution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book[] books = new Book[4];
        for(int i=0; i<4; i++) {
            int a = sc.nextInt(); sc.nextLine();
            int b = sc.nextInt(); sc.nextLine();
            String c = sc.nextLine();
            String d = sc.nextLine();
            double e = sc.nextDouble(); sc.nextLine();
            books[i] = new Book(a, b, c, d, e);
        }
        String inputTitle = sc.nextLine();

        System.out.println();

        Book[] ans1 = findBookMaximumPrice(books);
        for(int i=0; i<ans1.length; i++) {
            System.out.println(ans1[i].getId() + " " + ans1[i].getTitle());
        }

        Book ans2 = searchBookByTitle(books, inputTitle);
        System.out.println(ans2.getId());
        System.out.println(ans2.getPages());
    }
    public static Book[] findBookMaximumPrice(Book[] books) {
        List<Book> result = new ArrayList<>();
        double maxPrice = 0;
        for(int i=0; i<books.length; i++) {
            maxPrice = Math.max(maxPrice, books[i].getPrice());
        }
        for(Book book : books) {
            if(book.getPrice() == maxPrice) {
                result.add(book);
            }
        }
        return result.isEmpty() ? null : result.toArray(new Book[0]);
    }
    public static Book searchBookByTitle(Book[] books, String inputTitle) {
        for(int i=0; i<books.length; i++) {
            if(Objects.equals(books[i].getTitle(), inputTitle)) {
                return books[i];
            }
        }
        return null;
    }
}


class Book {
    private int id, pages;
    String title, author;
    private double price;

    public Book(int id, int pages, String title, String author, double price) {
        this.id = id;
        this.pages = pages;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}