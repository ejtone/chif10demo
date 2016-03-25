package com.ejtone.entity;

import com.google.gson.GsonBuilder;

import java.io.Reader;

/**
 * Created by yuanjing on 16/3/24.
 */
public class ChifResp {

    private String Msg_Id;
    private String Dest_terminal_Id;
    private Integer Rspcode;

    public static ChifResp fromJson(String json ) {
        return new GsonBuilder( ).create( ).fromJson( json, ChifResp.class );
    }

    public static ChifResp fromJson(Reader jsonReader ) {
        return new GsonBuilder( ).create( ).fromJson( jsonReader, ChifResp.class );
    }

    public String toJson( ) {
        return new GsonBuilder( ).create( ).toJson( this );
    }

    public ChifResp(String msg_Id, String dest_terminal_Id, Integer rspcode) {
        Msg_Id = msg_Id;
        Dest_terminal_Id = dest_terminal_Id;
        Rspcode = rspcode;
    }

    public String getMsg_Id() {
        return Msg_Id;
    }

    public void setMsg_Id(String msg_Id) {
        Msg_Id = msg_Id;
    }

    public String getDest_terminal_Id() {
        return Dest_terminal_Id;
    }

    public void setDest_terminal_Id(String dest_terminal_Id) {
        Dest_terminal_Id = dest_terminal_Id;
    }

    public Integer getRspcode() {
        return Rspcode;
    }

    public void setRspcode(Integer rspcode) {
        Rspcode = rspcode;
    }

}
