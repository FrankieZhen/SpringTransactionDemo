package com.example.demo.util;

/**
 * @author xuchaozhen
 */

import java.io.Serializable;

public interface BizEnum extends Serializable {

    int getCode();

    String getName();

    String getDesc();
}
