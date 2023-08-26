package com.geektrust.backend;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class App {
    public static void main(String[] args) {
		List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
		readingFile(commandLineArgs.get(0));
	}

	public static void readingFile(String inputFile){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(inputFile));
			String line = reader.readLine();
			List<String> tokens = new ArrayList<>();
			while (line != null) {
				tokens.add(line);				
				line = reader.readLine();
			}			
			reader.close();	
			run(tokens);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void run(List<String> tokens) {		
		Merger m = new Merger();
		m.printTrains(tokens);	
	}

}

