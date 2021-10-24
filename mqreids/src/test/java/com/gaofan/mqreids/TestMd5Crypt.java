package com.gaofan.mqreids;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.junit.Test;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Formatter;
import java.util.Locale;

/**
 * @author gaofan
 * @create 2021-07-22 22:24
 */
public class TestMd5Crypt {

    @Test
    public void testaa() {
        String format = String.format("%04d", 23);
        System.out.println(format);


    }

    @Test
    public void testFormat2() {
        DecimalFormat df = new DecimalFormat("###,##0.00");
        String format = df.format(34119320.534);
        System.out.println(format);
        format = df.format(.539);
        System.out.println(format);

        DecimalFormat df2 = new DecimalFormat("00000000");
        String format1 = df2.format(123);
        System.out.println(format1);

        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        String format2 = nf.format(234.789);
        System.out.println(format2);

        NumberFormat currencyInstance = DecimalFormat.getCurrencyInstance();
        String format3 = currencyInstance.format(123.893);
        System.out.println(format3);

    }

    @Test
    public void testFormat() {
        Double d1 = 18.546;
        String format = String.format("%.2f", d1);
        System.out.println(format);
        double v = Double.parseDouble(format);
        System.out.println(v);

        String afeaf = String.format("--%3s--%9s--", "hello","world");
        System.out.println(afeaf);

        String format1 = String.format("Amount gained or lost since last statement: $%(,.2f", 239233.987);
        System.out.println(format1);
        String format2 = String.format("---%4$2s--%3$2s--%2$3s--%1$4s---", "a", "b", "c", "d");
        System.out.println(format2);

        String format3 = String.format("---%4s---%3s---%2s---%1s---", "a", "b", "c", "d");
        System.out.println(format3);

        Formatter formatter = new Formatter(new StringBuilder(), Locale.US);
        Formatter format4 = formatter.format("Amount gained or lost since last statement: $ %(,.2f",
                6217.576);
        System.out.println(format4);
    }

    @Test
    public void testmd5() {
        String s = DigestUtils.md5Hex("123456");
        System.out.println(s);
        String str = Md5Crypt.md5Crypt("12345".getBytes(), "$1$qqqqqqqq");
        System.out.println(str);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //String encode = bCryptPasswordEncoder.encode("123456");
        //$2a$10$BRdtbMVJBhpeLYyeWZNX8eWjsfNRczX4m1dL6MrckRdVvW3osLCee
        //System.out.println(encode);
        boolean flag = bCryptPasswordEncoder.matches("123456","$2a$10$BRdtbMVJBhpeLYyeWZNX8eWjsfNRczX4m1dL6MrckRdVvW3osLCee");
        System.out.println(flag);

    }
}
