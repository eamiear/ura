package com.ura.wechat.model.resp;

import com.ura.wechat.model.base.AbstractResult;

public class ResultState extends AbstractResult {
  private int errcode;

  public int getErrcode() {
    return errcode;
  }

  public void setErrcode(int errcode) {
    this.errcode = errcode;
  }

  public String getErrmsg() {
    return errmsg;
  }

  public void setErrmsg(String errmsg) {
    this.errmsg = errmsg;
  }

  private String errmsg;


}
