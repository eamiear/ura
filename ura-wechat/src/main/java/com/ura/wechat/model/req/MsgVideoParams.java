/**
 * @author eamiear
 * @date 2018/9/25 10:43
 */

package com.ura.wechat.model.req;

import com.ura.wechat.model.base.AbstractMsgParams;

/**
 * 语音消息
 */
public class MsgVideoParams extends AbstractMsgParams{
    private String MediaId;          // 视频消息媒体id， 可以调用多媒体文件下载接口拉取数据
    private String ThumbMediaId;    // 视频消息缩略图的媒体id， 可以调用多媒体文件下载接口拉取数据
    @Override
    public String SetMsgType() {
        return "video";
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
