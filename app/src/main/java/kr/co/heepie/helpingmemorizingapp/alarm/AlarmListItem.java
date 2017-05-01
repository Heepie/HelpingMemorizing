package kr.co.heepie.helpingmemorizingapp.alarm;

// list item layout
public class AlarmListItem {
	public int hh;
	public int mm;
	public int reqCode;

	public AlarmListItem(int hh, int mm, int reqCode) {
		this.hh = hh;
		this.mm = mm;
		this. reqCode = reqCode;
	}
	
	@Override
	public String toString() {
		return hh+":"+mm +" and requestCode : "+reqCode;
	}


}

