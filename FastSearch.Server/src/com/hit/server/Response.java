package com.hit.server;
import com.hit.dm.searchItem;
import java.util.ArrayList;
import java.util.List;

public class Response {
    public boolean success = true;
    public ArrayList<searchItem> arr;
    public String errorMes;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMes() {
        return errorMes;
    }

    public void setErrorMes(String errorMes) {
        this.errorMes = errorMes;
    }
}
