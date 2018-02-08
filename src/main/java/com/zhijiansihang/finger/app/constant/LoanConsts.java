package com.zhijiansihang.finger.app.constant;


import com.zhijiansihang.finger.app.sharing.SharingProperties;
import com.zhijiansihang.finger.app.sharing.spring.ApplicationContextHelper;

/**
 * @author paul
 * @description
 * @date 2018/1/3
 */
public class LoanConsts {

    public static enum LoanTypeEnum{

        LOAN_TYPE_PUBLIC((byte)1,"公募"),
        LOAN_TYPE_PRIVATE((byte)2,"私募");


        private Byte tpye;

        private String message;

        public Byte getType() {
            return tpye;
        }

        public String getMessage() {
            return message;
        }

        LoanTypeEnum(Byte tpye, String message) {
            this.tpye = tpye;
            this.message = message;
        }
    }

}
