package com.geektrust.backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.geektrust.backend.entities.Boggie;


public class Trains {
    private HashMap<String, Integer> stationsAfterHYB;

    public Trains(){
        this.stationsAfterHYB = new HashMap<String, Integer>(){{ put("HYB", 0); put("NGP", 400); put("ITJ", 700);
        put( "BPL", 800); put("AGA", 2500); put("NDL", 2700); put("PTA", 3800); put("NJP", 4200); put("GHY", 4700);
        }};
    }

    public ArrayList<Boggie> printTrainA(String train_A){
        String trainBStarterMessage  = "ARRIVAL TRAIN_A ENGINE";
        System.out.print(trainBStarterMessage);
        ArrayList<String> boggieFromArrivalTrain = new ArrayList<String>(Arrays.asList(train_A.split(" ")));
        ArrayList<Boggie> listOfDepartureBoggies = printSeparateTrains(boggieFromArrivalTrain);
        System.out.println("");
        return listOfDepartureBoggies;
    }


    public ArrayList<Boggie> printTrainB(String train_B){
        String trainBStarterMessage  = "ARRIVAL TRAIN_B ENGINE";
        System.out.print(trainBStarterMessage);
        ArrayList<String> boggieFromArrivalTrain = new ArrayList<String>(Arrays.asList(train_B.split(" ")));
        ArrayList<Boggie> listOfDepartureBoggies = printSeparateTrains(boggieFromArrivalTrain);
        return listOfDepartureBoggies;
       
    }

    private ArrayList<Boggie> printSeparateTrains(ArrayList<String> boggieFromArrivalTrain){
        ArrayList<Boggie> listOfDepartureBoggies = new ArrayList<Boggie>();

        String trainBStarterMessage  = "";
        for(int i=2;i<boggieFromArrivalTrain.size();i++){
            if(this.stationsAfterHYB.containsKey(boggieFromArrivalTrain.get(i).trim())){
                String stationName = boggieFromArrivalTrain.get(i).trim();

                trainBStarterMessage = trainBStarterMessage + " "  + stationName;
                Boggie trainObj = new Boggie(stationsAfterHYB.get(stationName), stationName);
                listOfDepartureBoggies.add(trainObj);
            }
        }
        System.out.print(trainBStarterMessage);
        return listOfDepartureBoggies;
    }
}
