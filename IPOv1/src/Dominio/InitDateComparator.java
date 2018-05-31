package Dominio;

import java.util.Comparator;

public class InitDateComparator implements Comparator<Tarea> {
	@Override
	public int compare(Tarea  o1, Tarea o2) {
		return o1.getFecha_ini().compareTo(o2.getFecha_ini());
	}

}
