//Nir Ben Dror 312495492
//Roman Kaplan 316708361

package com.hit.service;
import com.hit.Dao.DaoFileImpl;
import com.hit.Dao.IDao;
import com.hit.algorithm.*;
import com.hit.dm.searchItem;

import java.util.ArrayList;

public class SearchService {

    IAlgoStringMatching algo;
    DaoFileImpl dataSource;

    public SearchService(IAlgoStringMatching algoType) {

        this.algo = algoType;
        this.dataSource  = new DaoFileImpl("resources/DataBase.txt");
    }

    public boolean addItem(searchItem item)
    {
        if(item==null){
            return false;
        }
        if(!item.isValid()){
            return false;
        }
        boolean suc = dataSource.addItem(item);
        if(!suc)
        {
            return false;
        }
        return true;

    }
    public boolean removeItem(searchItem item)
    {
        if(item==null){
            return false;
        }
        boolean suc = dataSource.removeItem(item);
        if(!suc)
        {
            return false;
        }
        return true;
    }

    public ArrayList<searchItem> serachItem(String key)
    {
        if(key==null || key.isEmpty()) {
            return null;
        }
        ArrayList<searchItem> arr = dataSource.getData();
        ArrayList<searchItem> resList = new ArrayList<searchItem>();

        for (searchItem item :arr)
        {

            ArrayList<Integer> arrTag = algo.search(item.getTag(), key);
            ArrayList<Integer> arrDesc = algo.search(item.getDescription(), key);
            if (arrTag.size()>0|| arrDesc.size()>0)
            {
                resList.add(item);
            }
        }

        return resList;
    }
    public IAlgoStringMatching getAlgo() {
        return algo;
    }

    public void setAlgo(IAlgoStringMatching algo) {
        this.algo = algo;
    }
}
