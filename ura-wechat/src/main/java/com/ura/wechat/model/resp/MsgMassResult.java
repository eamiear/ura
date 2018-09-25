/**
 * @author eamiear
 * @date 2018/9/25 10:41
 */

package com.ura.wechat.model.resp;

/**
 * 群发消息返回结果
 */
public class MsgMassResult extends ResultState {
    private String type;    // 媒体文件类型，图片（image）、语音（voice）、视频（video）和缩略图（thumb），图文消息（news)
    private String msg_id;
    private String msg_data_id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(String msg_id) {
        this.msg_id = msg_id;
    }

    public String getMsg_data_id() {
        return msg_data_id;
    }

    public void setMsg_data_id(String msg_data_id) {
        this.msg_data_id = msg_data_id;
    }
}
