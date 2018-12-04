/**
 * @author eamiear
 * @date 2018/12/4 15:17
 */

package com.ura.ai.pojo.baidu.resp;

public class OCRBankCardResp {
    private String bankCardNumber;
    private String bankName;
    private String bankCardType;

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCardType() {
        return bankCardType;
    }

    public void setBankCardType(String bankCardType) {
        this.bankCardType = bankCardType;
    }
}
