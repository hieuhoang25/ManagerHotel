package QuanLiKhachSan;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Manager implements Manageable {
	private ArrayList<Bill> listBill;
	public Manager() {
		super();
		this.listBill = new ArrayList<>();
	}
	private boolean check(Bill b) {
		for (Bill bill : listBill) {
			if(bill.equals(b)==true) {
				return false;
			}
		}
		return true;
	}
	@Override
	public void addBill(int x) {
		// TODO Auto-generated method stub
		if(x==1) {
			Bill bill = new BillForTime();
			bill.input();
			if(check(bill)==true) {
				listBill.add(bill);
				System.out.println("Thêm vào thành công!");
			}
			else {
				System.out.println("Vui lòng check lại thông tin!");
			}
		}
		else {
			Bill bill = new BillForDay();
			bill.input();
			if(check(bill)==true) {
				listBill.add(bill);
				System.out.println("Thêm vào thành công!");
			}
			else {
				System.out.println("Vui lòng check lại thông tin!");
			}
		}
	}

	@Override
	public void showListBill() {
		// TODO Auto-generated method stub
		for (Bill bill : listBill) {
			System.out.println(bill.toString());
		}
	}

	@Override
	public void sumForType() {
		// TODO Auto-generated method stub
		int temp1=0,temp2=0;
		for (Bill bill : listBill) {
			if(bill instanceof BillForTime) {
				temp1++;
			}
			if(bill instanceof BillForDay) {
				temp2++;
			}
		}
		System.out.println("Tống số lượng khách hàng thuê phòng theo giờ : "+temp1);
		System.out.println("Tống số lượng khách hàng thuê phòng theo ngày : "+temp2);
	}

	@Override
	public void avgDate() {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();
		double sum=0;
		int temp=0;
		for (Bill bill : listBill) {
			c.setTime(bill.getDateBill());
			if((c.get(Calendar.MONTH)+1)==9 && c.get(Calendar.YEAR)==2021) {
				sum+=bill.getPrice();
				temp++;
			}
		}
		if(Double.isNaN(sum/temp)==true) {
			System.out.println("Trung bình thành tiền của hóa đơn thuê phòng trong tháng 9/2021 : "+0 + "Đồng");
		}
		else {
			System.out.println("Trung bình thành tiền của hóa đơn thuê phòng trong tháng 9/2021 : "+sum/temp + "Đồng");
		}
	}

	@Override
	public void sortForNameCustomer() {
		// TODO Auto-generated method stub
		Collections.sort(listBill, new SortName());
		showListBill();
	}

	@Override
	public void saveDownFile() {
		// TODO Auto-generated method stub
		boolean temp = FileFactory.saveFile(listBill, "D:\\Eclise Java\\BaiTapJavaNC\\src\\QuanLiKhachSan\\ListBill.txt");
		if(temp=true) {
			System.out.println("Lưu file thành công!");
		}
		else {
			System.out.println("Lưu file thất bại");
		}
	}
	@Override
	public void menu() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int choose=0;
		do {
			System.out.println("--------->  Quản lí khách sạn  <----------");
			System.out.println("1. Nhập hóa đơn thuê phòng theo giờ");
			System.out.println("2. Nhập hóa đơn thuê phòng theo giờ");
			System.out.println("3. Hiện thị danh sách hóa đơn thêu phòng");
			System.out.println("4. Tính tổng số lượng cho từng loại thuê phòng");
			System.out.println("5. Tính trung bình thành tiền của hóa đơn thuê phòng trong tháng 9/202");
			System.out.println("6. Sắp xêp danh sách hóa đơn theo mã hóa đơn khách hàng");
			System.out.println("7. Lưu danh sách hóa đơn xuông file");
			System.out.println("0. Thoát");
			System.out.println("Chọn chức năng:");
			choose = sc.nextInt();
			switch (choose) {
			case 1: {
				addBill(1);
				break;
			}
			case 2:{
				addBill(2);
				break;
			}
			case 3:{
				showListBill();
				break;
			}
			case 4:{
				sumForType();
				break;
				
			}
			case 5:{
				avgDate();
				break;
			}
			case 6:{
				sortForNameCustomer();
				break;
			}
			case 7:{
				saveDownFile();
				break;
			}
			

			}
			
		} while (choose!=0);
	}
	
	
	
	
}




class SortName implements Comparator<Bill>{

	@Override
	public int compare(Bill o1, Bill o2) {
		// TODO Auto-generated method stub
		return o1.getIdBill().compareTo(o2.getIdBill());
	}
	
}
