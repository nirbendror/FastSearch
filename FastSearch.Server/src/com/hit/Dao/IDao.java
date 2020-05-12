package com.hit.Dao;

import com.hit.dm.searchItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface IDao {

    ArrayList<searchItem> getData();
    boolean addItem(searchItem item);
    boolean removeItem(searchItem item);

}
