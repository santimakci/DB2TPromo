package com.zinbig.mongodemo.dtos;

import javax.persistence.Column;

public interface AccidentCommon {

    @Column(name = "col")
    public String getCol();

    @Column(name = "tot")
    public int getTot();

}
