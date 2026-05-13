package kgur.com;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemSoAm {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Nhập chuỗi từ bàn phím
        System.out.print("Nhập chuỗi: ");
        String str = sc.nextLine();

        // Gọi hàm xử lý
        negativeNumberInStrings(str);

        sc.close();
    }

    /**
     * Hàm tìm, xuất và đếm các số nguyên âm trong chuỗi
     * @param str Chuỗi đầu vào
     */
    public static void negativeNumberInStrings(String str) {

        // Regex tìm số nguyên âm
        Pattern pattern = Pattern.compile("-\\d+");
        Matcher matcher = pattern.matcher(str);

        int dem = 0;

        System.out.println("Các số nguyên âm tìm thấy:");

        // Tìm các số âm trong chuỗi
        while (matcher.find()) {

            System.out.println(matcher.group());

            dem++;
        }

        // Kiểm tra có số âm hay không
        if (dem == 0) {
            System.out.println("Không tìm thấy số nguyên âm nào.");
        } else {
            System.out.println("Có " + dem + " số nguyên âm.");
        }
    }
}