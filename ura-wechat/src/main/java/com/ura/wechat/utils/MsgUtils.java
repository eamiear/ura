package com.ura.wechat.utils;

import com.thoughtworks.xstream.XStream;
import com.ura.wechat.model.base.AbstractMsgResult;
import com.ura.wechat.model.base.AbstractPayParams;
import com.ura.wechat.model.resp.*;

public class MsgUtils {

  /**
   * 将消息java对象转换为xml
   * @param msg
   * @return
   */
  public static String msgToXml(AbstractMsgResult msg){
    String result = "";
    if (msg != null){
      XStream xstream = XmlUtils.XStreamFactory.init(true);
      xstream.alias("xml", msg.getClass());
      result = xstream.toXML(msg);
    }
    return result;
  }

  /**
   * 文本消息
   * 将text消息转为微信xml格式消息
   * @param text
   * @return
   */
  public static String textMsgToXml(MsgTextResult text){
    String result = "";
    if (text != null){
      XStream xs = XmlUtils.XStreamFactory.init(true);
      xs.alias("xml", MsgTextResult.class);
      result = xs.toXML(text);
    }
    return result;
  }

  /**
   * 图片消息
   * @param image
   * @return
   */
  public static String imageMsgToXml(MsgImageResult image){
    String result = "";
    if (image != null){
      XStream xs = XmlUtils.XStreamFactory.init(true);
      xs.alias("xml", MsgImageResult.class);
      xs.aliasField("Image", MsgImageResult.Image.class, "image");
      result = xs.toXML(image);
    }
    return result;
  }

  /**
   * 音乐消息
   * @param music
   * @return
   */
  public static String musicMsgToXml(MsgMusicResult music){
    String result = "";
    if (music != null){
      XStream xs = XmlUtils.XStreamFactory.init(true);
      xs.alias("xml", MsgMusicResult.class);
      xs.aliasField("Voice", MsgVoiceResult.Voice.class, "voice");
      result = xs.toXML(music);
    }
    return result;
  }

  /**
   * 图文消息
   * @param news
   * @return
   */
  public static String newsMsgToXml(MsgNewsResult news){
    String result = "";
    if (news != null){
      XStream xs = XmlUtils.XStreamFactory.init(true);
      xs.alias("xml", MsgNewsResult.class);
      xs.addImplicitCollection(MsgNewsResult.Articles.class, "list", "item", MsgNewsResult.Articles.Item.class);
      xs.aliasField("Articles", MsgNewsResult.Articles.class, "articles");
      result = xs.toXML(news);
    }
    return result;
  }

  /**
   * 视频消息
   * @param video
   * @return
   */
  public static String videoMsgToXml(MsgVideoResult video){
    String result = "";
    if (video != null){
      XStream xs = XmlUtils.XStreamFactory.init(true);
      xs.alias("xml", MsgVideoResult.class);
      xs.aliasField("Video", MsgVideoResult.Video.class, "video");
      result = xs.toXML(video);
    }
    return result;
  }

  /**
   * 语音消息
   * @param voice
   * @return
   */
  public static String voiceMsgToXml(MsgVoiceResult voice){
    String result = "";
    if (voice != null){
      XStream xs = XmlUtils.XStreamFactory.init(true);
      xs.alias("xml", MsgVoiceResult.class);
      xs.aliasField("Voice", MsgVoiceResult.Voice.class, "voice");
      result = xs.toXML(voice);
    }
    return result;
  }

  /**
   * 支付参数
   * @param pay
   * @return
   */
  public static String abstractPayToXml(AbstractPayParams pay){
    String sign = SignatureUtils.createSign(pay, null, null);
    pay.setSign(sign);
    return XmlUtils.toSplitXml(pay);
  }
}

