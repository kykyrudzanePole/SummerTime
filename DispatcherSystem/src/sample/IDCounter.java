package sample;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDCounter {
    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;

    public static int ID_CallsRegistration, ID_CourerRegistration;

    public static void getID() {        // method which read id from text file
        String[] mas = new String[2];

        try {
            bufferedReader = new BufferedReader(new FileReader(new File("ID_Information.txt")));    // using BufferdReader

            for(int i = 0; i < 2; i++) {                    // circle to check line
                String idLine = bufferedReader.readLine();

                Pattern pattern = Pattern.compile("\\d+");      // search numbers in line
                Matcher matcher = pattern.matcher(idLine);

                while(matcher.find()){
                    mas[i] = matcher.group();           // if find number add to array
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ID_CallsRegistration = Integer.parseInt(mas[0]);
        ID_CourerRegistration = Integer.parseInt(mas[1]);

        // send values from array to the IDnumbers in CallsRegistration.DataBaseWriter and CourerRegistration.DataBaseWriter classes
        sample.CallsRegistration.DataBaseWriter.IDnumber = ID_CallsRegistration;
        sample.CourerRegistration.DataBaseWriter.IDnumber = ID_CourerRegistration;

    }
    public static void setId(int ID_Courer, int ID_Calls) {   // method which call when application close and write IDs to the file
        try {
            System.out.println("Close");        // simole console check

            bufferedWriter = new BufferedWriter(new FileWriter(new File("ID_Information.txt"))); // using ID_Information.txt file

            bufferedWriter.write("ID_CallsRegistration=" + ID_Calls);   // first line
            bufferedWriter.newLine();
            bufferedWriter.write("ID_CourerRegistration=" + ID_Courer);     // second line

            bufferedWriter.flush();     
            bufferedWriter.close();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
