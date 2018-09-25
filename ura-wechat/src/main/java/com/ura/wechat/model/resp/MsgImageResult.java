/**
 * @author eamiear
 * @date 2018/9/25 10:11
 */

package com.ura.wechat.model.resp;

import com.ura.wechat.model.base.AbstractMsgResult;

/**
 * 回复图片消息
 */
public class MsgImageResult extends AbstractMsgResult {

    private Image image;

    @Override
    public String setMsgType() {
        return "image";
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public class Image{
        private String MediaId; // 通过素材管理中的接口上传多媒体文件，得到的id

        public String getMediaId() {
            return MediaId;
        }

        public void setMediaId(String mediaId) {
            MediaId = mediaId;
        }
    }
}
