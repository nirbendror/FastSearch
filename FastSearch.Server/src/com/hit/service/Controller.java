package com.hit.service;

import com.hit.algorithm.IAlgoStringMatching;
import com.hit.algorithm.KMPStringMatching;
import com.hit.algorithm.NaiveStringMatching;
import com.hit.algorithm.RabinKarpStringMatching;
import com.hit.dm.searchItem;
import com.hit.server.Request;
import com.hit.server.Response;

import java.util.ArrayList;

public class Controller {

    SearchService searchService = new SearchService(new KMPStringMatching());

    public Response PreformAction(Request request) {
        Response response=new Response();

        switch (request.getActionType())
        {
            case Add:
            {
                response = HandalAdd(request);
                break;
            }
            case Remove:
            {
                response = HandalRemove(request);
                break;
            }
            case Search:
            {
                assert response != null;
                response.arr = HandelSearch(request);
            }


        }
        return response;
    }

    public Response HandalAdd(Request request)
    {
        boolean add;
        add = searchService.addItem(request.getItem());
        Response response = new Response();
        if (!add)
        {
            response.setErrorMes("Error, Failed to Add item");
            response.setSuccess(false);
        }
        return response;

    }

    public Response HandalRemove(Request request)
    {
        boolean remove;
        Response response = new Response();
        remove = searchService.removeItem(request.getItem());
        if(!remove)
        {
            response.setErrorMes("Failed to remove item");
            response.setSuccess(false);
        }
        return response;
    }

    public ArrayList<searchItem> HandelSearch(Request request) {

        ArrayList<searchItem> resList = new ArrayList<searchItem>();
        Response response = new Response();
        switch(request.getAlgoType()){
            case KMP:
                System.out.println("KMP");
                searchService.setAlgo(new KMPStringMatching());
                break;
            case Naive:
                System.out.println("Naive");
                searchService.setAlgo(new NaiveStringMatching());
                break;
            case RabinKarp:
                searchService.setAlgo(new RabinKarpStringMatching());
                break;
        }
        resList = searchService.serachItem(request.getKeyWord());

        return resList;
    }

}



