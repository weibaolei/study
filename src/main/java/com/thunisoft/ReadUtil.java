package com.thunisoft;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author weibaolei
 * @version 1.0
 * @date 2020/10/27 14:19
 */

@Slf4j
public class ReadUtil {

    private static ReadUtil instance;
    private ReadUtil(){}
    public static ReadUtil getInstance(){
        if (instance == null){
            instance = new ReadUtil();
            return instance;
        }else
            return instance;
    }

    public ArrayList<String> readData(String path){
        File file = new File(path);
        ArrayList<String> list =new ArrayList<>();

        if (file.exists() && file.isFile()){
            try (FileReader fr =new FileReader(file);
                 BufferedReader bf = new BufferedReader(fr))
            {
                String str;
                while ((str = bf.readLine()) != null) {
                    list.add(str);
                }
                return list;
            }catch (Exception e){
                log.warn("",e);
            }
        }else {
            return list;
        }
        return list;
    }

    public ArrayList<Book> loadData(List<String> list){
        ArrayList<Book> books = new ArrayList<>();
        list.forEach(s -> {
            String[] tempString = s.split("\\|");
            if (tempString.length == 5 ){
                tempString[4] = tempString[4].replace("-", "/");
                Book book = new Book(tempString[0],tempString[1],tempString[2],tempString[3],tempString[4]);
                books.add(book);
            }
        });
        return books;
    }
}
