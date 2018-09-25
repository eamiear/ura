/**
 * @author eamiear
 * @date 2018/9/25 10:40
 */

package com.ura.wechat.model.resp;

/**
 * 发送状态
 */
public class SendSatusResult {
    private long msg_id;    // 消息id
    private String msg_status;  // 消息状态

    public long getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(long msg_id) {
        this.msg_id = msg_id;
    }

    public String getMsg_status() {
        return msg_status;
    }

    public void setMsg_status(String msg_status) {
        this.msg_status = msg_status;
    }
}
