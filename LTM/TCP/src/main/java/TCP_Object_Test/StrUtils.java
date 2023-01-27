/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Object_Test;

import TCP_Object.*;

/**
 *
 * @author Admins
 */
public class StrUtils {

    public static String toNameFirstFormat(String str) {
        String _strName1 = toCapitalize(str);
        String str1 = _strName1.substring(0, _strName1.lastIndexOf(" "));
        String str2 = _strName1.substring(_strName1.lastIndexOf(" ") + 1, _strName1.length());
        return str2.toUpperCase() + ", " + str1;
    }

//    public static String toShortNameFormat(String _strName) {
//        _strName = _strName.toLowerCase();
//        String[] temp = _strName.split(" ");
//        String strReturn = "";
//        for (int i = 0; i < temp.length - 1; i++) {
//            strReturn += temp[i].charAt(0);
//        }
//        strReturn += temp[temp.length - 1];
//
//        return strReturn;
//    }

    public static String toVNDateFormat(String _strDate) {

        String[] temp = _strDate.split("-");

        return temp[1] + "/" + temp[0] + "/" + temp[2];
    }

    public static String toCapitalize(String str) {
        String[] words = str.toLowerCase().split("\\s");
        String strCapitalize = "";
        for (String s : words) {
            s = capitalizeOneString(s);
            strCapitalize += s + " ";
        }
        return strCapitalize.trim();

    }

    public static String capitalizeOneString(String s) {
        if (s.length() == 0) {
            return s;
        }
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
}