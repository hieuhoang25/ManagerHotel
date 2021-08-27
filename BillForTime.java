package QuanLiKhachSan;

import java.util.Date;

public class BillForTime extends Bill{
	private int numberTime;
	
	public int getNumberTime() {
		return numberTime;
	}

	public void setNumberTime(String numberTime) {
		this.numberTime = Integer.parseInt(numberTime);
	}

	public BillForTime() {
		super();
	}

	public BillForTime(String idBill, String dateBill, String nameCustomer, String idRoom, String price, String numberTime) {
		super(idBill, dateBill, nameCustomer, idRoom, price);
		this.setNumberTime(numberTime);
	}
	
	@Override
	public String toString() {
		return "Hóa đơn theo giờ : " +super.toString() + " - Số giờ : "+ this.numberTime + " - Thành tiền : "+Math.floor(totalPrice())+ "VNĐ";
	}	
	public void input() {
		super.input();;
		System.out.println("Nhập số giờ :");
		this.setNumberTime(sc.nextLine());
	}

	@Override
	public double totalPrice() {
		// TODO Auto-generated method stub
	
		if(this.numberTime<30&& this.numberTime>24) {
			return 24*super.getPrice();
		}
		
		return this.numberTime*super.getPrice();
	}

}
