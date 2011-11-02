package api.announcements;

import java.util.Date;

public abstract class AbstractDateObject extends Date {
	Date d;

	public Date getDate_() {
		return d;
	}

	public void setDate(Date d) {
		this.d = d;
	}

	@Override
	public int compareTo(Date anotherDate) {
		// TODO Auto-generated method stub
		return super.compareTo(anotherDate);
	}

}
