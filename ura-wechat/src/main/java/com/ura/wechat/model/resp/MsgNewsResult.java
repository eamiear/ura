/**
 * @author eamiear
 * @date 2018/9/25 10:26
 */

package com.ura.wechat.model.resp;

import com.ura.wechat.model.base.AbstractMsgResult;

import java.util.List;

/**
 * 图文消息
 */
public class MsgNewsResult extends AbstractMsgResult {

    private int ArticleCount;
    private Articles articles;

    @Override
    public String setMsgType() {
        return "news";
    }

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public Articles getArticles() {
        return articles;
    }

    public void setArticles(Articles articles) {
        this.articles = articles;
    }

    public class Articles{
        private List<Item> list;

        public List<Item> getList() {
            return list;
        }

        public void setList(List<Item> list) {
            this.list = list;
        }

        public class Item{
            private String Title;   // 图文消息名称
            private String Description; // 图文消息描述
            private String PicUrl;      // 图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80,限制图片链接的域名需要与开发者填写的基本资料中的url一致
            private String Url;         // 点击图文消息跳转链接

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

            public String getPicUrl() {
                return PicUrl;
            }

            public void setPicUrl(String picUrl) {
                PicUrl = picUrl;
            }

            public String getUrl() {
                return Url;
            }

            public void setUrl(String url) {
                Url = url;
            }
        }
    }
}
