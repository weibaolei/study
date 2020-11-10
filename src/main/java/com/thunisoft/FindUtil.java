package com.thunisoft;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author weibaolei
 * @version 1.0
 * @date 2020/10/27 14:19
 */

@Slf4j
public class FindUtil {
    private static FindUtil instance;
    private FindUtil(){}
    public static FindUtil getInstance(){
        if (instance == null){
            instance = new FindUtil();
            return instance;
        }else
            return instance;
    }
    /*根据输入查询，支持模糊查询*/
    public List<Book> findBookBlurry(List<Book> books){
        Scanner scanner = new Scanner(System.in);
        log.info("选择需要输入信息：1.名称 2.作者 3.出版社 4.出版日期");
        int searchTag = scanner.nextInt();
        log.info("输入查询信息：");
        String str = scanner.next();
        ArrayList<Book> findBooks = new ArrayList<>();
        switch (searchTag){
            case 1:books.forEach(book -> { if (book.getName().contains(str)){ findBooks.add(book); }});break;
            case 2:books.forEach(book -> { if (book.getAuthor().contains(str)){ findBooks.add(book); }});break;
            case 3:books.forEach(book -> { if (book.getPress().contains(str)){ findBooks.add(book); }});break;
            case 4:books.forEach(book -> { if (book.getTime().contains(str)){ findBooks.add(book); }});break;
            default:break;
        }
        return findBooks;
    }
    /*根据多个输入查询*/
    public List<Book> findBooks(List<Book> books){
        ArrayList<Book> findBooks = new ArrayList<>();
        log.info("输入具体信息(名称，作者，出版社，出版日期)：");
        Book tempbook = new Book();
        Scanner scanner = new Scanner(System.in);
        tempbook.setName(scanner.nextLine());
        tempbook.setAuthor(scanner.nextLine());
        tempbook.setPress(scanner.nextLine());
        tempbook.setTime(scanner.nextLine());
        if (tempbook.isNullStr()){
            return findBooks;
        }
        books.forEach(book -> {
            if (book.compare(tempbook)){
                findBooks.add(book);
            }
        });
        return findBooks;
    }
}
