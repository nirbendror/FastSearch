package com.hit;

import com.hit.Controller.Controller;
import com.hit.dm.FastSearchModel;
import com.hit.view.MainView;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException
    {
        MainView view = new MainView();
        FastSearchModel model=new FastSearchModel();
        Controller controller=new Controller(model,view);
        model.addObserver(controller);


    }
}