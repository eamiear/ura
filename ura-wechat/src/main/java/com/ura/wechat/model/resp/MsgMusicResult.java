/**
 * @author eamiear
 * @date 2018/9/25 10:21
 */

package com.ura.wechat.model.resp;

import com.ura.wechat.model.base.AbstractMsgResult;

/**
 * 音乐消息
 */
public class MsgMusicResult extends AbstractMsgResult{

    private Music music;

    @Override
    public String setMsgType() {
        return "music";
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public class Music{
        private String Title;   // 音乐名称
        private String Description; // 音乐描述
        private String MusicUrl;    // 音乐链接
        private String HQMusicUrl;  // 高质量音乐链接。WIFI环境优先使用该连接播放音乐
        private String ThumbMediaId; // 缩略图的媒体id， 通过素材管理中接口上传多媒体文件，得到的id

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

        public String getMusicUrl() {
            return MusicUrl;
        }

        public void setMusicUrl(String musicUrl) {
            MusicUrl = musicUrl;
        }

        public String getHQMusicUrl() {
            return HQMusicUrl;
        }

        public void setHQMusicUrl(String HQMusicUrl) {
            this.HQMusicUrl = HQMusicUrl;
        }

        public String getThumbMediaId() {
            return ThumbMediaId;
        }

        public void setThumbMediaId(String thumbMediaId) {
            ThumbMediaId = thumbMediaId;
        }
    }
}
