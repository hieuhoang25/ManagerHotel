package QuanLiKhachSan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class Bill {
	private String idBill;
	private Date dateBill;
	private String nameCustomer;
	private String idRoom;
	private double price;
	final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Scanner sc = new Scanner(System.in);
	public Bill(String idBill, String dateBill, String nameCustomer, String idRoom, String price) {
		super();
		this.idBill = idBill;
		this.setDateBill(dateBill);
		this.nameCustomer = nameCustomer;
		this.idRoom = idRoom;
		this.setPrice(price);
	}
	public Bill() {
		super();
	}
	public String getIdBill() {
		return idBill;
	}
	public void setIdBill(String idBill) {
		this.idBill = idBill;
	}
	public Date getDateBill() {
		return dateBill;
	}
	public void setDateBill(String dateBill) {
		try {
			this.dateBill = sdf.parse(dateBill);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getNameCustomer() {
		return nameCustomer;
	}
	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	public String getIdRoom() {
		return idRoom;
	}
	public void setIdRoom(String idRoom) {
		this.idRoom = idRoom;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = Double.parseDouble(price);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idBill == null) ? 0 : idBill.hashCode());
		result = prime * result + ((idRoom == null) ? 0 : idRoom.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bill other = (Bill) obj;
		if (idBill == null) {
			if (other.idBill != null)
				return false;
		} else if (!idBill.equals(other.idBill))
			return false;
		if (idRoom == null) {
			if (other.idRoom != null)
				return false;
		} else if (!idRoom.equals(other.idRoom))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Mã HD : " + idBill + " - Ngày HD : " + sdf.format(dateBill) + " - Tên KH : " + nameCustomer + " - Mã Phòng : "
				+ idRoom + " - Đơn giá : " + price ;
	}
	public void input() {
		System.out.println("Nhập mã hóa đơn:");
		this.setIdBill(sc.nextLine());
		System.out.println("Nhập ngày HD(dd/MM/yyyy):");
		this.setDateBill(sc.nextLine());
		System.out.println("Nhập tên khách hàng:");
		this.setNameCustomer(sc.nextLine());
		System.out.println("Nhập mã phòng:");
		this.setIdRoom(sc.nextLine());
		System.out.println("Nhập đơn giá:");
		this.setPrice(sc.nextLine());
	}
	protected abstract double totalPrice();
}
