/**
 * @author eamiear
 * @date 2018/9/25 10:07
 */

package com.ura.wechat.model.resp;

import com.ura.wechat.model.base.AbstractMsgResult;

/**
 * 文本消息
 */
public class MsgTextResult extends AbstractMsgResult {
    // 回复消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String setMsgType() {
        return "text";
    }
}
