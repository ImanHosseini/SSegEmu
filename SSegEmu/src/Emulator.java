import Lib.StdDraw;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.nio.charset.Charset;
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
            String[] cmd = new String[]{"vvp","std"};
            // OR String cmd = "cmd /c javac";
            // OR String cmd = "java -cp myjar com.my.sample";
            ProcessBuilder pb = new ProcessBuilder(cmd);
            Process p = pb.start();

            // Process p = new ProcessBuilder("cmd","/c","dir").start();
             BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            OutputStream stdin = p.getOutputStream();

            OutputStreamWriter writer = new OutputStreamWriter(stdin, Charset.forName("ASCII"));
            Scanner scanner = new Scanner(System.in);
            String line;
//            Thread.sleep(1000);
//            line = br.readLine();
//            System.out.println(line);

            SSeg sseg = new SSeg();
            StdDraw.setCanvasSize(600,600);
            while(true){
                String input = scanner.nextLine();
                if(input.equals("q")) break;
                writer.write(input+"\n");
                // writer.write(System.lineSeparator());
                writer.flush();

              //  writer.close();
           //     writer.close();


//                OutputStream stdin2 = stdin;
//                OutputStreamWriter writer2 = writer;
//                writer.close();
//                stdin = stdin2;
//                writer=writer2;

                    line = br.readLine();
                    sseg.setFromHex(line.split(" ")[1]);
                    //
                // System.out.println(sseg.gfedcba[0]+"*"+sseg.gfedcba[1]+"*"+sseg.gfedcba[2]+"*"+sseg.gfedcba[3]+"*"+sseg.gfedcba[4]+"*"+sseg.gfedcba[5]+"*"+sseg.gfedcba[6]);
                    sseg.drawDisp();
                    System.out.println(line);

            }

            p.waitFor();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
