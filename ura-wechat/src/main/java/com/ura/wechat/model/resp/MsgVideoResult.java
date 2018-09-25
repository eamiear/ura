/**
 * @author eamiear
 * @date 2018/9/25 10:35
 */

package com.ura.wechat.model.resp;

import com.ura.wechat.model.base.AbstractMsgResult;

/**
 * 回复视频消息
 */
public class MsgVideoResult extends AbstractMsgResult{

    private Video video;

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    @Override
    public String setMsgType() {
        return "video";
    }

    public class Video{
        private String MediaId; // 通过素材管理中的接口上传多媒体文件，得到的id
        private String Title;   // 视频消息标题
        private String Description; // 视频消息描述

        public String getMediaId() {
            return MediaId;
        }

        public void setMediaId(String mediaId) {
            MediaId = mediaId;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String description) {
            Description = description;
        }
    }
}
