package com.kq.util;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kq
 * @date 2021-04-14 13:39
 * @since 2020-0630
 */
public class HexAdecimalUtil {

    private static Map<String, String> hexMap = new HashMap();


    public static void initMap() {

        try (
                InputStream in = HexAdecimalUtil.class.getResourceAsStream("/mydata.txt");
        ) {
//            System.out.println("in=" + in);
//            IOUtils.readLines();
            List<String> list = IOUtils.readLines(in, "utf-8");

            for (String str : list) {
                if (str != null) {
                    String newLine = str.substring(16);
                    if (newLine != null) {
                        newLine = newLine.trim();

                        String[] strs = newLine.split(" ");
                        int len = strs.length-1;
                        hexMap.put(strs[0].trim(), strs[len].trim());
                    }
//                    System.out.println("newLine="+newLine);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static String getValue(String hex) {
        if(hexMap.size()==0)initMap();

//        System.out.println("hexMap="+hexMap);

        return hexMap.get(hex.toUpperCase());

    }


    public static String hexStringToString(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        s = s.replace(" ", "");
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "UTF-8");
            new String();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }


    public static void main(String[] args) {
//        System.out.println(getStringList());
//        System.out.println(getValue("43"));
//        System.out.println(getValue("5A"));

//        String str = "4c 6a 61 76 61 2f 6c 61 6e 67 2f 53 74 72 69 6e 67 3b";
        String str = "6A 61 76 61 2F 6C 61 6E 67 2F 4F 62 6A 65 63 74";
//        String str = "00 01 00 01 00 00 00 05 2A B7 00 01 B1 00 00  00 02 00 0B 00 00 00 06 00 01 00 00 00 08 00 0C 00 00 00 0C 00 01 00 00 00 05 00 0D 00 0E 00 00";

        String[] as = str.split(" ");

        for(String s : as) {
            System.out.print(hexStringToString(s));
//            System.out.print(getValue(s)+" ");
        }

//        System.out.println();
//        System.out.println(hexMap);


    }


}
