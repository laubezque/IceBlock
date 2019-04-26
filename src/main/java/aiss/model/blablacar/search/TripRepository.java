package aiss.model.blablacar.search;

import java.util.ArrayList;
import java.util.List;

public class TripRepository {

	private List<Trip> trips;

	private List<Trip> getTrips(String dep, String ar, String date) {

		List<Trip> res = new ArrayList<Trip>();
		for (int i = 0; i < trips.size(); i++) {
			if (trips.get(i).getDeparturePlace().getCityName().equals(dep)
					&& trips.get(i).getArrivalPlace().getCityName().equals(ar)
					&& trips.get(i).getDepartureDate().equals(date)) {
				res.add(trips.get(i));

			}
		}

		return res;

	}

}
