package net.melove.demo.OO.model;

import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Model {
    private Context mContext;
    private ExecutorService executors = Executors.newCachedThreadPool();
    private static Model model=new Model();
    private Model(){

    }
    public static Model getInstance(){
        return model;
    }
    public void init(Context context){
        mContext=context;
    }
    public ExecutorService getGlobalThreadPool(){
        return executors;
    }
}
