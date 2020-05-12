package com.hit.server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hit.service.Controller;

import java.io.*;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.Scanner;


public class HandleRequest implements Runnable{
    Socket socket;
    Controller controller;

    HandleRequest(Socket clientsocket,Controller controller){
        this.controller = controller;
        this.socket = clientsocket;
    }

    public void run() {
        Gson json = new Gson();
        String reqData;
        Request request;
        try {
            InputStream stream = socket.getInputStream();
            Scanner reader = new Scanner(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter (new OutputStreamWriter (socket.getOutputStream()));

            reqData = reader.nextLine();
            request = json.fromJson(reqData,Request.class);
            Response response =  controller.PreformAction(request);
            String mes = json.toJson(response);
            writer.println(mes);
            writer.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
