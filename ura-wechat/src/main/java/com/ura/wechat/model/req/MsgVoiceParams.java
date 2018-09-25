/**
 * @author eamiear
 * @date 2018/9/25 10:46
 */

package com.ura.wechat.model.req;

import com.ura.wechat.model.base.AbstractMsgParams;

/**
 * 语音消息
 */
public class MsgVoiceParams extends AbstractMsgParams {

    private String MediaId;
    private String Format;      // 语音格式，amr,speex等
    private String Recognition; // 开通语音识别后才会出现

    @Override
    public String SetMsgType() {
        return "voice";
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public String getRecognition() {
        return Recognition;
    }

    public void setRecognition(String recognition) {
        Recognition = recognition;
    }
}
