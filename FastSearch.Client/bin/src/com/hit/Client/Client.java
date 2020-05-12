package com.hit.Client;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.hit.Client.Messages.Request;
import com.hit.Client.Messages.Response;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    public Client() {

    }

    public Response send(Request request) {
        Gson json = new Gson();
        Response response = new Response();
        Socket socket = null;
        String inputData = null;
        String requestData = null;
        try {
            json.serializeNulls();
        requestData = json.toJson(request);

        }
        catch (Exception ex) {

            System.out.println("Failed to convert Request to JSON String StackTrace - ");
            ex.printStackTrace();
        }



        try {
            socket = new Socket("localhost", 12345);

            try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()))) {

                try (Scanner sc = new Scanner(new InputStreamReader(socket.getInputStream()))) {

                    pw.println(requestData);
                    pw.flush();
                    inputData = sc.nextLine();
                }

            }
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try{

            response = json.fromJson(inputData,Response.class);

        } catch (JsonSyntaxException e) {

            System.out.println("Failed to Convert Request To JSON StackTrace - ");
            e.printStackTrace();
        }
        return response;
    }


}
