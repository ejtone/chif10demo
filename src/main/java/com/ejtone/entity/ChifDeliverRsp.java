package com.ejtone.entity;

import com.google.gson.GsonBuilder;

import java.io.Reader;

/**
 * Created by yuanjing on 16/3/24.
 */
public class ChifDeliverRsp {

    private String Rspcode;

    public static ChifDeliverRsp fromJson(String json ) {
        return new GsonBuilder( ).create( ).fromJson( json, ChifDeliverRsp.class );
    }

    public static ChifDeliverRsp fromJson(Reader jsonReader ) {
        return new GsonBuilder( ).create( ).fromJson( jsonReader, ChifDeliverRsp.class );
    }

    public String toJson( ) {
        return new GsonBuilder( ).create( ).toJson( this );
    }

    public String getRspcode() {
        return Rspcode;
    }

    public void setRspcode(String rspcode) {
        Rspcode = rspcode;
    }
}