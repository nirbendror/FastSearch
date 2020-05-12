package com.hit.Test;

import com.hit.dm.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class DaoFileImplTest {

    ArrayList<searchItem> serachItems;
    com.hit.Dao.DaoFileImpl daoFile = new com.hit.Dao.DaoFileImpl("resources/DataBaseTest.txt");

    @Test
    void getData() {
        serachItems = daoFile.getData();
        assertEquals(56,serachItems.size());
    }
    @Test
    void addItem() {
        searchItem item = new searchItem();
        item.setTag("BBC Sport");
        item.setDescription("Breaking news & live sports coverage including results, video, audio and analysis on ... Rugby Union, Rugby League, Golf, Tennis and all the main world sports, plus major events ... The BBC is not responsible for the content of external sites");
        item.setLink("https://www.bbc.co.uk/sport");
        boolean suc = daoFile.addItem(item);
        assertEquals(true,suc);
    }
   @Test
        void removeItem() {
        searchItem item = new searchItem();
       item.setTag("BBC Sport");
       item.setDescription("Breaking news & live sports coverage including results, video, audio and analysis on ... Rugby Union, Rugby League, Golf, Tennis and all the main world sports, plus major events ... The BBC is not responsible for the content of external sites");
       item.setLink("https://www.bbc.co.uk/sport");
        boolean suc1 = daoFile.removeItem(item);
        assertEquals(true,suc1);


    }



}