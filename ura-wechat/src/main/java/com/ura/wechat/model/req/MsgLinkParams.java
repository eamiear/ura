/**
 * @author eamiear
 * @date 2018/9/25 10:13
 */

package com.ura.wechat.model.req;

import com.ura.wechat.model.base.AbstractMsgParams;

/**
 * 链接消息
 */
public class MsgLinkParams extends AbstractMsgParams {

    private String Title;       // 消息标题
    private String Description; // 消息描述
    private String url;         // 消息链接

    @Override
    public String SetMsgType() {
        return "link";
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
