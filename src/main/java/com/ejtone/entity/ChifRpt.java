package com.ejtone.entity;

import com.google.gson.GsonBuilder;

import java.io.Reader;

/**
 * Created by yuanjing on 16/3/24.
 */
public class ChifRpt {

    private String Msg_Id;
    private String Dest_Id;
    private String Src_terminal_Id;
    private String Stat;

    public static ChifRpt fromJson(String json ) {
        return new GsonBuilder( ).create( ).fromJson( json, ChifRpt.class );
    }

    public static ChifRpt fromJson(Reader jsonReader ) {
        return new GsonBuilder( ).create( ).fromJson( jsonReader, ChifRpt.class );
    }

    public String toJson( ) {
        return new GsonBuilder( ).create( ).toJson( this );
    }

    public ChifRpt(String msg_Id, String dest_Id, String src_terminal_Id, String stat) {
        Msg_Id = msg_Id;
        Dest_Id = dest_Id;
        Src_terminal_Id = src_terminal_Id;
        Stat = stat;
    }

    @Override
    public String toString() {
        return "ChifRpt{" +
                "Msg_Id='" + Msg_Id + '\'' +
                ", Dest_Id='" + Dest_Id + '\'' +
                ", Src_terminal_Id='" + Src_terminal_Id + '\'' +
                ", Stat='" + Stat + '\'' +
                '}';
    }

    public String getMsg_Id() {
        return Msg_Id;
    }

    public void setMsg_Id(String msg_Id) {
        Msg_Id = msg_Id;
    }

    public String getDest_Id() {
        return Dest_Id;
    }

    public void setDest_Id(String dest_Id) {
        Dest_Id = dest_Id;
    }

    public String getSrc_terminal_Id() {
        return Src_terminal_Id;
    }

    public void setSrc_terminal_Id(String src_terminal_Id) {
        Src_terminal_Id = src_terminal_Id;
    }

    public String getStat() {
        return Stat;
    }

    public void setStat(String stat) {
        Stat = stat;
    }
}
