
package com.example.demo.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author xuchaozhen
 * @since 2020-10-22
 **/
@Data
@Accessors(chain = true)
public class Student {

    private Integer id;
    private String name;
    private Integer sex;
    private String desc;

}
