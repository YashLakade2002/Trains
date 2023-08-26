package com.geektrust.backend;

import java.util.ArrayList;
import java.util.List;
import com.geektrust.backend.entities.Boggie;


public class Merger {
    private ArrayList<Boggie> DepartureBoggiesFromBothTrains ;    
    private ArrayList<Boggie> ArrivalBoggiesFromTrain1 ;
    private ArrayList<Boggie> ArrivalBoggiesFromTrain2 ;
    
    public Merger(){        
        this.DepartureBoggiesFromBothTrains = new ArrayList<Boggie>();
        this.ArrivalBoggiesFromTrain1 = new ArrayList<Boggie>();
        this.ArrivalBoggiesFromTrain2 = new ArrayList<Boggie>();
    }

    public void setupForCombiningTrains(List<String> dataInput){
        Trains merger = new Trains();
        this.ArrivalBoggiesFromTrain1 = merger.printTrainA(dataInput.get(0));
        this.ArrivalBoggiesFromTrain2 = merger.printTrainB(dataInput.get(1));

        this.DepartureBoggiesFromBothTrains.addAll(ArrivalBoggiesFromTrain1);
        this.DepartureBoggiesFromBothTrains.addAll(ArrivalBoggiesFromTrain2);

        DepartureBoggiesFromBothTrains.sort((o1, o2)-> o1.getId().compareTo(o2.getId()));
    }

    public void printTrains(List<String> dataInput){      
        setupForCombiningTrains(dataInput);
        String combineTrainsPrinterMessage = "";
        for(int i=this.DepartureBoggiesFromBothTrains.size()-1;i>=0;i--){
            if(this.DepartureBoggiesFromBothTrains.get(i).getId() != 0){
                combineTrainsPrinterMessage = combineTrainsPrinterMessage + " " + this.DepartureBoggiesFromBothTrains.get(i).getName();
            }
        }
        
        combineTrainsPrinterMessage = "\n" + ((combineTrainsPrinterMessage == "") ? "JOURNEY_ENDED" : "DEPARTURE TRAIN_AB ENGINE ENGINE" + combineTrainsPrinterMessage);
        System.out.print(combineTrainsPrinterMessage);
    }
}
