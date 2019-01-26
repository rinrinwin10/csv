/**
 * CSV
 */
import java.io.*;

public class CSV {
    // FileInputStream fi = null;
    // InputStreamReader is = null;
    // BufferedReader br = null;
    /**
     * 
     * @param filepath 読み込むファイルパス
     * @param linenum 行数の宣言
     * @param rownum 列数の宣言
     * @return 読み込んだデータを２次元配列として返す
     */
    public String[][] readCSV(String filepath, int linenum, int rownum) {
        String[][] data = new String[linenum][rownum];
        String[][] data_e = {{"",""},{"",""}};
        
        try {
            FileInputStream fi = new FileInputStream(filepath);
            InputStreamReader is= new InputStreamReader(fi);
            BufferedReader br = new BufferedReader(is);
            // String[][] data = new String[][];
            //String[][] data_e = {{"",""},{"",""}};
            String[] dataline;
            String line;

            int i = 0;

            while ((line = br.readLine()) != null) {
                dataline = line.split(",");
                for (int j = 0; j < dataline.length; j++) {
                    data[i][j] = dataline[j];
                }
                // System.out.println(i);
                i++;
            }
            br.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            //強引なので改善の余地あり
            return data_e;
        }/*finally{
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
    }

    /**
    * @param data 書き出すデータ（2次元配列）
    * @param filename 書き出すファイルパス
    */
    public void exportCSV(String[][] data,String filename) {
        try {
            FileWriter f = new FileWriter(filename, false);
            PrintWriter p = new PrintWriter(new BufferedWriter(f));

            // データの出力
            for (int i = 0; i < data.length; i++) {
                // レコードの出力
                for (int j = 0; j < data[i].length; j++) {
                    p.print(data[i][j]);
                    p.print(",");
                }
                p.println();
            }
            //ファイルに書き出して閉じる
            p.close();

            System.out.println("End Output csv.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}