package aiss.model.blablacar.search;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TripRepository {

	private List<Trip> trips;

	private List<Trip> getTrips(DeparturePlace dep, ArrivalPlace ar, String date) {

		List<Trip> res = new ArrayList<Trip>();
		for (int i = 0; i < trips.size(); i++) {
			if (trips.get(i).getDeparturePlace().equals(dep) && trips.get(i).getArrivalPlace().equals(ar)
					&& trips.get(i).getDepartureDate().equals(date)) {
				res.add(trips.get(i));

			}
		}

		return res;

	}

}
