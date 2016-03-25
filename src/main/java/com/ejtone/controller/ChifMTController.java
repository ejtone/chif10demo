package com.ejtone.controller;

/**
 * Created by yuanjing on 16/1/5.
 */


import com.ejtone.entity.ChifMTSubmit;
import com.ejtone.entity.ChifResp;
import com.ejtone.entity.ChifRets;
import com.ejtone.util.Util;
import com.google.gson.GsonBuilder;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;

import static com.ejtone.util.Util.getTimeStamp;

/**
 * <p>User: Ejtone易捷通(北京)科技有限公司
 * <p>Date: 15-12-22
 * <p>Version: 1.0
 */
@EnableAutoConfiguration
@RestController
public class ChifMTController {
    static Log log = LogFactory.getLog(ChifMTController.class);

    public static String baseUrl = "http://ip:port/chif10";

    @RequestMapping(method = RequestMethod.GET, value = "/testmt/{user}/{pw}/{mobiles}/{content}")
    public String mtsms(@PathVariable String user,@PathVariable String pw,@PathVariable String mobiles,@PathVariable String content){
        HttpPost httpRequest = null;
        String result = "";
        try {


            log.info("MT Params: mobiles: "+ mobiles+ " content: "+content);
            String time = getTimeStamp();
            String token = Hex.encodeHexString(Util.encrypt(user + time + pw));
            String url = baseUrl + "/mtsms/" + user + "/" + token;

            HttpClient client = HttpClientBuilder.create().build();
            httpRequest = new HttpPost(url);

            httpRequest.setHeader("Accept", "application/json");
            httpRequest.setHeader("Content-Type", "application/json;charset=utf-8");
            String str = user + ":" + time;
            byte[] datas = str.getBytes("GBK");
            String authorization = new String(Base64.encodeBase64(datas));
            httpRequest.setHeader("Authorization", authorization);

            log.info("orig str: " + str);

            ChifMTSubmit submit = new ChifMTSubmit();
            submit.setCli_Msg_Id( "12345" );
            submit.setDest_terminal_Id(mobiles.split(","));
            submit.setMsg_Fmt(15);
            submit.setMsg_level(0);
            submit.setMsg_src("");
            submit.setPk_number(1);
            submit.setPk_total(1);
            submit.setRegistered_Delivery(1);
            submit.setService_Id("");
            submit.setSrc_Id("");
            submit.setTP_pId(0);
            submit.setTP_udhi(0);

            byte[] msg_content = content.getBytes("GBK");  //"iso-8859-1"
            submit.setMsg_Content(msg_content);

            String json = submit.toJson();
            log.info(json);
            log.info("Authorization:" + authorization);
            log.info("token:" + token);
            httpRequest.setEntity(new StringEntity(json, "UTF-8"));

            HttpResponse response = client.execute(httpRequest);
            log.info(httpRequest.getURI() + "执行完毕,!");

            result = printResponse(response);
        } catch( Exception e ) {
            log.error( " exception : ", e );
        } finally {
            if( httpRequest != null ) {
                httpRequest.reset( );
            }
        }
        return result;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/testquery/{user}/{pw}")
    public String queryamtf(@PathVariable String user,@PathVariable String pw ) {
        HttpPost httpRequest = null;
        String result = "";
        try {
            String time = getTimeStamp( );
            String token = Hex.encodeHexString( Util.encrypt( user + time + pw ) );
            String url = baseUrl + "/queryamtf/" + user + "/" + token;

            HttpClient client = HttpClientBuilder.create().build();
            httpRequest = new HttpPost( );
            httpRequest.setURI( new URI( url ) );
            httpRequest.setHeader( "Accept", "application/json" );
            httpRequest.setHeader( "Content-Type", "application/json;charset=utf-8" );
            String str = user + ":" + time;
            byte[] datas = str.getBytes("GBK");
            httpRequest.setHeader( "Authorization", new String(Base64.encodeBase64(datas)));

            HttpResponse httpResponse =null; //send msg
            httpResponse = client.execute(httpRequest); //send msg
            log.info(httpRequest.getURI() + "执行完毕,!");

            result = printResponse(httpResponse);

        } catch( Exception e ) {
            log.error( "", e );
        }
        return result;
    }

    private String printResponse(HttpResponse httpResponse) throws IOException {
        StringBuilder sb=new StringBuilder();
        //handle resp
        int rspcode = httpResponse.getStatusLine().getStatusCode();
        sb.append(rspcode+"\r\n");
        log.info("response code:" + rspcode);
        Header[] headers = httpResponse.getAllHeaders();
        for (Header header: headers
                ) {
            sb.append(header+"\r\n");
            log.info(header);
        }

        String json = EntityUtils.toString(httpResponse.getEntity());
        sb.append(json);
        log.info("response body:" + json);
        if(json!=null&&json.length()>0){
            log.info(json);
            ChifRets rets = new GsonBuilder( ).create( ).fromJson( json, ChifRets.class );
            ChifResp[] arr = rets.getRets();
            for (int i = 0; i < arr.length; i++) {
                ChifResp chifresp = arr[i];
                log.info(chifresp.toJson());
            }

        }
        return sb.toString();
    }
}

