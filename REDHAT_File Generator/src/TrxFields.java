import java.text.SimpleDateFormat;
import java.util.Date;

public class TrxFields {
	private static char tipoDeRegistro = 'D';
	private static String[] codigoOperacion = {"10", "30"}
						  , subCodigoOperacion = {"00", "01", "02"}
						  , codigoConcesionario = {"1", "3", "4", "8", "77", "98", "99"}
						  , corredor = {"AU La Plata, Ruta 2"}
						  , estacionDePeaje = {"Berazategui"}
						  , via = {"00065M"};
	private static char[] sentido = {'A'};
	private static boolean tagFlag = false;
	private static String[] tag = {"SI9091223344", "SI9091223349"}
						  , categoriaAlta = {"0201"}
						  , categoriaDetectada = {"0201"};
	private static String importe = "000000001025";
	private static String localizador = null;
	private static int numVia = 123456;
	private static String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	private static String datosAdicionales = "qwertyuiopasdfghjklzxcvbqwertyuiopasdfghjklzxcvbqwertyuiopasdfghjklzxcvbqwertyuiopasdfghjklzxcvb1234";
	
	public static char getTipoDeRegistro() {
		return tipoDeRegistro;
	}
	public static String[] getCodigoOperacion() {
		return codigoOperacion;
	}
	public static String[] getSubCodigoOperacion() {
		return subCodigoOperacion;
	}
	public static String[] getCodigoConcesionario() {
		return codigoConcesionario;
	}
	public static String[] getCorredor() {
		return corredor;
	}
	public static String[] getEstacionDePeaje() {
		return estacionDePeaje;
	}
	public static String[] getVia() {
		return via;
	}
	public static char[] getSentido() {
		return sentido;
	}
	public static String getTag() {
		if(tagFlag == false){
			tagFlag = true;
			return tag[0];
		}
		else {
			tagFlag = false;
			return tag[1];
		}
	}
	public static String[] getCategoriaAlta() {
		return categoriaAlta;
	}
	public static String[] getCategoriaDetectada() {
		return categoriaDetectada;
	}
	public static String getImporte() {
		return importe;
	}
	public static void setLocalizador() {
		localizador  = "123456789876ABCD" + numVia;
		numVia++;
	}
	public static String getLocalizador() {
		setLocalizador();
		return localizador;
	}
	public static String getTimeStamp() {
		return timeStamp;
	}
	public static String getDatosAdicionales() {
		return datosAdicionales;
	}

}
