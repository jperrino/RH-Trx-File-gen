import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
//import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class TrxWriter {
	
	public static void main(String[] args) {

		TrxWriter writer = new TrxWriter();
		writer.write();
		
		JOptionPane.showMessageDialog(null, "Documento creado", "Trx File Gen", JOptionPane.PLAIN_MESSAGE);
	}
	
public void write() {
	
	int numhead = 67;
	int localizadorCount = 123448;
	BufferedWriter output = null;
	//String docTimeStamp = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
	//String headerTimeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	int lnum;
    try {
        //File file = new File("C:\\Users\\Julian Perrino\\Desktop\\RedHat\\pas_99_" + docTimeStamp + ".txt");
        File file = new File("C:\\Users\\Julian Perrino\\Desktop\\RedHat\\pas_99_2017101100"+numhead+".txt");
        output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.US_ASCII));
        //output = new BufferedWriter(new FileWriter(file));
        //output.write("C|" + headerTimeStamp + "|pas_99_" + docTimeStamp + ".txt");
        output.write("C|20171001171722|pas_99_2017101100"+numhead+".txt");
        output.newLine();
        for(lnum = 0; lnum < 1000; lnum++){
        	output.write("D|10|01|99|AU La Plata, Ruta 2|Berazategui|00065M|A|SI9091223344|0201|0201|000000001027|123456789876ABCD"+localizadorCount+"|20171001171722|qwertyuiopasdfghjklzxcvbqwertyuiopasdfghjklzxcvbqwertyuiopasdfghjklzxcvbqwertyuiopasdfghjklzxcvb1234");
            output.newLine();
            localizadorCount++;
        }
        output.write("T|" + lnum);
    	}
    catch( IOException e ){ e.printStackTrace(); }
    
    finally
    {
      if (output != null) {
        try {
			output.close();
			}
        catch(IOException e){ e.printStackTrace(); }
      	}
    }
}

public String generateLine() {
	
	String line = String.valueOf(TrxFields.getTipoDeRegistro()) + "|" +
					TrxFields.getCodigoOperacion()[0] + "|" +
					TrxFields.getSubCodigoOperacion()[1] + "|" +
					TrxFields.getCodigoConcesionario()[6] + "|" +
					TrxFields.getCorredor()[0] + "|" +
					TrxFields.getEstacionDePeaje()[0] + "|" +
					TrxFields.getVia()[0] + "|" +
					String.valueOf(TrxFields.getSentido()) + "|" +
					TrxFields.getTag() + "|" +
					TrxFields.getCategoriaAlta()[0] + "|" +
					TrxFields.getCategoriaDetectada()[0] + "|" +
					TrxFields.getImporte() + "|" +
					TrxFields.getLocalizador() + "|" +
					"20171001171722" + "|" +
					TrxFields.getDatosAdicionales();
	
	return line;
	}

}
