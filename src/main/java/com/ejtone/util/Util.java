package com.ejtone.util;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yuanjing on 16/3/24.
 */
public class Util {

    public static String getTimeStamp( ) {
        return new SimpleDateFormat( "yyyyMMddHHmmss" ).format( new Date( ) );
//		return "20150616150241";
    }

    public static byte[] encrypt( String key ) {
        try {
            MessageDigest alg = MessageDigest.getInstance( "MD5" );
            alg.reset( );
            alg.update( key.getBytes( ) );
            byte[] hash = alg.digest( ); // 得到摘要
            return hash;
        } catch( Exception ex ) {
            ex.printStackTrace( );
            return null;
        }
    }
}
