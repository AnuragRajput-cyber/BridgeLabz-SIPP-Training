package com.gla;

public class HotelBooking {
	private String guestName;
	private String roomType;
	private int nights;
	
	public HotelBooking() {
		guestName="Unknnown";
		roomType="unknown";
		nights=0;
	}
	public HotelBooking(String guestName,String roomType,int nights) {
		this.guestName=guestName;
		this.roomType=roomType;
		this.nights=nights;
	}
	public String getName() {
		return this.guestName;
	}
	public void setName(String Name) {
		guestName=Name;
	}
	public String getType() {
		return this.roomType;
	}
	public void setType(String type) {
		roomType=type;
	}
	public int getNight() {
		return this.nights;
	}
	public void setNights(int nights) {
		this.nights=nights;
	}
	public HotelBooking(HotelBooking other) {
		this.guestName=other.guestName;
		this.roomType=other.roomType;
		this.nights=other.nights;
	}
	@Override
    public String toString() {
        return "Person{Guest Name='" + guestName + "', room Type='" + roomType + "', NO of Nights='"+ nights+ "'}";
    }
	
	public static void main(String[] args) {
		HotelBooking hb=new HotelBooking("raghav","Suit",5);
		HotelBooking copy=new HotelBooking(hb);
		System.out.println(hb);
		System.out.println(copy);
		
				
	}
}
