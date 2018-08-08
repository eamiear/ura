/**
 * @author eamiear
 * @date 2018/8/8 10:57
 */

package com.ura.common.utils;

public class Constant {
    public static final int SUPER_ADMIN = 1;


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
