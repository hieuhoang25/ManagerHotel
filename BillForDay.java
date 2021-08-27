package QuanLiKhachSan;

import java.util.Date;

public class BillForDay extends Bill{
	private int numberDay;
	
	public int getNumberDay() {
		return numberDay;
	}

	public void setNumberDay(String numberDay) {
		this.numberDay = Integer.parseInt(numberDay);
	}

	public BillForDay() {
		super();
	}

	public BillForDay(String idBill, String dateBill, String nameCustomer, String idRoom, String price,String numberDay) {
		super(idBill, dateBill, nameCustomer, idRoom, price);
		this.setNumberDay(numberDay);
	}
	
	@Override
	public String toString() {
		return "Hóa đơn theo ngày : "+super.toString() + " - Số ngày : "+this.numberDay + " - Thành tiền : "+Math.floor(totalPrice())+ "VNĐ";
	}
	public void input() {
		super.input();
		System.out.println("Nhập số ngày:");
		this.setNumberDay(sc.nextLine());
	}
	@Override
	public double totalPrice() {
		// TODO Auto-generated method stub
		if(this.numberDay>7) {
			return 7*super.getPrice()+(this.numberDay-7)*super.getPrice()*0.8;
		}
		return this.numberDay*super.getPrice();
	}
	
}
