import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("cat", "Meow");
        map.put("ape", "Squeak");
        map.put("dog", "Woof");
        map.put("bat", "Squeak");
        System.out.println("map = " + map);

        System.out.println("A cat says... " + map.get("cat"));
        System.out.println("A dog says... " + map.get("dog"));

        //iterating over values only
        for (String value : map.values()) {
            System.out.println("Value = " + value);
        }
        //iterating over keys only
        for (String key : map.keySet()) {
            System.out.println("Key = " + key);
        }
        System.out.println();
        System.out.println("iterating over keys and values");
        //iterating over keys and values
        for (String key : map.keySet()) {
            System.out.println(key + "\t" + map.get(key));
        }
        System.out.println();

        //writing keys and values to a file
        System.out.println("writing keys and values to a file");
        String filename = (System.getProperty("user.dir") + File.separatorChar + "animalNoises.txt");
        System.out.println(filename);

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
        }

        //print both the key and the value on same line
        // for each key in the key set write the key, a tab and the value
        for (String key : map.keySet()) {
            System.out.println("write this line: " + key);
            writer.println(key + "\t" + map.get(key));
        }
        writer.close();

        //read from a file
        System.out.println("read from a file");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                //System.out.println(line);
                String[] key_value_pair = line.split("\t");
                System.out.println("KV Pair:" + key_value_pair[0] + " " + key_value_pair[1]);
                //the key is in key_value_pair[0]
                //the value is in key_value_pair[1]
                // now you could add it back to the hash map if it isn't there already

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File does not exist!");
        } finally {
            System.out.println("Finally done.");
        }

        // Begin Using HashMaps exercises
        // Create a map and store integers and their word values.

        HashMap<Integer, String> myMap = new HashMap<Integer, String>();
        //Prompt: Enter a number: 10 Response: You entered ten.
        // If number is not found (use myMap.containsKey(10) then prompt user to tell the map to add that to the map.
        // Add the key and value to the map with the following line of code:

        System.out.println("Start HashMap Exercises");

        // Read in hash key/value pairs if the file exists
        BufferedReader bufReader = null;
        String fName = (System.getProperty("user.dir") + File.separatorChar + "numberMaps.txt");

        try {
            bufReader = new BufferedReader(new FileReader(fName));
            String inStr = bufReader.readLine();
            while (inStr != null){
                String[] kvp = inStr.split("\t");
                myMap.put(Integer.parseInt(kvp[0]), kvp[1]);
                System.out.println("KV Pair: " + kvp[0] + " " + kvp[1]);
                inStr = bufReader.readLine();
            }
            bufReader.close();
        }
        catch (IOException e){
            System.out.println("File does not exist.");
        }

        Scanner sc = new Scanner(System.in);
        String val = "";
        int keyInt = 0;
        while (true) {
            System.out.println("Enter a key to view its value");
            keyInt = sc.nextInt();
            if (!myMap.containsKey(keyInt)) {
                // add it to the Hash Map
//                if (sc.hasNext()){
//                    sc.nextLine();
//                }
                sc.nextLine();

                System.out.println("The key that you entered does not exist in the Hash Map.");
                System.out.println("What string value would you like to for key: " + keyInt + " ? ");
                val = sc.nextLine();

                myMap.put(keyInt, val);
                System.out.println("The value that you entered is: " + val);
            } else {
                // map.get(key)
                System.out.println("The value for key: " + keyInt + " is: " + myMap.get(keyInt).toString());
                sc.nextLine();
            }
//            sc.nextLine();

            System.out.println("Enter (q) if you would like to quit");
            val = sc.nextLine();
            if (val.equalsIgnoreCase("q")){
                System.out.println("You are finished.");
                break;
            }
        }
        // Print out the full Hash Map
        System.out.println("Display the full Hash Map keys and values");
        //iterating over keys and values
        for (int key : myMap.keySet()) {
            System.out.println(key + "\t" + myMap.get(key));
        }

        //Save the key/value pairs to a file in the format:
        System.out.println("Writing keys and values to a file.");
        fName = (System.getProperty("user.dir") + File.separatorChar + "numberMaps.txt");
        System.out.println(fName);
        writer = null;
        try {
            writer = new PrintWriter(new File(fName));

        }
        catch (FileNotFoundException e){
            System.out.println("File does not exist.");
        }

        // Print both the key and value on the same line with a <tab> separating each key and value pair
        for (int key : myMap.keySet()){
            System.out.println("Write this line for key: " + key);
            writer.println(key + "\t" + myMap.get(key));
        }
        writer.close();

        // Modify your program to load the class and populate the hashmap from the file.
        // That way the user will not have to enter a key/value pair twice.

        // Read from the file.
        System.out.println("Read the Hash Map data from the file.");

//        FileReader testFileReader = new FileReader(fName);
//        BufferedReader bf = new BufferedReader(testFileReader);

        // Another case that is mentioned in exercise
        // Use the Scanner.nextInt() and Scanner.next() methods to return values in your file.

        //File file = new File();
        Scanner scannerInput = new Scanner(fName);//note that Scanner can read from a file!
        while (scannerInput.hasNextLine()) {
            String line = scannerInput.nextLine();
            System.out.println(line);
        }

        // One way of iterating through a HashMap....
        // iterating over keys only
        for (Integer key : myMap.keySet()) {
            System.out.println("Key = " + key);
        }

        // iterating over values only
        for (String value : myMap.values()) {
            System.out.println("Value = " + value);
        }
    }
}
