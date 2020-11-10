package com.thunisoft;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestUtil {
    @Test
    public void test_reader(){
        ArrayList<String> list = ReadUtil.getInstance().readData("E:/demo.txt");
        Assert.assertEquals(4, list.size());
    }

    @Test
    public void test_write(){
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("a", "b", "c", "d", "e"));
        Assert.assertEquals(true, WriteUtil.getInstance().write("E:/test.txt",books));
    }

}
