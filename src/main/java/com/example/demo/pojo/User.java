
package com.example.demo.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author xuchaozhen
 **/
@Data
@Accessors(chain = true)
public class User {

    private Integer id;
    private String name;
    private Integer age;

}
