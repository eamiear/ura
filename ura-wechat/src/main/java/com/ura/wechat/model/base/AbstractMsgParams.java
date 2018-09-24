package com.ura.wechat.model.base;

import java.io.Serializable;

/**
 * 基础消息类
 */
public abstract class AbstractMsgParams implements Serializable{

  private String ToUserName;  // 开发者微信号
  private String FromUserName;  // 发送方账号（OpenID）
  private String MsgType = SetMsgType();  // 消息类型 如/text  /image
  private long CreateTime;    // 消息创建时间
  private long MsgId;         // 消息id，64位


  public abstract String SetMsgType();

  public String getToUserName() {
    return ToUserName;
  }

  public void setToUserName(String toUserName) {
    ToUserName = toUserName;
  }

  public String getFromUserName() {
    return FromUserName;
  }

  public void setFromUserName(String fromUserName) {
    FromUserName = fromUserName;
  }

  public String getMsgType() {
    return MsgType;
  }

  public void setMsgType(String msgType) {
    MsgType = msgType;
  }

  public long getCreateTime() {
    return CreateTime;
  }

  public void setCreateTime(long createTime) {
    CreateTime = createTime;
  }

  public long getMsgId() {
    return MsgId;
  }

  public void setMsgId(long msgId) {
    MsgId = msgId;
  }
}
