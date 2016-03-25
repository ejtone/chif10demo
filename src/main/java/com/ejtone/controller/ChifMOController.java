package com.ejtone.controller;

/**
 * Created by yuanjing on 16/1/5.
 */


import com.ejtone.entity.ChifMO;
import com.ejtone.entity.ChifRpt;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * <p>User: Yuanjing
 * <p>Date: 15-12-22
 * <p>Version: 1.0
 */
@EnableAutoConfiguration
@RestController
@RequestMapping("/mybase")
public class ChifMOController {
    static Log log = LogFactory.getLog(ChifMOController.class);

    /**
     * 处理CHIF10协议的上行消息
     * @param json
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/smsmopush")
    public String smsmopush(@RequestBody String json){
        log.info(json);
        ChifMO chifMO = ChifMO.fromJson(json);
        log.info(chifMO.toJson());
        try {
            int encode = chifMO.getMsg_Fmt().intValue();
            String enc = "GBK";
            switch (encode)
            {
                case 0 :  //ASCII串
                    enc = "iso-8859-1";
                    break;
                case 3 :  //短信写卡操作
                    enc = "iso-8859-1";
                    break;
                case 4 :   //二进制信息
                    enc = "iso-8859-1";
                    break;

                case 8 :{  //UCS2编码
                    enc = "UTF-16";
                    break;
                }
                case 15 :{  //含GB汉字
                    enc = "GBK";
                    break;
                }
                default :{
                    break;
                }
            }
            String cont = new String(chifMO.getMsg_Content(), enc);
            log.info("Receive MO: "+ chifMO.getSrc_terminal_Id()+":"+cont);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 处理CHIF10协议的状态报告
     *
     * @param json
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/smsrptpush")
    public String smsrptpush(@RequestBody String json){
        log.info(json);
        ChifRpt chifrpt = ChifRpt.fromJson(json);
        log.info("Received sms report: "+chifrpt.getSrc_terminal_Id()+":"+chifrpt.getStat()+ ":"+chifrpt.toJson() );
        return json;
    }

}

