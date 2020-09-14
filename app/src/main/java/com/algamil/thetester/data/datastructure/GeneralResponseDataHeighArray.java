package com.algamil.thetester.data.datastructure;


import android.util.Log;

import com.algamil.thetester.data.models.GeneralData.GeneralResponseData;

import java.util.List;

public class GeneralResponseDataHeighArray {

    private GeneralResponseData[] arrgeneralResponseData;
    private int nElems;

    public GeneralResponseDataHeighArray(int max)
    {
        arrgeneralResponseData = new GeneralResponseData[max];
        nElems = 0;
    }

    public boolean find (GeneralResponseData SearchKey)
    {
        int j;
        for(j = 0;j<nElems;j++)
            if(arrgeneralResponseData[j] == SearchKey)
            {
                break;
            }

        if(j == nElems)
            return  false;
        else
            return true;
    }

    public void insert(GeneralResponseData value)
    {
        arrgeneralResponseData[nElems] = value;
        nElems++;
    }

    public boolean delete(GeneralResponseData value)
    {
        int j;
        for(j = 0;j<nElems;j++)
            if(value == arrgeneralResponseData[j])
                break;
        if(j == nElems)
            return false;
        else
        {
            for(int k = j;k<nElems;k++)
                arrgeneralResponseData[k] = arrgeneralResponseData[k+1];
            nElems--;
            return true;
        }
    }

    public String[] getIds()
    {
        String id[] = new String[nElems];
        for (int i = 0;i<nElems;i++)
        {
            id[i] = arrgeneralResponseData[i].getId();
        }
        return id;
    }

    public String[] getnames()
    {
        String names[] = new String[nElems];
        for (int i = 0;i<nElems;i++)
        {
            names[i] = arrgeneralResponseData[i].getName();
        }
        return names;
    }

    public String[] getSubjectsNames()
    {
        String subjectsNames[] = new String[nElems];
        for (int i = 0;i<nElems;i++)
        {
            subjectsNames[i] = arrgeneralResponseData[i].getSubjectName();
            Log.d("name is :   ",subjectsNames[i]);
        }
        return subjectsNames;
    }

    public String[] getSubjectsIds()
    {
        String subjectsId[] = new String[nElems];
        for (int i = 0;i<nElems;i++)
        {
            subjectsId[i] = arrgeneralResponseData[i].getId();
        }
        return subjectsId;
    }

    public String[] getEmails()
    {
        String emails[] = new String[nElems];
        for (int i = 0;i<nElems;i++)
        {
            emails[i] = arrgeneralResponseData[i].getEmail();
        }
        return emails;
    }

    public String[] getPhones()
    {
        String phones[] = new String[nElems];
        for (int i = 0;i<nElems;i++)
        {
            phones[i] = arrgeneralResponseData[i].getPhone();
        }
        return phones;
    }


    public String[] getTecherId()
    {
        String teacher_id[] = new String[nElems];
        for (int i = 0;i<nElems;i++)
        {
            teacher_id[i] = arrgeneralResponseData[i].getTeachersId();
        }
        return teacher_id;
    }

    public GeneralResponseData[] getArrgeneralResponseData() {
        return arrgeneralResponseData;
    }

    public void setArrgeneralResponseData(GeneralResponseData[] arrgeneralResponseData) {
        this.arrgeneralResponseData = arrgeneralResponseData;
    }

    public int getnElems() {
        return nElems;
    }

    public void setnElems(int nElems) {
        this.nElems = nElems;
    }
}
