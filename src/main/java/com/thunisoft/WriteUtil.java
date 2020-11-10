package com.thunisoft;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

/**
 * @author weibaolei
 * @version 1.0
 * @date 2020/10/27 14:19
 */

@Slf4j
public class WriteUtil {

    private static WriteUtil instance;
    private WriteUtil(){}
    public static WriteUtil getInstance(){
        if (instance == null){
            instance = new WriteUtil();
            return instance;
        }else
            return instance;
    }

    public boolean write(String path, List<Book> list){
        File file = new File(path);
        if (file.exists()&&file.isFile()){
            try (FileWriter fileWriter = new FileWriter(path,false);
                 BufferedWriter bw = new BufferedWriter(fileWriter))
            {
                list.forEach(book -> {
                    try {
                        bw.write(book.getName()+"\t"+book.getId()+"\t"+book.getAuthor()+"\t" +
                                book.getPress()+"\t"+book.getTime());
                        bw.newLine();
                    }catch (Exception e){
                        log.warn("",e);
                    }
                });
                log.info("复制成功！");
            }catch (Exception e){
                log.warn("",e);
            }
        }else {
            return false;
        }
        return true;
    }
}
