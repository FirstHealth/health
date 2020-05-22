package com.wd.health.healthys.MVP.util;

import java.util.regex.Pattern;

/**
 * author : Eaves
 * desc   : 功能描述
 */
public class RegularUtils {

    //手机号
    /**
     * 176,177,178
     * 180,181,182,183,184,185,186,187,188,189
     * 145,147
     * 130,131,132,133,134,135,136,137,138,139
     * 150,151,152,153,155,156,157,158,159
     */
    private static final String PHONE_REG = "^((13[0-9])|(15[^4])|(18[0-9])|(17[0-8])|(147,145))\\d{8}$";



    /**
     *
     * 邮箱账号
     */
    private static final String EMAIL_REG = "^[a-z0-9A-Z]+[- |a-z0-9A-Z._]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$";

    //校验手机号
    public static boolean checkPhone(String phone){

        return Pattern.matches(PHONE_REG,phone);
    }



    //校验邮箱
    public static boolean checkEmail(String email){

        return Pattern.matches(EMAIL_REG,email);
    }


}
