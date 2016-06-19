author: yuanjing
version: 1.0.0 20160325


# chif10demo
## Overview
此项目用于演示CHIF10短消息接入协议的编程方法
## 关于CHIF10

CHIF（ CMPP compatible Http InterFace）1.0
是由开发的短信接入协议，
此协议兼容中国移动点对点短信协议CMPP （ China Mobile Peer to Peer）2.0/3.0。
可以发送CMPP2.0支持的各种消息，包括但不限于
1. 普通短信
2. 超长短信
3. 短信写卡操作
4. OTA
5. ...
##版本
当前为1.0
##应用范围
用于*易捷通* 公司为其客户提供的短消息平台，作为多种接入协议中的一种。
##协议交互方式
CHIF10 采用http交互方式

##下行
###例子
```
{
  "Pk_total": 1,
  "Pk_number": 1,
  "Registered_Delivery": 1,
  "Msg_level": 0,
  "Service_Id": "",
  "TP_pId": 0,
  "TP_udhi": 0,
  "Msg_Fmt": 0,
  "Msg_src": "",
  "Src_Id": "",
  "Dest_terminal_Id": [
    "13910101010"
  ],
  "Msg_Content": [
    51,55,50,57,51,57,50,51,50
  ]
}
```

##状态报告
###例子
```
{
  "Rets": [
    {
      "Rspcode": 0,
      "Msg_Id": "0325165925000001016455-12345",
      "Dest_terminal_Id": "13910638719"
    }
  ]
}
```
###模拟推送状态报告测试
```
curl -v -X POST -H "Accept: application/json" \
-H "Content-Type: application/json;charset=utf-8" \
-d '{"Msg_Id":"0325171726000001000908-12345","Dest_Id":"106900110011001","Src_terminal_Id":"13910101010","Stat":"DELIVRD"}' \
http://localhost:8080/mybase/smsrptpush
```



##上行
###例子
```
{
  "Msg_Id": "0325165507000104118440",
  "Dest_Id": "10690570558",
  "TP_pId": 0,
  "TP_udhi": 0,
  "Msg_Fmt": 8,
  "Src_terminal_Id": "13910101010",
  "Msg_Content": [78,45,0,49]
}
```
###模拟推送上行测试
**此模拟上行消息内容体编码集为UCS2，消息内容为："中1"**
```
curl -v -X POST -H "Accept: application/json" \                        
-H "Content-Type: application/json;charset=utf-8" \
-d '{Msg_Id='0325165507000104118440', Dest_Id='106900110001', TP_pId=0, TP_udhi=0, Msg_Fmt=8, Src_terminal_Id='13910101010', Msg_Content=[78, 45, 0, 49]}' \
http://localhost:8080/mybase/smsmopush
```

###模拟下行发送
通过浏览器,发送GET请求
http://sandbox.ejtone.com:8080/testmt/a00119/password/18910xxxxxxx/【测试签名】测试内容

## 许可
版权归属易捷通（北京）科技有限公司

![img](https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png)
本作品采用[知识共享署名-非商业性使用-相同方式共享 4.0 国际许可协议](http://creativecommons.org/licenses/by-nc-sa/4.0/)进行许可。
