/**
 * @author eamiear
 * @date 2018/9/25 10:02
 */

package com.ura.wechat.model.req;

import com.ura.wechat.model.base.AbstractMsgParams;

/**
 * 文本消息
 */
public class MsgTextParams extends AbstractMsgParams{
    private String Content; //文本消息

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String SetMsgType() {
        return "text";
    }
}
