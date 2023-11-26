package com.example.kisileruygulamasi.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.kisileruygulamasi.data.entitiy.Kisiler;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface KisilerDao {
    @Query("SELECT * FROM todo")
    Single<List<Kisiler>> kisileriYukle();

    @Insert
    Completable kaydet(Kisiler kisi);

    @Update
    Completable guncelle(Kisiler kisi);

    @Delete
    Completable sil(Kisiler kisi);

    @Query("SELECT * FROM todo WHERE todo_content like '%'  || :aramaKelimesi ||'%'")
    Single<List<Kisiler>> ara(String aramaKelimesi);

}
