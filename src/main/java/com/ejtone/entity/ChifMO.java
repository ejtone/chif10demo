package com.ejtone.entity;

import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.util.Arrays;

/**
 * Created by yuanjing on 16/3/24.
 */
public class ChifMO {

    private String Msg_Id;
    private String Dest_Id;
    private Integer TP_pId;
    private Integer TP_udhi;
    private Integer Msg_Fmt;
    private String Src_terminal_Id;
    private byte[] Msg_Content;

    public static ChifMO fromJson(String json ) {
        return new GsonBuilder( ).create( ).fromJson( json, ChifMO.class );
    }

    public static ChifMO fromJson(Reader jsonReader ) {
        return new GsonBuilder( ).create( ).fromJson( jsonReader, ChifMO.class );
    }

    public String toJson( ) {
        return new GsonBuilder( ).create( ).toJson( this );
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

    public Integer getTP_pId() {
        return TP_pId;
    }

    public void setTP_pId(Integer TP_pId) {
        this.TP_pId = TP_pId;
    }

    public Integer getTP_udhi() {
        return TP_udhi;
    }

    public void setTP_udhi(Integer TP_udhi) {
        this.TP_udhi = TP_udhi;
    }

    public Integer getMsg_Fmt() {
        return Msg_Fmt;
    }

    public void setMsg_Fmt(Integer msg_Fmt) {
        Msg_Fmt = msg_Fmt;
    }

    public String getSrc_terminal_Id() {
        return Src_terminal_Id;
    }

    public void setSrc_terminal_Id(String src_terminal_Id) {
        Src_terminal_Id = src_terminal_Id;
    }

    public byte[] getMsg_Content() {
        return Msg_Content;
    }

    public void setMsg_Content(byte[] msg_Content) {
        Msg_Content = msg_Content;
    }
}
