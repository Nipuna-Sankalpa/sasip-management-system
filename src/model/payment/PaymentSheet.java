/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.payment;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Yellow Flash
 */
public class PaymentSheet <E> {

    private ArrayList<E> payList;
    private Timestamp timeStamp;

    public PaymentSheet() {
        payList = new ArrayList<>();
        timeStamp = new Timestamp(System.currentTimeMillis());
    }

    public void addPayments(E mfp) {
        payList.add(mfp);
    }

    public E retrievepayments(int index) {
        return payList.get(index);
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public ArrayList<E> getPayList() {
        return payList;
    }
    public int getPayListSize() {
        return payList.size();
    }


    public void setPayList(ArrayList<E> payList) {
        this.payList = payList;
    }

    public void clearSheet() {
        payList.removeAll(payList);
    }

}
