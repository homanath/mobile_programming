package com.example.listviewwithdatabaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper{
    public DbHelper(@Nullable Context context) {
        super(context,"ProductDb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table ProductList(pCode integer primary key AUTOINCREMENT, pName text not null unique, quantity integer not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table if exists productLit");
        onCreate(db);
    }
    public ArrayList<Product> getProduct()
    {
        ArrayList<Product> pList= new ArrayList<>();
        SQLiteDatabase db= getReadableDatabase();
        Cursor c=db.rawQuery("Select * from productLit",null);
        while(c.moveToNext()){
            Product p= new Product();
            p.setProductCode(c.getInt(0));
            p.setProductName(c.getString(1));
            p.setQuantity(c.getInt(2));
            pList.add(p);
        }
        return pList;
    }
    public boolean addProduct(Product p){
        SQLiteDatabase db= getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("pname",p.getProductName());
        values.put("quantity",p.getQuantity());
        long id=db.insert("ProductList",null,values);
        return id>0;
    }
    public boolean updateProduct(Product p){
        SQLiteDatabase db= getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("pname",p.getProductName());
        values.put("quantity",p.getQuantity());
        int count= db.update("ProductList",values,"pCode=?",new String[]{String.valueOf(p.getProductCode())});
        return count==1;
    }
    public boolean removeProduct(int pCode) {
        SQLiteDatabase db = getWritableDatabase();
        int count = db.delete("ProductList", "pCode=?", new String[]{String.valueOf(pCode)});
        return count == 1;
    }
}
