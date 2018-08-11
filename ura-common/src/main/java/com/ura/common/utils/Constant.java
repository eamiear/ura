/**
 * @author eamiear
 * @date 2018/8/8 10:57
 */

package com.ura.common.utils;

public class Constant {
    public static final int SUPER_ADMIN = 1;

    public static final String SQL_FILTER = "sql_filter";

    public static final int SHIRO_HASH_ITERATION = 1024;
    public static final String SHIRO_HASH_ALGORITHM_NAME = "MD5";

    public static final int JWT_EXPIRATION_TIME = 60 * 60 * 1000;
    public static final String JWT_SECRET = "ura_token_secret";

    public static final int CUSTOME_TOKEN_EXPIRATION_TIME = 1000 * 60 * 60 * 12;


    public enum MenuType {
        CATALOG(0),

        MNEU(1),

        BUTTON(2);

        private int value;

        MenuType(int value) {
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }
}
