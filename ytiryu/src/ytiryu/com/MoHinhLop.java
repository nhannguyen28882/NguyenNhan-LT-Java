package ytiryu.com;

import java.util.ArrayList;

//=======================
//LỚP TRỪU TƯỢNG STAFFMEMBER
//=======================
abstract class StaffMember {
 protected String name;
 protected String address;
 protected String phone;

 // Constructor
 public StaffMember(String name, String address, String phone) {
     this.name = name;
     this.address = address;
     this.phone = phone;
 }

 // Getter
 public String getName() {
     return name;
 }

 public String getAddress() {
     return address;
 }

 public String getPhone() {
     return phone;
 }

 // Setter
 public void setName(String name) {
     this.name = name;
 }

 public void setAddress(String address) {
     this.address = address;
 }

 public void setPhone(String phone) {
     this.phone = phone;
 }

 @Override
 public String toString() {
     return "Tên: " + name +
            "\nĐịa chỉ: " + address +
            "\nSĐT: " + phone;
 }

 // Hàm trừu tượng
 public abstract double pay();
}

//=======================
//LỚP VOLUNTEER
//=======================
class Volunteer extends StaffMember {

 public Volunteer(String name, String address, String phone) {
     super(name, address, phone);
 }

 @Override
 public double pay() {
     return 0.0;
 }
}

//=======================
//LỚP EMPLOYEE
//=======================
class Employee extends StaffMember {

 protected String socialSecurityNumber;
 protected double payRate;

 public Employee(String name, String address, String phone,
                 String ssn, double rate) {

     super(name, address, phone);

     this.socialSecurityNumber = ssn;
     this.payRate = rate;
 }

 // Getter
 public String getSocialSecurityNumber() {
     return socialSecurityNumber;
 }

 public double getPayRate() {
     return payRate;
 }

 // Setter
 public void setSocialSecurityNumber(String socialSecurityNumber) {
     this.socialSecurityNumber = socialSecurityNumber;
 }

 public void setPayRate(double payRate) {
     this.payRate = payRate;
 }

 @Override
 public String toString() {
     return super.toString()
             + "\nSSN: " + socialSecurityNumber
             + "\nMức lương: " + payRate;
 }

 @Override
 public double pay() {
     return payRate;
 }
}

//=======================
//LỚP EXECUTIVE
//=======================
class Executive extends Employee {

 private double bonus;

 public Executive(String name, String address, String phone,
                  String ssn, double rate) {

     super(name, address, phone, ssn, rate);

     bonus = 0;
 }

 public void awardBonus(double execBonus) {
     bonus += execBonus;
 }

 @Override
 public double pay() {

     double payment = super.pay() + bonus;

     // reset bonus
bonus = 0;

     return payment;
 }

 @Override
 public String toString() {
     return super.toString()
             + "\nBonus: " + bonus;
 }
}

//=======================
//LỚP HOURLY
//=======================
class Hourly extends Employee {

 private int hoursWorked;

 public Hourly(String name, String address, String phone,
               String ssn, double rate) {

     super(name, address, phone, ssn, rate);

     hoursWorked = 0;
 }

 public void addHours(int moreHours) {
     hoursWorked += moreHours;
 }

 public int getHoursWorked() {
     return hoursWorked;
 }

 @Override
 public double pay() {

     double payment = payRate * hoursWorked;

     // reset giờ làm
     hoursWorked = 0;

     return payment;
 }

 @Override
 public String toString() {
     return super.toString()
             + "\nSố giờ làm: " + hoursWorked;
 }
}

//=======================
//LỚP STAFF
//=======================
class Staff {

 private ArrayList<StaffMember> staffList;

 public Staff() {
     staffList = new ArrayList<>();
 }

 // Thêm thành viên
 public void addMember(StaffMember member) {
     staffList.add(member);
 }

 // Trả lương
 public void payday() {

     System.out.println("===== DANH SÁCH THANH TOÁN =====\n");

     for (StaffMember member : staffList) {

         System.out.println(member);

         double amount = member.pay();

         if (amount == 0.0) {
             System.out.println("Cảm ơn vì sự đóng góp!");
         } else {
             System.out.printf("Lương thanh toán: %.2f\n", amount);
         }

         System.out.println("----------------------------------");
     }
 }
}

//=======================
//LỚP MAIN
//=======================
public class MoHinhLop {

 public static void main(String[] args) {

     Staff st = new Staff();

     // ===== Executive =====
     Executive boss = new Executive(
             "Nguyễn Văn A",
             "Hà Nội",
             "0912345678",
             "SSN-001",
             5000
     );

     boss.awardBonus(1000);

     // ===== Hourly =====
     Hourly worker = new Hourly(
             "Trần Thị B",
             "TP.HCM",
             "0988888888",
             "SSN-002",
             20
     );

     worker.addHours(40);

     // ===== Volunteer =====
     Volunteer helper = new Volunteer(
             "Lê Văn C",
             "Đà Nẵng",
             "0905111222"
     );

     // Thêm vào danh sách
     st.addMember(boss);
     st.addMember(worker);
     st.addMember(helper);

     // Thanh toán
     st.payday();
 }
}
