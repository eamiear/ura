/**
 * @author eamiear
 * @date 2018/12/4 9:42
 */

package com.ura.ai.pojo.baidu.resp;

public class GeneralDetectResp {
    private Integer resultNum;
    private String keyword;
    private String tag;
    private String score;
    private String baikeUrl;
    private String baikeImageUrl;
    private String baikeDescription;

    public Integer getResultNum() {
        return resultNum;
    }

    public void setResultNum(Integer resultNum) {
        this.resultNum = resultNum;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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
