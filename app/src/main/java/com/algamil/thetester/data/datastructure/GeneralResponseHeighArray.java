package com.algamil.thetester.data.datastructure;

import com.algamil.thetester.data.models.GeneralData.GeneralResponse;
import com.algamil.thetester.data.models.GeneralData.GeneralResponseData;

import java.util.List;

public class GeneralResponseHeighArray {

    private GeneralResponse[] arrgeneralResponse;
    private int nElems;

    public GeneralResponseHeighArray(int max)
    {
        arrgeneralResponse = new GeneralResponse[max];
        nElems = 0;
    }

    public boolean find (GeneralResponse SearchKey)
    {
        int j;
        for(j = 0;j<nElems;j++)
            if(arrgeneralResponse[j] == SearchKey)
            {
                break;
            }

        if(j == nElems)
            return  false;
        else
            return true;
    }

    public void insert(GeneralResponse value)
    {
        arrgeneralResponse[nElems] = value;
        nElems++;
    }

    public boolean delete(GeneralResponse value)
    {
        int j;
        for(j = 0;j<nElems;j++)
            if(value == arrgeneralResponse[j])
                break;
        if(j == nElems)
            return false;
        else
        {
            for(int k = j;k<nElems;k++)
                arrgeneralResponse[k] = arrgeneralResponse[k+1];
            nElems--;
            return true;
        }
    }

    public void getdatafromLsit(List<GeneralResponseData> generalResponse)
    {
        arrgeneralResponse = generalResponse.toArray(new GeneralResponse[generalResponse.size()]);
    }

    public String[] getTeacheIds()
    {
        String id[] = null;
        for (int i = 0;i<nElems;i++)
        {
            id[i] = arrgeneralResponse[i].getTescheId();
        }
        return id;
    }

    public GeneralResponseData[] getDatas() {
        GeneralResponseData datas[] = null;
        for (int i = 0; i < nElems; i++) {
            datas = arrgeneralResponse[i].getData().toArray(new GeneralResponseData[arrgeneralResponse[i].getData().size()]);
        }
        return datas;
    }

}
