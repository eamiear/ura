/**
 * @author eamiear
 * @date 2018/9/25 10:09
 */

package com.ura.wechat.model.req;

import com.ura.wechat.model.base.AbstractMsgParams;

/**
 * 图片消息
 */
public class MsgImageParams extends AbstractMsgParams {

    private String picUrl;  // 图片链接
    private String MediaId; // 图片消息媒体id，可以调用多媒体文件下载接口拉取数据

    @Override
    public String SetMsgType() {
        return "image";
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
