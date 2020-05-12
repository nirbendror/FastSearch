package com.hit.server;


import com.hit.dm.searchItem;

public class Request {
    public eActions actionType;
    public searchItem item;
    public eAlgoType algoType;
    public String key;

    public Request(String keyWord, eActions actionType, eAlgoType algoType) {
        this.actionType = actionType;
        this.algoType = algoType;
        this.key = keyWord;
    }
    public Request(String keyWord, eActions actionType, eAlgoType algoType, searchItem item) {
        this.actionType = actionType;
        this.algoType = algoType;
        this.key = keyWord;
        this.item = item;
    }

    public eActions getActionType() {
        return actionType;
    }

    public searchItem getItem() {
        return item;
    }

    public void setItem(searchItem item) {
        this.item = item;
    }

    public String getKeyWord() {
        return key;
    }

    public eAlgoType getAlgoType() {
        return algoType;
    }

    public void setActionType(eActions actionType) {
        this.actionType = actionType;
    }

    public void setKeyWord(String keyWord) {
        this.key = keyWord;
    }

    public void setAlgoType(eAlgoType algoType) {
        this.algoType = algoType;
    }



}
