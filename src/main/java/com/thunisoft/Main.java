package com.thunisoft;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author weibaolei
 * @version 1.0
 * @date 2020/10/27 14:19
 */

@Slf4j
public class Main {
    public static void main(String[] avg){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list;
        ArrayList<Book> books;
        log.info("输入数据源文件:");
        String path = scanner.next();
        list = ReadUtil.getInstance().readData(path);
        while (list.isEmpty()){
            log.info("读取失败,重新输入读取地址(输入#退出):");
            path = scanner.next();
            if (path.equals("#"))
                System.exit(0);
            list = ReadUtil.getInstance().readData(path);
        }
        books = ReadUtil.getInstance().loadData(list);
        log.info("输入需要写入文件地址:");
        path = scanner.next();
        while (!WriteUtil.getInstance().write(path, books)){
            log.warn("写入失败,重新输入写入地址(输入#退出):");
            path = scanner.next();
            if (path.equals("#"))
                System.exit(0);
        }

        int isContinue = 1;
        while (isContinue == 1){
            ArrayList<Book> outBooks;
            log.info("选择查询方式:1.精确查询 2.模糊查询");
            int searchType = scanner.nextInt();
            switch (searchType){
                case 1 :outBooks = (ArrayList<Book>) FindUtil.getInstance().findBooks(books);break;
                case 2 :outBooks = (ArrayList<Book>) FindUtil.getInstance().findBookBlurry(books);break;
                default:outBooks = new ArrayList<>();break;
            }
            log.info("查询结果:");
            if (outBooks.isEmpty()){
                log.info("无数据");
            }else {
                outBooks.forEach(book -> {
                    log.info(book.toString());
                });
            }
            log.info("输入1继续");
            isContinue = scanner.nextInt();
        }
    }
}
