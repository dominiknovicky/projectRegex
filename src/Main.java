import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader ("rawText.txt");
        BufferedReader br = new BufferedReader (fr);
        String line = br.readLine();
        Pattern spz = Pattern.compile("[A-Z]{2}[0-9]{3}[A-Z]{2}");
        Pattern rc = Pattern.compile("\\d{2}(([05][1-9]|)|([16][012]))((0[1-9])|([12][0-9])|[3][01])\\/?(\\d{4})");
        Pattern mac = Pattern.compile("([0-9A-F]{2}[:-]){5}([0-9A-F]{2})");
        PrintWriter writerSPZ = new PrintWriter("spz.txt", "UTF-8");
        PrintWriter writerRC = new PrintWriter("rc.txt", "UTF-8");
        PrintWriter writerMAC = new PrintWriter("mac.txt", "UTF-8");

        while (line != null) {
            String []parts = line.split(" ");
            for( String w : parts) {
                Matcher mSPZ = spz.matcher((String)w);
                Matcher mRC = rc.matcher((String)w);
                Matcher mMAC = mac.matcher((String)w);

                if(mRC.matches())
                    writerRC.println(w);
                if(mSPZ.matches())
                    writerSPZ.println(w);
                if(mMAC.matches())
                    writerMAC.println(w);

            }
            line = br.readLine();
        }

        writerSPZ.close();
        writerRC.close();
        writerMAC.close();
    }
}
