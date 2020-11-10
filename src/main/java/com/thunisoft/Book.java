package com.thunisoft;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

/**
 * @author weibaolei
 * @version 1.0
 * @date 2020/10/27 14:19
 */

@Data
@AllArgsConstructor
public class Book {
    private String name;
    private String id;
    private String author;
    private String press;
    private String time;
    Book(){}

    public boolean compare(Object obj){
        if(this == obj){
            return true;//地址相等
        }
        if(obj == null){
            return false;//非空性
        }
        if(obj instanceof Book){
            Book other = (Book) obj;
            //需要比较的字段相等，则这两个对象相等
            return (equalsStr(this.name, other.name)
                    && equalsStr(this.author, other.author)
                    && equalsStr(this.press, other.press)
                    && equalsStr(this.time, other.time));
        }
        return false;
    }
    private boolean equalsStr(String str1, String str2){
        if(StringUtils.isEmpty(str1) && StringUtils.isEmpty(str2)){
            return true;
        } else if(!StringUtils.isEmpty(str1) && str1.equals(str2)){
            return true;
        } else if(!StringUtils.isEmpty(str1) && !str1.equals(str2) && str2.equals("")){
            return true;
        }else {
            return false;
        }
    }

    public boolean isNullStr(){
        return (name.equals("") && author.equals("") && press.equals("") && time.equals(""));
    }
}
