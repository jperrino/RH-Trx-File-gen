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
	
	BufferedWriter output = null;
	String docTimeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	int lnum;
    try {
        File file = new File("C:\\Users\\Julian Perrino\\Desktop\\pas_99_" + docTimeStamp + ".txt");
        output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.US_ASCII));
        //output = new BufferedWriter(new FileWriter(file));
        output.write("C|" + docTimeStamp + "|pas_99_" + docTimeStamp + ".txt");
        output.newLine();
        for(lnum = 0; lnum < 10; lnum++){
        	output.write(generateLine());
            output.newLine();
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
					TrxFields.getTimeStamp() + "|" +
					TrxFields.getDatosAdicionales();
	
	return line;
	}

}
