import java.io.*;
import java.lang.management.ManagementFactory;
import java.util.Scanner;

/**
 * Created by ImanH on 3/17/2019.
 * Seyed Iman Hosseini Zavaraki
 * Github @ https://github.com/ImanHosseini
 * Wordpress @ https://imanhosseini.wordpress.com/
 */
public class Emulator {
    public static void main(String[] args){
        System.out.println(ManagementFactory.getRuntimeMXBean().getName());
        try {
            // String[] cmd = new String[]{"vvp","stb"};
            String[] cmd = new String[]{"a.exe"};
            // OR String cmd = "cmd /c javac";
            // OR String cmd = "java -cp myjar com.my.sample";
            ProcessBuilder pb = new ProcessBuilder(cmd);
            Process p = pb.start();

            // Process p = new ProcessBuilder("cmd","/c","dir").start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            OutputStream stdin = p.getOutputStream();

            OutputStreamWriter writer = new OutputStreamWriter(stdin);
            Scanner scanner = new Scanner(System.in);
            String line;
//            Thread.sleep(1000);
//            line = br.readLine();
//            System.out.println(line);

            while(true){
                String input = scanner.nextLine();
                if(input.equals("q")) break;
                writer.write(input);
                // writer.write(System.lineSeparator());
                writer.flush();
                writer.close();
           //     writer.close();


//                OutputStream stdin2 = stdin;
//                OutputStreamWriter writer2 = writer;
//                writer.close();
//                stdin = stdin2;
//                writer=writer2;

                    line = br.readLine();
                    System.out.println(line);

            }

            p.waitFor();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
