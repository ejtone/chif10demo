package com.ejtone.entity;

import com.google.gson.GsonBuilder;

import java.io.Reader;

/**
 * Created by yuanjing on 16/3/24.
 */
public class ChifRets {

    private ChifResp[] Rets;

    public static ChifRets fromJson(String json ) {
        return new GsonBuilder( ).create( ).fromJson( json, ChifRets.class );
    }

    public static ChifRets fromJson(Reader jsonReader ) {
        return new GsonBuilder( ).create( ).fromJson( jsonReader, ChifRets.class );
    }

    public String toJson( ) {
        return new GsonBuilder( ).create( ).toJson( this );
    }

    public ChifResp[] getRets() {
        return Rets;
    }

    public void setRets(ChifResp[] rets) {
        Rets = rets;
    }
}
