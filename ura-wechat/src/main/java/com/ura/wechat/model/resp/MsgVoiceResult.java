/**
 * @author eamiear
 * @date 2018/9/25 10:38
 */

package com.ura.wechat.model.resp;

import com.ura.wechat.model.base.AbstractMsgResult;

/**
 * 回复语音消息
 */
public class MsgVoiceResult extends AbstractMsgResult {

    private Voice voice;

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    @Override
    public String setMsgType() {
        return "voice";
    }

    public class Voice{
        private String MediaId;

        public String getMediaId() {
            return MediaId;
        }

        public void setMediaId(String mediaId) {
            MediaId = mediaId;
        }
    }
}
