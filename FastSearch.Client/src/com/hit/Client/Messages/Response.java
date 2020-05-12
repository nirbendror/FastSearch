package com.hit.Client.Messages;
import com.hit.dm.searchItem;
import java.util.ArrayList;

public class Response {
    public boolean success = true;
    public ArrayList<searchItem> arr;
    public String errorMes;


    public Response() {
    }
}
