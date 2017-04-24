import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 12.04.2017.
 */
public class CsvParser {

    static void FileCreate(int n, int k, String path) {
        String appended;
        int j = 0;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            for(int i = 0; i < n; i++, j += k) {
                appended = j + ";" + Math.random() + "\n";
                bw.write(appended);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void average(String path, int t) throws IOException {
        int len = 0;
        List<Double> list = new ArrayList<>();
        List<String> file = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String s = br.readLine();
            for(len = 0; s != null; len++) {
                String[] re = s.split(";");
                list.add(Double.parseDouble(re[1]));
                file.add(s);
                s = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            double sum = 0;
            String appended;
            for(int i = 0; i < t; i++) {
                bw.write(file.get(i) + "\n");
                sum += list.get(i);
            }
            for(int i = t; i < 2 * t + 1; i++) {
                sum += list.get(i);
            }

            for(int i = t; i < len - t; i++) {
                appended = file.get(i);
                appended += ";" + Double.toString(sum / (2 * t + 1)) + "\n";
                bw.write(appended);
                if(i != len - t - 1) {
                    sum += list.get(i + t + 1) - list.get(i - t);
                }
            }
            for(int i = len - t; i < len; i++) {
                bw.write(file.get(i) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
