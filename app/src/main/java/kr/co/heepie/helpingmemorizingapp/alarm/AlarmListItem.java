package kr.co.heepie.helpingmemorizingapp.alarm;

// list item layout
public class AlarmListItem {
	private int year, month, day, hour, minute;
	private int reqCode;

	public AlarmListItem(int year, int month, int day, int hour, int minute, int reqCode) {
		this.year = year;
		this.minute = minute;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this. reqCode = reqCode;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public int getReqCode() {
		return reqCode;
	}
}

