package com.ll;

/**
 * @ClassName Book
 * @Description
 * @Author 李振兴
 * @Date 2020/11/28 13:49
 **/
public class Book {
    private String author;
    private String bookname;
    private Integer price;
    private Integer stock;
    private Integer sales;

    public Book(String author, String bookname, Integer price, Integer stock, Integer sales) {
        this.author = author;
        this.bookname = bookname;
        this.price = price;
        this.stock = stock;
        this.sales = sales;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", bookname='" + bookname + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", sales=" + sales +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }
}
