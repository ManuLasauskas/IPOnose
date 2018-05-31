package Dominio;

import java.util.Comparator;

public class EndDateComparator implements Comparator<Tarea> {
	@Override
	public int compare(Tarea  o1, Tarea o2) {
		return o1.getFecha_fin().compareTo(o2.getFecha_fin());
	}

}

