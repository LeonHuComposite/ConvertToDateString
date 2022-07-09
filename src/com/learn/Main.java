package com.learn;

public class Main {

    public static void main(String[] args) {
        System.out.println(convertToDateString("1990-05-31"));
    }

    public static String convertToDateString(String str) {
        if (!isValidDate(str)) return "not a proper date";
        int year = findYear(str);
        int month = (convertCharToInt(str.charAt(5)) * 10) + convertCharToInt(str.charAt(6));
        int day = (convertCharToInt(str.charAt(8)) * 10) + convertCharToInt(str.charAt(9));
        String date = "";
        date = date + convertToMonth(month);
        date = date + day + ", " + year;
        return date;
    }

    public static boolean isValidDate(String str) {
        if (str.length() != 10) return false;
        if (str.charAt(4) != '-' || str.charAt(7) != '-') return false;
        for (int i = 0; i < str.length(); i++) {
            if (i != 4 && i != 7) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {

                } else {
                    return false;
                }
            }
        }

        int year = findYear(str);
        int month = (convertCharToInt(str.charAt(5)) * 10) + convertCharToInt(str.charAt(6));
        int day = (convertCharToInt(str.charAt(8)) * 10) + convertCharToInt(str.charAt(9));
        if (month < 0 || month > 12) return false;
        if (day < 0) return false;
        if (day > maxDayOfMonth(year, month)) return false;
        if (day <= maxDayOfMonth(year, month)) {
            return true;
        } else {
            return false;
        }
    }

    public static int convertCharToInt(char a) {
        if (a < '0' || a > '9') return -1;
        int b = (byte) a;
        b = b - 48;
        return b;
    }

    public static String convertToMonth(int monthNumber) {
        switch (monthNumber) {
            case 1:
                return "January ";
            case 2:
                return "February ";
            case 3:
                return "March ";
            case 4:
                return "April ";
            case 5:
                return "May ";
            case 6:
                return "June ";
            case 7:
                return "July ";
            case 8:
                return "August ";
            case 9:
                return "September ";
            case 10:
                return "October ";
            case 11:
                return "November ";
            case 12:
                return "December ";
            default:
                return "";
        }
    }

    public static int maxDayOfMonth(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                if (year % 4 != 0) {
                    return 28;
                } else {
                    return 29;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return -1;
        }
    }
    public static int findYear (String str) {
        int year = 0;
        int decrease = 1000;
        for (int i = 0; i < 4; i++) {
            year = year + (convertCharToInt(str.charAt(i)) * decrease);
            decrease = decrease / 10;
        }
        return year;
    }
}
