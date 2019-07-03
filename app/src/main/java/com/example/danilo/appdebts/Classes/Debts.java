package com.example.danilo.appdebts.Classes;

/**
 * Created by aluno on 27/06/19.
 */

public class Debts {
    private long mId;
    public Category mCategory;
    public float mValue;
    public String mPaymentDate;
    public String mPayDate;

    public Debts(){}

//    public Debts(String value){mValue = value;}

    public void setId(long id) {
        mId = id;
    }
    public long getId(long id) {return mId;}

    public void setCategory(Category category) {
        mCategory = category;
    }
    public Category getCategory() {return mCategory;}

    public void setValue(float value) {
        mValue = value;
    }
    public float getValue() {return mValue;}

    public void setPaymentDate(String paymentDate) {
        mPaymentDate = paymentDate;
    }
    public String getPaymentDate() {return mPaymentDate;}

    public void setPayDate(String payDate) {
        mPayDate = payDate;
    }
    public String getPayDate() {return mPayDate;}

}
