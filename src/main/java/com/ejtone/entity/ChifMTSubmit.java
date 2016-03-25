package com.ejtone.entity;

import com.google.gson.GsonBuilder;

import java.io.Reader;

/**
 * Created by yuanjing on 16/3/24.
 */
public class ChifMTSubmit {

    private String Cli_Msg_Id;
    private Integer Pk_total;
    private Integer Pk_number;
    private Integer Registered_Delivery;
    private Integer Msg_level;
    private String Service_Id;
    private Integer TP_pId;
    private Integer TP_udhi;
    private Integer Msg_Fmt;
    private String Msg_src;
    private String Src_Id;
    private String[] Dest_terminal_Id;
    private byte[] Msg_Content;

    public static ChifMTSubmit fromJson(String json ) {
        return new GsonBuilder( ).create( ).fromJson( json, ChifMTSubmit.class );
    }

    public static ChifMTSubmit fromJson(Reader jsonReader ) {
        return new GsonBuilder( ).create( ).fromJson( jsonReader, ChifMTSubmit.class );
    }

    public String toJson( ) {
        return new GsonBuilder( ).create( ).toJson( this );
    }

    public String getCli_Msg_Id( ) {
        return Cli_Msg_Id;
    }

    public void setCli_Msg_Id( String cli_Msg_Id ) {
        Cli_Msg_Id = cli_Msg_Id;
    }

    public Integer getPk_total( ) {
        return Pk_total;
    }

    public void setPk_total( Integer pk_total ) {
        Pk_total = pk_total;
    }

    public Integer getPk_number( ) {
        return Pk_number;
    }

    public void setPk_number( Integer pk_number ) {
        Pk_number = pk_number;
    }

    public Integer getRegistered_Delivery( ) {
        return Registered_Delivery;
    }

    public void setRegistered_Delivery( Integer registered_Delivery ) {
        Registered_Delivery = registered_Delivery;
    }

    public Integer getMsg_level( ) {
        return Msg_level;
    }

    public void setMsg_level( Integer msg_level ) {
        Msg_level = msg_level;
    }

    public String getService_Id( ) {
        return Service_Id;
    }

    public void setService_Id( String service_Id ) {
        Service_Id = service_Id;
    }

    public Integer getTP_pId( ) {
        return TP_pId;
    }

    public void setTP_pId( Integer tP_pId ) {
        TP_pId = tP_pId;
    }

    public Integer getTP_udhi( ) {
        return TP_udhi;
    }

    public void setTP_udhi( Integer tP_udhi ) {
        TP_udhi = tP_udhi;
    }

    public Integer getMsg_Fmt( ) {
        return Msg_Fmt;
    }

    public void setMsg_Fmt( Integer msg_Fmt ) {
        Msg_Fmt = msg_Fmt;
    }

    public String getMsg_src( ) {
        return Msg_src;
    }

    public void setMsg_src( String msg_src ) {
        Msg_src = msg_src;
    }

    public String getSrc_Id( ) {
        return Src_Id;
    }

    public void setSrc_Id( String src_Id ) {
        Src_Id = src_Id;
    }

    public String[] getDest_terminal_Id( ) {
        return Dest_terminal_Id;
    }

    public void setDest_terminal_Id( String[] dest_terminal_Id ) {
        Dest_terminal_Id = dest_terminal_Id;
    }

    public byte[] getMsg_Content( ) {
        return Msg_Content;
    }

    public void setMsg_Content( byte[] msg_Content ) {
        Msg_Content = msg_Content;
    }
}