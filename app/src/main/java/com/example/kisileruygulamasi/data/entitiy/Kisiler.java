package com.example.kisileruygulamasi.data.entitiy;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "todo")
public class Kisiler implements Serializable{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "todo_id")
    @NonNull
    private int kisi_id;
    @ColumnInfo(name = "todo_content")
    @NonNull
    private String kisi_ad;


    public Kisiler() {
    }

    public Kisiler(int kisi_id, @NonNull String kisi_ad) {
        this.kisi_id = kisi_id;
        this.kisi_ad = kisi_ad;

    }

    public int getKisi_id() {
        return kisi_id;
    }

    public void setKisi_id(int kisi_id) {
        this.kisi_id = kisi_id;
    }

    @NonNull
    public String getKisi_ad() {
        return kisi_ad;
    }

    public void setKisi_ad(@NonNull String kisi_ad) {
        this.kisi_ad = kisi_ad;
    }



}
