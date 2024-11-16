package com.logistics.logisticsLab.exception.itemEvaluation;


public class InvalidAccountDetails extends RuntimeException{

    public InvalidAccountDetails(){
        super();
    }

    public InvalidAccountDetails(String msg){
        super(msg);
    }

}
