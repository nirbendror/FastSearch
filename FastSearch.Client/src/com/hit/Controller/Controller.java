package com.hit.Controller;

import com.hit.Client.Messages.Request;
import com.hit.Client.Messages.Response;
import com.hit.dm.FastSearchModel;
import com.hit.view.MainView;
import com.hit.view.MainViewActionListener;

import java.util.Observable;

public class Controller implements ControllerFastSearch {

   private FastSearchModel model;
   private MainView view ;
   private Response response;
   MainView articleView;


    public Controller(FastSearchModel model, MainView view) {
        this.model = model;
        this.view = view;
        view.getListener().addObserver(this);
    }

    public FastSearchModel getModel() {
        return model;
    }

    public MainView getView() {
        return view;
    }

    public void update(Observable o, Object arg) {

        String action ="search";
        if ( o instanceof MainViewActionListener)
        {
            long startTime   = System.currentTimeMillis();

            response = model.sendRequest((Request)arg);

            long endTime   = System.currentTimeMillis();

            long totalTime = (endTime - startTime);

            if(response.success)
            {
                view.UpdateUIData(response,totalTime);
            }
            else
            {

                //view.ShowError(response.errorMes);

            }

        }
    }


}
