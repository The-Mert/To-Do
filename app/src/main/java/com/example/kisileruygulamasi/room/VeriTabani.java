package com.example.kisileruygulamasi.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.kisileruygulamasi.data.entitiy.Kisiler;

@Database(entities = {Kisiler.class},version = 1)
public abstract class VeriTabani extends RoomDatabase {  //Bu class veri tabanına ulaşmak için kullanılacak
    public abstract KisilerDao getKisilerDao();
}
