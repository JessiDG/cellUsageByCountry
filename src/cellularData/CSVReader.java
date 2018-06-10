package cellularData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.out;

/**
 *  This class reads input from a CSV file.
 * @author Foothill College, Jessica Dickinson Goodman
 */
public class CSVReader {
    private String[] countryNames;
    private int[] yearLabels;
    private double[][] CellularDataTable;

    /**
     * Returns a File object and a Scanner object
     * @param filename      this is the name of the file
     */
    public CSVReader(String filename) {
        Scanner input = null;
        try {
            File infile = new File(filename);
            input = new Scanner(infile);
            int numRows = -3;
            int numCols = 0;

            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] tokens = line.split(",");
                if (tokens.length > numCols)
                    numCols = tokens.length;
                numRows++;
            }
            input = new Scanner(infile);
            countryNames = new String[numRows];
            yearLabels = new int[numCols];
            CellularDataTable = new double[numRows][numCols];

            int count = 0;
            int countryCounter = 0;

            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                if(tokens[0].contains("World Development Indicators") || tokens[0].contains("Number of countries")){ continue; }
                else if (tokens[0].contains("Country Name")) {
                    for (int i = 1; i < tokens.length; i++) {
                        yearLabels[i - 1] = Integer.parseInt(tokens[i]);
                    }
                }
                else {
                    countryNames[countryCounter] = tokens[0];
                    for (int i = 1; i < tokens.length; i++){
                        CellularDataTable[countryCounter][i - 1] = Double.parseDouble(tokens[i]);
                    }
                    countryCounter ++;
                }
            }
            input.close();
        }
        catch (FileNotFoundException e) {
            out.println("File " + filename + " not found.");
            out.println("Please try again.");
            out.println(e.getStackTrace());
            exit(-1);
        }
    }

    /**
     * This accessor method returns countryNames
     * @return a string array countryNames[]
     */
    public String[] getCountryNames(){ return countryNames; }

    /**
     * This accessor method returns yearLabels
     * @return an int array yearLabels
     */
    public int[] getYearLabels(){ return yearLabels; }

    /**
     * This accessor method returns CellularDataTable
     * @return a two dimensional array of doubles getCellularDataTable
     */
    public double[][] getParsedTable(){ return CellularDataTable; }

    /**
     * This accessor method returns the number of columns minus one using the
     * length of the last row in the table
     * @return an int of the number of years covered in the file
     */
    public int getNumberOfYears(){
        return CellularDataTable[CellularDataTable.length - 1].length;
    }
}
