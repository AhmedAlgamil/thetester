package com.algamil.thetester.data.datastructure;

import android.util.Log;

import com.algamil.thetester.data.models.ChooseAns;

public class ChooseAnsHighArray {

    private ChooseAns[] ChooseAnsArr;
    private int nElems;
    private int pos;

    public ChooseAnsHighArray(int max)
    {
        ChooseAnsArr = new ChooseAns[max];
        nElems = 0;
    }

    public boolean find (ChooseAns SearchKey)
    {
        int j;
        for(j = 0;j<nElems;j++)
            if(ChooseAnsArr[j] == SearchKey)
            {
                break;
            }

        if(j == nElems)
            return  false;
        else
            return true;
    }

    public void insert(String question,String correct_ans,String wrong_ans1,String wrong_ans2,String wrong_ans3)
    {
        ChooseAnsArr[nElems] = new ChooseAns(question,correct_ans,wrong_ans1,wrong_ans2,wrong_ans3);
        nElems++;
    }

    public boolean delete(ChooseAns value)
    {
        int j;
        for(j = 0;j<nElems;j++)
            if(value == ChooseAnsArr[j])
                break;
        if(j == nElems)
            return false;
        else
        {
            for(int k = j;k<nElems;k++)
                ChooseAnsArr[k] = ChooseAnsArr[k+1];
            nElems--;
            return true;
        }
    }

    public void display()
    {
        for(int j = 0 ; j < nElems ; j++)
        {
            Log.d("the elementtttttttttt",ChooseAnsArr[j] + " ");
            System.out.println("");
        }
    }

    public String getoneQuestion(int pos)
    {
        return ChooseAnsArr[pos].getQuestion();
    }

    public String getOneCorrectAns(int pos)
    {
        return ChooseAnsArr[pos].getCorrect_ans();
    }

    public String getOneWronge1Ans(int pos)
    {
        return ChooseAnsArr[pos].getWorng1_ans();
    }

    public String getOneWronge2Ans(int pos)
    {
        return ChooseAnsArr[pos].getWorng2_ans();
    }

    public String getOneWronge3Ans(int pos)
    {
        return ChooseAnsArr[pos].getWorng3_ans();
    }

    public ChooseAns getChooseAns(int pos)
    {
        return ChooseAnsArr[pos];
    }

    public String[] getQuestion()
    {
        String id[] = new String[nElems];
        for (int i = 0;i<nElems;i++)
        {
            id[i] = ChooseAnsArr[i].getQuestion();
        }
        return id;
    }

    public String[] getCorrectAns()
    {
        String names[] = new String[nElems];
        for (int i = 0;i<nElems;i++)
        {
            names[i] = ChooseAnsArr[i].getCorrect_ans();
        }
        return names;
    }

    public String[] getWrong1Ans()
    {
        String subjectsNames[] = new String[nElems];
        for (int i = 0;i<nElems;i++)
        {
            subjectsNames[i] = ChooseAnsArr[i].getWorng1_ans();
            Log.d("name is :   ",subjectsNames[i]);
        }
        return subjectsNames;
    }

    public String[] getWrong2Ans()
    {
        String subjectsId[] = new String[nElems];
        for (int i = 0;i<nElems;i++)
        {
            subjectsId[i] = ChooseAnsArr[i].getWorng1_ans();
        }
        return subjectsId;
    }

    public String[] getWrong3Ans()
    {
        String emails[] = new String[nElems];
        for (int i = 0;i<nElems;i++)
        {
            emails[i] = ChooseAnsArr[i].getWorng1_ans();
        }
        return emails;
    }

    public ChooseAns[] getChooseAnsArr() {
        return ChooseAnsArr;
    }

    public void setChooseAnsArr(ChooseAns[] chooseAnsArr) {
        ChooseAnsArr = chooseAnsArr;
    }

    public int getnElems() {
        return nElems;
    }

    public void setnElems(int nElems) {
        this.nElems = nElems;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
