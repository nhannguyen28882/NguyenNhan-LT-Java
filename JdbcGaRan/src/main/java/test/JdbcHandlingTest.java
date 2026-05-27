package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.Person;
import data.JdbcPerson;

public class JdbcHandlingTest {
    public static void main(String[] args) {
        JdbcPerson jdbcPerson = new JdbcPerson();
        Scanner scanner = new Scanner(System.in);
        List<Person> cart = new ArrayList<>();

        System.out.println("--- PHẦN MỀM E-ORDER TRÊN PDA ---");

        while (true) {
            System.out.println("\n1. Xem thực đơn");
            System.out.println("2. Chọn món ăn (Order)");
            System.out.println("3. Gửi Order xuống nhà bếp (Send Order)");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("\n--- DANH SÁCH MÓN ĂN ---");
                jdbcPerson.findAll().forEach(System.out::println);
            } 
            else if (choice == 2) {
                System.out.print("Nhập ID món ăn khách gọi: ");
                int id = scanner.nextInt();
                // Tìm món ăn từ DB và thêm vào giỏ hàng tạm thời trên PDA
                Person p = jdbcPerson.findAll().stream().filter(i -> i.getId() == id).findFirst().orElse(null);
                if (p != null) {
                    cart.add(p);
                    System.out.println("Đã thêm " + p.getName() + " vào danh sách order.");
                } else {
                    System.out.println("ID không tồn tại!");
                }
            } 
            else if (choice == 3) {
                if (cart.isEmpty()) {
                    System.out.println("Chưa chọn món nào!");
                } else {
                    double total = cart.stream().mapToDouble(Person::getPrice).sum();
                    System.out.println("Tổng tiền: " + total + " VNĐ");
                    jdbcPerson.saveOrder(total); // Gửi dữ liệu qua MySQL
                    cart.clear(); // Reset giỏ hàng sau khi gửi xong
                }
            } 
            else if (choice == 4) {
                break;
            }
        }
        scanner.close();
        System.out.println("Đã tắt ứng dụng PDA.");
    }
}