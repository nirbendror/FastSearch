package com.hit.Dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hit.dm.searchItem;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;


public class DaoFileImpl implements IDao {

    String pathToSearchDB;


    public DaoFileImpl(String pathToSearchDB) {

        this.pathToSearchDB = pathToSearchDB;
    }

    @Override
    public ArrayList<searchItem> getData() {

        ArrayList<searchItem> resList = new ArrayList<searchItem>();
        if (pathToSearchDB == null) {
            return resList;
        }

        Gson json = new Gson();
        try (Reader reader = new FileReader(pathToSearchDB)) {

            Type listType = new TypeToken<ArrayList<searchItem>>() {}.getType();

            resList = json.fromJson(reader, listType);

        } catch (IOException e) {
            System.out.println("Failed to retrieve Data, Please verify File availability ");
            e.printStackTrace();
            return null;
        }

        return resList;
    }

    @Override
    public boolean addItem(searchItem item) {
        if (pathToSearchDB == null) {
            return false;
        }
        ArrayList<searchItem> searchItemList = getData();

        if (searchItemList == null) {
            return false;
        }

        searchItemList.add(item);

        try (Writer writer = new FileWriter(pathToSearchDB)) {

            Gson json = new Gson();

            writer.write(json.toJson(searchItemList));

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean removeItem(searchItem item) {
        if (pathToSearchDB == null) {
            return false;
        }
        ArrayList<searchItem> searchItemList = getData();

        if (!searchItemList.remove(item)) {
            return false;
        }

        try (Writer writer = new FileWriter(pathToSearchDB)) {

            Gson json = new Gson();

            writer.write(json.toJson(searchItemList));

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

}
