package com.hit.Client.Messages;


import com.hit.dm.searchItem;

public class Request {
    public eActions actionType;
    public searchItem item;
    public eAlgoType algoType;
    public String key;

    public Request() {
    }



    public Request(eActions actionType, searchItem item, String key,eAlgoType algoType) {
        this.actionType = actionType;
        this.item = item;
        this.key = key;
        this.algoType = algoType;
    }

}
