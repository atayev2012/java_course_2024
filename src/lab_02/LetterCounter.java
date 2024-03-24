package lab_02;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class LetterCounter {
    private String inputFilePath, outputFilePath;
    private String inputStatus, outputStatus;
    private int[] lowerLetterCount;
    private int[] upperLetterCount;
    private int totalCharsScanned;
    private int totalCharsMatched;

    LetterCounter(){
        inputFilePath = "Not introduced yet!";
        outputFilePath = "Not introduced yet!";
        inputStatus = "Not checked!";
        outputStatus = "Not checked!";
        lowerLetterCount = new int[26];
        upperLetterCount = new int[26];
        totalCharsScanned = 0;
        totalCharsMatched = 0;
    }

    // type = "input" or "output"
    public void requestFileName(String type){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter " + type + " file path: ");
        if(Objects.equals(type, "input")){
            inputFilePath = sc.nextLine();
        } else if(Objects.equals(type, "output")){
            outputFilePath = sc.nextLine();
        }
    }

    // check path status
    private void checkFileStatus(String type) throws IOException {
        File dataFile;
        if(Objects.equals(type, "input")){
            dataFile = new File(inputFilePath);
            if(dataFile.exists()){
                inputStatus = "File Exists";
            }else{
                inputStatus = "File Not Found";
            }
        }else{
            dataFile = new File(outputFilePath);
            if(dataFile.exists()){
                outputStatus = "File Exists";
            }else{
                try{
                    if(dataFile.createNewFile()){
                        outputStatus = "Empty file was created";
                    }else{
                        outputStatus = "File could not be created";
                    }
                }
                catch(IOException e){
                    System.err.println("Error: " + e);
                }
            }
        }
    }

    // read from file and calculate
    private void calculateLetters() throws IOException{
        File dataFile = new File(inputFilePath);
        String bufferString;
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(dataFile));
            while((bufferString = br.readLine()) != null){
                for(int i=0; i< bufferString.length(); i++){
                    int asciiCode = (int)bufferString.charAt(i);
                    if(asciiCode >= 65 && asciiCode <= 90){
                        upperLetterCount[asciiCode - 65] += 1;
                        totalCharsMatched++;
                    }else if(asciiCode >= 97 && asciiCode <= 122){
                        lowerLetterCount[asciiCode - 97] += 1;
                        totalCharsMatched++;
                    }
                    totalCharsScanned++;
                }
            }
        }
        catch(IOException e){
            System.err.println("Could not read! Error in " + inputFilePath + ": " + e);
        }
        finally {
            if(br != null){
                br.close();
            }
        }
    }

    // write the results to file (overwrite existing results)
    private void writeResult() throws IOException{
        File dataFile = new File(outputFilePath);
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter(dataFile));
            for(int i=0; i<26; i++){
                if(upperLetterCount[i] != 0){
                    bw.write((char)(i+65) + " - " + upperLetterCount[i] + "\n");
                }
            }
            for(int i=0; i < 26; i++){
                if(lowerLetterCount[i] != 0){
                    bw.write((char)(i+97) + " - " + lowerLetterCount[i] + "\n");
                }
            }

            bw.write("Total number of scanned characters: " + totalCharsScanned + "\nTotal number of matched characters: " + totalCharsMatched + "\n");
            System.out.println("Data was written to " + outputFilePath + " successfully!");
        }
        catch(IOException e){
            System.err.println("Could not write! Error in " + outputFilePath + ": " + e);
        }
        finally{
            if(bw != null){
                bw.close();
            }
        }
    }

    private String generateMenu(){
        String outputString = "===================Status===================\n" +
                "Input file:\t\t" + inputFilePath + " - Available: " + inputStatus + "\n" +
                "Output file:\t" + outputFilePath + " - Available: " + outputStatus + "\n\n" +
                "Total Symbols scanned: " + totalCharsScanned + "\n" +
                "Total Symbols matched: " + totalCharsMatched + "\n" +
                "Choose command number:\n" +
                "1. Change input path\n" +
                "2. Change output path\n" +
                "3. Calculate characters (A-Z, a-z)\n" +
                "4. Exit\n\n" +
                "Enter a command number: ";
        System.out.print(outputString);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private void emptyData(){
        for(int i=0; i<26; i++){
            upperLetterCount[i] = 0;
            lowerLetterCount[i] = 0;
        }
        totalCharsMatched = 0;
        totalCharsScanned= 0;
    }

    public void mainMenu() throws IOException {
        String command = "";
        while(!Objects.equals(command, "4")){
            if(inputFilePath.equals("Not introduced yet!") || (command.equals("1"))) {
                requestFileName("input");
                checkFileStatus("input");
                emptyData();
                command = "";
            }else if(outputFilePath.equals("Not introduced yet!") || (command.equals("2"))){
                requestFileName("output");
                checkFileStatus("output");
                emptyData();
                command = "";
            }else if(Objects.equals(command, "3")){
                calculateLetters();
                writeResult();
                command = generateMenu();
            }else{
                command = generateMenu();
            }
        }
    }
}
