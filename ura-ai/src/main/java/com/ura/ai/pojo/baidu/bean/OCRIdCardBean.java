/**
 * @author eamiear
 * @date 2018/12/4 15:24
 */

package com.ura.ai.pojo.baidu.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class OCRIdCardBean {
    private Integer direction;
    private String image_status;
    private String risk_type;
    private String edit_tool;
    private List<WordsResult> words_result;
    private Integer words_result_num;

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public String getImage_status() {
        return image_status;
    }

    public void setImage_status(String image_status) {
        this.image_status = image_status;
    }

    public String getRisk_type() {
        return risk_type;
    }

    public void setRisk_type(String risk_type) {
        this.risk_type = risk_type;
    }

    public String getEdit_tool() {
        return edit_tool;
    }

    public void setEdit_tool(String edit_tool) {
        this.edit_tool = edit_tool;
    }

    public List<WordsResult> getWords_result() {
        return words_result;
    }

    public void setWords_result(List<WordsResult> words_result) {
        this.words_result = words_result;
    }

    public Integer getWords_result_num() {
        return words_result_num;
    }

    public void setWords_result_num(Integer words_result_num) {
        this.words_result_num = words_result_num;
    }

    public static class WordsResult{
        @JSONField(name = "住址")
        private Address address;
        @JSONField(name = "公民身份号码")
        private IdCardNum idCardNum;
        @JSONField(name="出生")
        private Birth birth;
        @JSONField(name="姓名")
        private Name name;
        @JSONField(name="性别")
        private Sex sex;
        @JSONField(name="民族")
        private Nation nation;
        @JSONField(name="签发日期")
        private IssueDate issueDate;
        @JSONField(name="签发机关")
        private Authority authority;
        @JSONField(name="失效日期")
        private ExpireDate expireDate;

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public IdCardNum getIdCardNum() {
            return idCardNum;
        }

        public void setIdCardNum(IdCardNum idCardNum) {
            this.idCardNum = idCardNum;
        }

        public Birth getBirth() {
            return birth;
        }

        public void setBirth(Birth birth) {
            this.birth = birth;
        }

        public Name getName() {
            return name;
        }

        public void setName(Name name) {
            this.name = name;
        }

        public Sex getSex() {
            return sex;
        }

        public void setSex(Sex sex) {
            this.sex = sex;
        }

        public Nation getNation() {
            return nation;
        }

        public void setNation(Nation nation) {
            this.nation = nation;
        }

        public IssueDate getIssueDate() {
            return issueDate;
        }

        public void setIssueDate(IssueDate issueDate) {
            this.issueDate = issueDate;
        }

        public Authority getAuthority() {
            return authority;
        }

        public void setAuthority(Authority authority) {
            this.authority = authority;
        }

        public ExpireDate getExpireDate() {
            return expireDate;
        }

        public void setExpireDate(ExpireDate expireDate) {
            this.expireDate = expireDate;
        }
    }

    public static class Address{
        private Location location;
        private String words;
        public void setLocation(Location location) {
            this.location = location;
        }
        public Location getLocation() {
            return location;
        }
        public void setWords(String words) {
            this.words = words;
        }
        public String getWords() {
            return words;
        }
    }
    public static class IdCardNum{
        private Location location;
        private String words;
        public void setLocation(Location location) {
            this.location = location;
        }
        public Location getLocation() {
            return location;
        }
        public void setWords(String words) {
            this.words = words;
        }
        public String getWords() {
            return words;
        }
    }
    public static class Birth{
        private Location location;
        private String words;
        public void setLocation(Location location) {
            this.location = location;
        }
        public Location getLocation() {
            return location;
        }
        public void setWords(String words) {
            this.words = words;
        }
        public String getWords() {
            return words;
        }
    }
    public static class Name{
        private Location location;
        private String words;
        public void setLocation(Location location) {
            this.location = location;
        }
        public Location getLocation() {
            return location;
        }
        public void setWords(String words) {
            this.words = words;
        }
        public String getWords() {
            return words;
        }
    }
    public static class Sex{
        private Location location;
        private String words;
        public void setLocation(Location location) {
            this.location = location;
        }
        public Location getLocation() {
            return location;
        }
        public void setWords(String words) {
            this.words = words;
        }
        public String getWords() {
            return words;
        }
    }
    public static class Nation{
        private Location location;
        private String words;
        public void setLocation(Location location) {
            this.location = location;
        }
        public Location getLocation() {
            return location;
        }
        public void setWords(String words) {
            this.words = words;
        }
        public String getWords() {
            return words;
        }
    }
    public static class IssueDate{
        private Location location;
        private String words;
        public void setLocation(Location location) {
            this.location = location;
        }
        public Location getLocation() {
            return location;
        }
        public void setWords(String words) {
            this.words = words;
        }
        public String getWords() {
            return words;
        }
    }
    public static class Authority{
        private Location location;
        private String words;
        public void setLocation(Location location) {
            this.location = location;
        }
        public Location getLocation() {
            return location;
        }
        public void setWords(String words) {
            this.words = words;
        }
        public String getWords() {
            return words;
        }
    }
    public static class ExpireDate{
        private Location location;
        private String words;
        public void setLocation(Location location) {
            this.location = location;
        }
        public Location getLocation() {
            return location;
        }
        public void setWords(String words) {
            this.words = words;
        }
        public String getWords() {
            return words;
        }
    }
    public static class Location{
        private Integer width;
        private Integer height;
        private Integer left;
        private Integer top;

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public Integer getLeft() {
            return left;
        }

        public void setLeft(Integer left) {
            this.left = left;
        }

        public Integer getTop() {
            return top;
        }

        public void setTop(Integer top) {
            this.top = top;
        }
    }
}
