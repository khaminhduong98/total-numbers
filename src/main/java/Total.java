import org.apache.commons.lang3.StringUtils;

import java.io.*;

public class Total {
    public static void main(String[] args) {

        BufferedReader br = null;
        File in_file = new File("C:\\Users\\KHA MINH\\Documents\\Numbers.txt");
        File out_file = new File("C:\\Users\\KHA MINH\\Documents\\Total.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(out_file))) {
            int count = 0;
            String contentLine;
            int i = -1;
            int sum = 0;

            br = new BufferedReader(new FileReader(in_file));
            // Count number of lines
            while ((br.readLine()) != null) {
                count++;
            }
            int[] arr = new int[count];

            br = new BufferedReader(new FileReader(in_file));
            // Read data from first file
            // Put item into array
            while ((contentLine = br.readLine()) != null) {
                if (!StringUtils.isEmpty(contentLine)) {
                    i++;
                    arr[i] = Integer.parseInt(contentLine);
                }
            }

            // Print array
            for (int k = 0; k < arr.length; k++) {
                if (arr[k] != 0)
                    System.out.println("Number " + (k+1) + ": " + arr[k]);
                sum += arr[k];
            }

            // Sum of items in array
            System.out.println("Total: " + sum);
            String result = String.valueOf(sum);

            bw.write(result);

            System.out.println("Result was written to output file.");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
