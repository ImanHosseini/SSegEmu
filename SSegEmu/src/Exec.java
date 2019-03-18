import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * Created by ImanH on 3/17/2019.
 * Seyed Iman Hosseini Zavaraki
 * Github @ https://github.com/ImanHosseini
 * Wordpress @ https://imanhosseini.wordpress.com/
 */
public class Exec {
    public static void main(String[] args){
        try {
            String[] cmd = new String[]{"vvp","hello"};
            // OR String cmd = "cmd /c javac";
            // OR String cmd = "java -cp myjar com.my.sample";
            Process p = new ProcessBuilder(cmd).redirectErrorStream(true).start();
            // Process p = new ProcessBuilder("cmd","/c","dir").start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            p.waitFor();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
