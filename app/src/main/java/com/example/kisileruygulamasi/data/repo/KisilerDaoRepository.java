package com.example.kisileruygulamasi.data.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.kisileruygulamasi.data.entitiy.Kisiler;
import com.example.kisileruygulamasi.room.KisilerDao;


import java.util.List;


import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class KisilerDaoRepository {
    public MutableLiveData<List<Kisiler>> kisilerListesi = new MutableLiveData<>();

    private KisilerDao kdao;

    public KisilerDaoRepository(KisilerDao kdao){
        this.kdao=kdao;
    }

    public void kaydet(String kisi_ad){ //KİSİKayit
        Kisiler yeniKisi = new Kisiler(0,kisi_ad);
        kdao.kaydet(yeniKisi).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }

    public void guncelle(int kisi_id,String kisi_ad ){  //KisiDetay
        Kisiler guncellenen = new Kisiler(kisi_id,kisi_ad);
        kdao.guncelle(guncellenen).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void ara(String aramaKelimesi){ //ARA
        kdao.ara(aramaKelimesi).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Kisiler>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(List<Kisiler> kisilers) {
                        kisilerListesi.setValue(kisilers);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void sil(int kisi_id){
        Kisiler silinen = new Kisiler(kisi_id,"");
        kdao.sil(silinen).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        kisileriYukle();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }

    public void kisileriYukle(){

        kdao.kisileriYukle().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Kisiler>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(List<Kisiler> kisilers) {
                         kisilerListesi.setValue(kisilers);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });



    }
}
