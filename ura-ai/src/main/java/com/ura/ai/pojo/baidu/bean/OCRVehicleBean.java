/**
 * @author eamiear
 * @date 2018/12/4 15:42
 */

package com.ura.ai.pojo.baidu.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class OCRVehicleBean {
    private Integer words_result_num;
    private List<WordsResult> words_result;

    public Integer getWords_result_num() {
        return words_result_num;
    }

    public void setWords_result_num(Integer words_result_num) {
        this.words_result_num = words_result_num;
    }

    public List<WordsResult> getWords_result() {
        return words_result;
    }

    public void setWords_result(List<WordsResult> words_result) {
        this.words_result = words_result;
    }

    public static class WordsResult{
        @JSONField(name = "品牌型号")
        private BrandModel brandModel;
        @JSONField(name = "发证日期")
        private IssueDate issueDate;
        @JSONField(name = "使用性质")
        private UsageNature usageNature;
        @JSONField(name = "发动机号码")
        private EngineNumber engineNumber;
        @JSONField(name = "号牌号码")
        private PlateNumber plateNumber;
        @JSONField(name = "所有人")
        private Owner owner;
        @JSONField(name = "住址")
        private Address address;
        @JSONField(name = "注册日期")
        private RegistryDate registryDate;
        @JSONField(name = "车辆识别代号")
        private VehicleIdentificationCode vehicleIdentificationCode;
        @JSONField(name = "车辆类型")
        private VehicleType vehicleType;

        public BrandModel getBrandModel() {
            return brandModel;
        }

        public void setBrandModel(BrandModel brandModel) {
            this.brandModel = brandModel;
        }

        public IssueDate getIssueDate() {
            return issueDate;
        }

        public void setIssueDate(IssueDate issueDate) {
            this.issueDate = issueDate;
        }

        public UsageNature getUsageNature() {
            return usageNature;
        }

        public void setUsageNature(UsageNature usageNature) {
            this.usageNature = usageNature;
        }

        public EngineNumber getEngineNumber() {
            return engineNumber;
        }

        public void setEngineNumber(EngineNumber engineNumber) {
            this.engineNumber = engineNumber;
        }

        public PlateNumber getPlateNumber() {
            return plateNumber;
        }

        public void setPlateNumber(PlateNumber plateNumber) {
            this.plateNumber = plateNumber;
        }

        public Owner getOwner() {
            return owner;
        }

        public void setOwner(Owner owner) {
            this.owner = owner;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public RegistryDate getRegistryDate() {
            return registryDate;
        }

        public void setRegistryDate(RegistryDate registryDate) {
            this.registryDate = registryDate;
        }

        public VehicleIdentificationCode getVehicleIdentificationCode() {
            return vehicleIdentificationCode;
        }

        public void setVehicleIdentificationCode(VehicleIdentificationCode vehicleIdentificationCode) {
            this.vehicleIdentificationCode = vehicleIdentificationCode;
        }

        public VehicleType getVehicleType() {
            return vehicleType;
        }

        public void setVehicleType(VehicleType vehicleType) {
            this.vehicleType = vehicleType;
        }
    }
    public static class BrandModel{
        private String words;

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }
    }
    public static class IssueDate{
        private String words;

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }
    }
    public static class UsageNature{
        private String words;

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }
    }
    public static class EngineNumber{
        private String words;

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }
    }
    public static class PlateNumber{
        private String words;

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }
    }
    public static class Owner{
        private String words;
        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }
    }
    public static class Address{
        private String words;

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }
    }
    public static class RegistryDate{
        private String words;

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }
    }
    public static class VehicleIdentificationCode{
        private String words;

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }
    }
    public static class VehicleType{
        private String words;

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }
    }
}
