/**
 * @author eamiear
 * @date 2018/9/25 10:48
 */

package com.ura.wechat.model.req;

import com.ura.wechat.model.base.AbstractMsgParams;

/**
 * 小视频消息
 */
public class MsgShortVideoParams extends AbstractMsgParams {
    private String MediaId;
    private String ThumbMediaId;

    @Override
    public String SetMsgType() {
        return "shortvideo";
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
