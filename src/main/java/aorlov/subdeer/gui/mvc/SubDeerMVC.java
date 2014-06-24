package aorlov.subdeer.gui.mvc;

import aorlov.subdeer.test_gui.Controller;

/**
 * Created with IntelliJ IDEA.
 * User: Mouse
 * Date: 25.06.14
 * Time: 2:01
 * To change this template use File | Settings | File Templates.
 */
public class SubDeerMVC {

    public SubDeerMVC(){
        SubListModel myModel 	= new SubListModel();
        MainScreenView myView 	= new MainScreenView();

        myModel.addObserver(myView);

        Controller myController = new Controller();
        myController.addModel(myModel);
        myController.addView(myView);
        //here welcome words
        myController.initModel(start_value);

        //tell View about Controller
        myView.addController(myController);

    }
}
