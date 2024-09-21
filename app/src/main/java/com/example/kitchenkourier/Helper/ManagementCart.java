package com.example.kitchenkourier.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.kitchenkourier.Domain.FoodDomain;
import com.example.kitchenkourier.Domain.HotspotDomain;
import com.example.kitchenkourier.Domain.KathiDomain;
import com.example.kitchenkourier.Domain.NonVegKitchenDomain;
import com.example.kitchenkourier.Domain.QuenchDomain;
import com.example.kitchenkourier.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context){
        this.context=context;
        this.tinyDB=new TinyDB(context);
    }
    public void insertFood(FoodDomain item){
        ArrayList<FoodDomain> listFood= getListCart();
        boolean existAlready=false;
        int n=0;
        for(int i=0;i< listFood.size();i++){
            if(listFood.get(i).getTitle().equals(item.getTitle())){
                existAlready=true;
                n=i;
                break;
            }
        }

        if(existAlready){
            listFood.get(n).setNumberInCar(item.getNumberInCar());
        }else{
            listFood.add(item);
        }
        tinyDB.putListObject("CartList",listFood);
        Toast.makeText(context, "Added to Your Cart", Toast.LENGTH_SHORT).show();
    }
    public void insertFood(KathiDomain kathiitem){
        int z=0;
        ArrayList<KathiDomain> listFood= getListCart(z);
        boolean existAlready=false;
        int n=0;
        for(int i=0;i< listFood.size();i++){
            if(listFood.get(i).getTitle().equals(kathiitem.getTitle())){
                existAlready=true;
                n=i;
                break;
            }
        }

        if(existAlready){
            listFood.get(n).setNumberInCar(kathiitem.getNumberInCar());
        }else{
            listFood.add(kathiitem);
        }
        tinyDB.putListObject("CartList",listFood,z);
        Toast.makeText(context, "Added to Your Cart", Toast.LENGTH_SHORT).show();
    }
    public void insertFood(QuenchDomain quenchitem){
        int z=0;
        int y=0;
        ArrayList<QuenchDomain> listFood= getListCart(z,y);
        boolean existAlready=false;
        int n=0;
        for(int i=0;i< listFood.size();i++){
            if(listFood.get(i).getTitle().equals(quenchitem.getTitle())){
                existAlready=true;
                n=i;
                break;
            }
        }

        if(existAlready){
            listFood.get(n).setNumberInCar(quenchitem.getNumberInCar());
        }else{
            listFood.add(quenchitem);
        }
        int tr=0;
        tinyDB.putListObject("CartList",listFood,z,tr);
        Toast.makeText(context, "Added to Your Cart", Toast.LENGTH_SHORT).show();
    }
    public void insertFood(HotspotDomain hotspotitem){
        int z=0;
        int y=0;
        int x=0;
        ArrayList<HotspotDomain> listFood= getListCart(z,y,x);
        boolean existAlready=false;
        int n=0;
        for(int i=0;i< listFood.size();i++){
            if(listFood.get(i).getTitle().equals(hotspotitem.getTitle())){
                existAlready=true;
                n=i;
                break;
            }
        }

        if(existAlready){
            listFood.get(n).setNumberInCar(hotspotitem.getNumberInCar());
        }else{
            listFood.add(hotspotitem);
        }
        int tr=0;
        int ty=0;
        tinyDB.putListObject("CartList",listFood,z,tr,ty);
        Toast.makeText(context, "Added to Your Cart", Toast.LENGTH_SHORT).show();
    }
    public void insertFood(NonVegKitchenDomain kitchenitem){
        int z=0;
        int y=0;
        int x=0;
        int u=0;
        ArrayList<NonVegKitchenDomain> listFood= getListCart(z,y,x,u);
        boolean existAlready=false;
        int n=0;
        for(int i=0;i< listFood.size();i++){
            if(listFood.get(i).getTitle().equals(kitchenitem.getTitle())){
                existAlready=true;
                n=i;
                break;
            }
        }

        if(existAlready){
            listFood.get(n).setNumberInCar(kitchenitem.getNumberInCar());
        }else{
            listFood.add(kitchenitem);
        }
        int tr=0;
        int ty=0;
        int tyr=0;
        tinyDB.putListObject("CartList",listFood,z,tr,ty,tyr);
        Toast.makeText(context, "Added to Your Cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<FoodDomain> getListCart(){
        return tinyDB.getListObject("CartList");
    }
    public ArrayList<KathiDomain> getListCart(int temp3){
        int temp2=0;
        return tinyDB.getListObject("CartList",temp2);
    }
    public ArrayList<QuenchDomain> getListCart(int temp3,int temp4){
        int temp2=0;
        int t=0;
        return tinyDB.getListObject("CartList",temp2,t);
    }
    public ArrayList<HotspotDomain> getListCart(int temp3,int temp4,int temp5){
        int temp2=0;
        int t=0;
        int tr=0;
        return tinyDB.getListObject("CartList",temp2,t,tr);
    }
    public ArrayList<NonVegKitchenDomain> getListCart(int temp3,int temp4,int temp5,int temp6){
        int temp2=0;
        int t=0;
        int tr=0;
        int xtr=0;
        return tinyDB.getListObject("CartList",temp2,t,tr,xtr);
    }

    public void plusNumberFood(ArrayList<FoodDomain>listFood, int position, ChangeNumberItemsListener changeNumberItemsListener){
        listFood.get(position).setNumberInCar(listFood.get(position).getNumberInCar()+1);
        tinyDB.putListObject("CartList",listFood);
        changeNumberItemsListener.changed();
    }
    public void plusNumberFood(ArrayList<KathiDomain>kathifood, int position,int temp, ChangeNumberItemsListener changeNumberItemsListener){
        kathifood.get(position).setNumberInCar(kathifood.get(position).getNumberInCar()+1);
        int x=0;
        tinyDB.putListObject("CartList",kathifood,x);
        changeNumberItemsListener.changed();
    }

    public void minusNumberFood(ArrayList<FoodDomain>listfood, int position, ChangeNumberItemsListener changeNumberItemsListener){
        if(listfood.get(position).getNumberInCar()==1){
            listfood.remove(position);
        }
        else{
            listfood.get(position).setNumberInCar(listfood.get(position).getNumberInCar()-1);
        }
        tinyDB.putListObject("CartList",listfood);
        changeNumberItemsListener.changed();
    }
    public void minusNumberFood(ArrayList<KathiDomain>kathifood, int position,int temp1, ChangeNumberItemsListener changeNumberItemsListener){
        if(kathifood.get(position).getNumberInCar()==1){
            kathifood.remove(position);
        }
        else{
            kathifood.get(position).setNumberInCar(kathifood.get(position).getNumberInCar()-1);
        }
        int x1=0;
        tinyDB.putListObject("CartList",kathifood,x1);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee(){
        ArrayList<FoodDomain> listfood = getListCart();
        double fee=0;
        for(int i=0;i<listfood.size();i++){
            fee=fee+(listfood.get(i).getFee()*listfood.get(i).getNumberInCar());
        }
        return fee;
    }
    public Double getTotalFee(int z){
        int temp4=0;
        ArrayList<KathiDomain> kathifood = getListCart(temp4);
        double fee=0;
        for(int i=0;i<kathifood.size();i++){
            fee=fee+(kathifood.get(i).getFee()*kathifood.get(i).getNumberInCar());
        }
        return fee;
    }



}
