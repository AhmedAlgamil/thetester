package com.example.thetester.data.local;

import android.app.Activity;

import com.example.thetester.data.models.GeneralData.GeneralResponseData;

import java.util.ArrayList;
import java.util.List;

public class HelperMethodSaverAndGetter {

    public static TinyDB tinydb;

    public static void saveStringData(Activity activity , String key, String value)
    {
        tinydb = new TinyDB(activity);
        tinydb.putString(key,value);
    }
    public static void saveObjectData(Activity activity , String key, Object value)
    {
        tinydb = new TinyDB(activity);
        tinydb.putObject(key,value);
    }
    public static void saveBooleanData(Activity activity , String key, boolean value)
    {
        tinydb = new TinyDB(activity);
        tinydb.putBoolean(key,value);
    }
    public static void saveIntegerData(Activity activity , String key, int value)
    {
        tinydb = new TinyDB(activity);
        tinydb.putInt(key,value);
    }
    public static void saveListStringData(Activity activity , String key, ArrayList<String> value)
    {
        tinydb = new TinyDB(activity);
        tinydb.putListString(key,value);
    }
    public static void saveListBooleanData(Activity activity , String key, ArrayList<Boolean> value)
    {
        tinydb = new TinyDB(activity);
        tinydb.putListBoolean(key,value);
    }

    public static void saveListIntegerData(Activity activity , String key, ArrayList<Integer> value)
    {
        tinydb = new TinyDB(activity);
        tinydb.putListInt(key,value);
    }

    public static void saveListDoubleData(Activity activity , String key, ArrayList<Double> value)
    {
        tinydb = new TinyDB(activity);
        tinydb.putListDouble(key,value);
    }

    public static void saveListObjectData(Activity activity , String key, List<GeneralResponseData> value)
    {
        tinydb = new TinyDB(activity);
        tinydb.putListGeneralResponse(key,value);
    }

    public static String GetStringData(Activity activity , String key)
    {
        tinydb = new TinyDB(activity);
        return tinydb.getString(key);
    }
    public static Object getObjectData(Activity activity , String key)
    {
        tinydb = new TinyDB(activity);
        return tinydb.getObject(key,Object.class);
    }
    public static boolean saveBooleanData(Activity activity , String key)
    {
        tinydb = new TinyDB(activity);
        return tinydb.getBoolean(key);
    }
    public static ArrayList<Integer> saveIntegerData(Activity activity , String key)
    {
        tinydb = new TinyDB(activity);
        return tinydb.getListInt(key);
    }
    public static ArrayList<String> getListStringData(Activity activity , String key)
    {
        tinydb = new TinyDB(activity);
        return tinydb.getListString(key);
    }
    public static ArrayList<Boolean> getListBooleanData(Activity activity , String key)
    {
        tinydb = new TinyDB(activity);
        return tinydb.getListBoolean(key);
    }

    public static ArrayList<Integer> getListIntegerData(Activity activity , String key)
    {
        tinydb = new TinyDB(activity);
        return tinydb.getListInt(key);
    }

    public static ArrayList<Double> getListDoubleData(Activity activity , String key)
    {
        tinydb = new TinyDB(activity);
        return tinydb.getListDouble(key);
    }


    public static ArrayList<Object> getListObjectData(Activity activity , String key)
    {
        tinydb = new TinyDB(activity);
        return tinydb.getListObject(key,Object.class);
    }

}
