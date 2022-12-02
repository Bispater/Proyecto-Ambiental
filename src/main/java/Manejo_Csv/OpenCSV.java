package Manejo_Csv;
/*
package Manejo_Csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class OpenCSV {


    String archCSV = "src/main/resources/CSVTEST.csv";
    CSVReader csvReader = new CSVReader(new FileReader(archCSV));
    String[] fila =  csvReader.readNext();

    while(fila != null) {
        System.out.println(fila[0]
                + " | " + fila[1]
                + " |  " + fila[2]);
    }

    public OpenCSV() throws IOException, CsvValidationException {
    }

    csvReader.close();
}
*/
import com.opencsv.*;
import java.io.*;
import java.io.IOException;

public class OpenCSV {
    public static void main(String[] args) {
        FileReader archCSV = null;
        CSVReader csvReader = null;

        try {
            //Leo el archivo con el separador estándar ","
             archCSV = new FileReader("src/main/resources/CSVTEST.csv");
             csvReader = new CSVReader(archCSV);
             String[] fila = null;
            while((fila = csvReader.readNext()) != null) {
                System.out.println(fila[0]
                           + " | " + fila[1]
                           + " |  " + fila[2]);
             }

            //Ahora leo el archivo con el separador ";"
    /*
            try {
                archCSV = new FileReader("src/main/resources/CSVTEST.csv");

            }catch(Exception e){
                System.out.println("he1 -> ");
            }
            CSVParser conPuntoYComa = new CSVParserBuilder().withSeparator(';').build();

            csvReader = new CSVReaderBuilder(archCSV).withCSVParser(conPuntoYComa).build();
            System.out.println("he -> " + csvReader);
            String[] fila;
            while((fila = csvReader.readNext()) != null) {
                System.out.println(fila[0]
                        + " | " + fila[1]
                        + " |  " + fila[2]);
            }
    */
        }
        catch(IOException e) {
            System.out.println(e);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        finally {
            try {
                archCSV.close();
            }
            catch(IOException e) {
                System.out.println(e);
            }
        }
    }
}