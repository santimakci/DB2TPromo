package com.zinbig.mongodemo.dtos;

import javax.persistence.Column;

public interface AccidentCommon {

    @Column(name = "condition")
    public String getCondition();

    @Column(name = "total")
    public int getTotal();

}
