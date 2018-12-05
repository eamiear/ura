/**
 * @author eamiear
 * @date 2018/12/4 15:23
 */

package com.ura.ai.pojo.baidu.bean;

public class OCRBankCardBean {
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result{
        private String bank_card_number;
        private String bank_name;
        private Integer bank_card_type;

        public String getBank_card_number() {
            return bank_card_number;
        }

        public void setBank_card_number(String bank_card_number) {
            this.bank_card_number = bank_card_number;
        }

        public String getBank_name() {
            return bank_name;
        }

        public void setBank_name(String bank_name) {
            this.bank_name = bank_name;
        }

        public Integer getBank_card_type() {
            return bank_card_type;
        }

        public void setBank_card_type(Integer bank_card_type) {
            this.bank_card_type = bank_card_type;
        }
    }
}
