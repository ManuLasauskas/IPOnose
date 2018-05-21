package Presentacion;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Pruebas {
	public static void main(String[] args){
		DateFormat fm= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = Calendar.getInstance().getTime();
		String fecha = fm.format(date);
		System.out.println(fecha);
		System.out.println(date);
		Date recuperar_fecha = null;
		try {
			recuperar_fecha = fm.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(recuperar_fecha);
		String fecha_recuperada=fm.format(recuperar_fecha);
		System.out.println(fecha_recuperada);

	}
}
