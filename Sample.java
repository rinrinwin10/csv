/**
 * Sample
 */
public class Sample {

    public static void main(String[] args) {
        CSV csvmanager = new CSV();
        String[][] inputdata;
        String[][] outputData = {{"a","b","c"},{"hoge1","hoge2","hoge3"}};

        inputdata = csvmanager.readCSV("sample_input.csv", 3, 3);
        
        for (int i = 0; i < inputdata.length; i++) {
            String str = "";
            for (int j = 0; j < inputdata[i].length; j++) {
                str += inputdata[i][j] + " ";
            }
            System.out.println(str);
        }
        
        csvmanager.exportCSV(outputData, "sample_output.csv");
    }
}