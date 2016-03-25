package com.ejtone.entity;

import com.google.gson.GsonBuilder;

import java.io.Reader;

/**
 * Created by yuanjing on 16/3/24.
 */
public class HIFMTSubmit {
    private String Userid;
    private String Password;
    private String Cli_Msg_id;
    private String Mobile;
    private String Content;

    public static HIFMTSubmit fromJson(String json) {
        return ((HIFMTSubmit) new GsonBuilder().create().fromJson(json,
                HIFMTSubmit.class));
    }

    public static HIFMTSubmit fromJson(Reader jsonReader) {
        return ((HIFMTSubmit) new GsonBuilder().create().fromJson(jsonReader,
                HIFMTSubmit.class));
    }

    public String getUserid() {
        return this.Userid;
    }

    public void setUserid(String userid) {
        this.Userid = userid;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getCli_Msg_id() {
        return this.Cli_Msg_id;
    }

    public void setCli_Msg_id(String cli_Msg_id) {
        this.Cli_Msg_id = cli_Msg_id;
    }

    public String getMobile() {
        return this.Mobile;
    }

    public void setMobile(String mobile) {
        this.Mobile = mobile;
    }

    public String getContent() {
        return this.Content;
    }

    public void setContent(String content) {
        this.Content = content;
    }

    public String toJson() {
        return new GsonBuilder().create().toJson(this);
    }
}