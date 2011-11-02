package api.announcements;

import java.util.Comparator;
import java.util.Date;

public class MyDateComparator implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		Date d1 = ((AbstractDateObject) o1).getDate_();
		Date d2 = ((AbstractDateObject) o2).getDate_();
		if (d1.after(d2))
			return 1;
		else if (d1.before(d2))
			return -1;
		else
			return 0;
	}
}
