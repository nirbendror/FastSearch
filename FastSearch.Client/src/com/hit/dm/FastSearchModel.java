package com.hit.dm;

import com.hit.Client.Client;
import com.hit.Client.Messages.Request;
import com.hit.Client.Messages.Response;

import java.util.Observable;

public class FastSearchModel extends Observable {

    private Client client;
    private Request request;
    private Response response;


    public FastSearchModel() {
        client = new Client();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Response sendRequest(Request request)
    {
        //request = client.buildRequest(key,algo,action, item);
        response = client.send(request);
        return response;
    }


}
