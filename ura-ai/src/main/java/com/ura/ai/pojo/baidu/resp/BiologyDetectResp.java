/**
 * @author eamiear
 * @date 2018/12/4 10:28
 */

package com.ura.ai.pojo.baidu.resp;

// 生物检测，植物、动物
public class BiologyDetectResp {
    private String name;
    private String score;
    private String baikeUrl;
    private String baikeImageUrl;
    private String baikeDescription;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getBaikeUrl() {
        return baikeUrl;
    }

    public void setBaikeUrl(String baikeUrl) {
        this.baikeUrl = baikeUrl;
    }

    public String getBaikeImageUrl() {
        return baikeImageUrl;
    }

    public void setBaikeImageUrl(String baikeImageUrl) {
        this.baikeImageUrl = baikeImageUrl;
    }

    public String getBaikeDescription() {
        return baikeDescription;
    }

    public void setBaikeDescription(String baikeDescription) {
        this.baikeDescription = baikeDescription;
    }
}
