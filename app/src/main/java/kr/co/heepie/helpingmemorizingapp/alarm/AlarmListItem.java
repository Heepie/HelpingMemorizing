package kr.co.heepie.helpingmemorizingapp.alarm;

import android.os.Parcel;
import android.os.Parcelable;

// list item layout
public class AlarmListItem implements Parcelable {
	private int year, month, day, hour, minute;
	private int reqCode;

	public AlarmListItem() {}

	protected AlarmListItem(Parcel in) {
		year = in.readInt();
		month = in.readInt();
		day = in.readInt();
		hour = in.readInt();
		minute = in.readInt();
		reqCode = in.readInt();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(year);
		dest.writeInt(month);
		dest.writeInt(day);
		dest.writeInt(hour);
		dest.writeInt(minute);
		dest.writeInt(reqCode);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<AlarmListItem> CREATOR = new Creator<AlarmListItem>() {
		@Override
		public AlarmListItem createFromParcel(Parcel in) {
			return new AlarmListItem(in);
		}

		@Override
		public AlarmListItem[] newArray(int size) {
			return new AlarmListItem[size];
		}
	};

	private void setYear(int year) {
		this.year = year;
	}

	private void setMonth(int month) {
		this.month = month;
	}

	private void setDay(int day) {
		this.day = day;
	}

	private void setHour(int hour) {
		this.hour = hour;
	}

	private void setMinute(int minute) {
		this.minute = minute;
	}

	private void setReqCode(int reqCode) {
		this.reqCode = reqCode;
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

	@Override
	public String toString() {
		return year + " " + month + " " + day + " " + hour + " " + minute;
	}

	// Builder Pattern
	public static class ItemBuilder {
		private AlarmListItem item;

		public ItemBuilder() {
			item = new AlarmListItem();
		}

		public static ItemBuilder startBuild() {
			return new ItemBuilder();
		}

		public ItemBuilder setYear(int year) {
			item.setYear(year);
			return this;
		}

		public ItemBuilder setMonth(int month) {
			item.setMonth(month);
			return this;
		}

		public ItemBuilder setDay(int day) {
			item.setDay(day);
			return this;
		}

		public ItemBuilder setHour(int hour) {
			item.setHour(hour);
			return this;
		}

		public ItemBuilder setMinute(int minute) {
			item.setMinute(minute);
			return this;
		}

		public AlarmListItem finishBuild() {
			return item;
		}
	}
}

