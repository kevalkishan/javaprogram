package org.example;

import com.amazonaws.services.dynamodbv2.xspec.S;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class csvfileprocess{
    public static String getStudent(String line) {
        return "hi";
    }
}
public class Main {
    public static void main(String[] args) throws IOException {

//        File f = new File("input2.txt");
        File csvoutput = new File("csvoutput.csv");
        csvoutput.createNewFile();
        String data ="keval,prianks,1223";
        System.out.println(data);
        writetooutputcsvprinter(csvoutput,data,"file \"file23\" not found");




//        String s =writeoutputtoStringBuidler("hi there");
//        System.out.println(s);

       String ans = myans();
        System.out.println(ans);
    }
    private static String myans(String ...ans){
        if(ans.length!=0){
            return ans[0];
        }
        return "no argument";
    }
    private static String writeoutputtoStringBuidler(CSVRecord output) throws IOException {
        StringBuilder sb = new StringBuilder();
        CSVPrinter csvPrinter = new CSVPrinter(sb,CSVFormat.EXCEL);
        csvPrinter.print(sb);
        csvPrinter.flush();
        return sb.toString();
    }
    private static void writetooutputcsvprinter(File csvoutput,String data,String error) throws IOException {
        String fileName = "output.csv";
//        String error = "file not found";



        CSVFormat csvFormat =  CSVFormat.EXCEL;
        CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(csvoutput), csvFormat);


       String[] lis = String.format("%s,\"%s\"",data,error).split(",");
        System.out.println(Arrays.toString(lis));
        // Write the string to the CSV file
                csvPrinter.printRecord(lis);
                csvPrinter.flush();

    }
    private static void writetooutputcsvWriter(File csvWriterOutput) throws IOException {
    CSVWriter csvWriter = new CSVWriter(new FileWriter(csvWriterOutput));
        List<String> errorData = new ArrayList<>();
        String data = "kevalkishan";
        String error = "wrong name\"enclosed\"s identified";

        errorData.add(String.format("%s,\"%s\"", data, error));
        csvWriter.writeNext(new String[]{errorData.get(0)});
        csvWriter.flush();


    }
    private static void readfile(File source) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(source));
        List<String> list = new ArrayList<>();
        String line = br.readLine();
        while (line!=null){
            list.add(line);
            line= br.readLine();
        }
        System.out.println(list);


    }
    public static void byStream() throws IOException {

        Stream<String> lines = Files.lines(Paths.get("C:\\Users\\KevalKishan\\Desktop\\workspace_study\\UserService\\mylearingreltio\\src\\main\\java\\org\\example\\student1.csv"));
        lines.skip(1).map(Main::processMe).forEach(System.out::println);
    }
    public static String processMe(String line){

        return line;
    }
    public static void bybufferreader() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\KevalKishan\\Desktop\\workspace_study\\UserService\\mylearingreltio\\src\\main\\java\\org\\example\\student1.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            // Process the line
            System.out.println(line);
        }
        reader.close();
    }


}