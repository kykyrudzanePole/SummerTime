package sample;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDCounter {
    BufferedReader bufferedReader;

    int ID_DispatcherLogin, ID_CourerRegistration;

    public void getID() {
        String[] mas = new String[2];

        try {
            bufferedReader = new BufferedReader(new FileReader(new File("ID_Information.txt")));

            for(int i = 0; i < 2; i++) {
                String idLine = bufferedReader.readLine();

                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(idLine);

                while(matcher.find()){
                    mas[i] = matcher.group();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ID_DispatcherLogin = Integer.parseInt(mas[0]);
        ID_CourerRegistration = Integer.parseInt(mas[1]);

        sample.CallsRegistration.DataBaseWriter.IDnumber = ID_DispatcherLogin;
        sample.CourerRegistration.DataBaseWriter.IDnumber = ID_CourerRegistration;

    }
    public void setId(int IDnumber){
        
    }
}
