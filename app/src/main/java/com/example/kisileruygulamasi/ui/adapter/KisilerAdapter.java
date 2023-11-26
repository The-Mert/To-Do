package com.example.kisileruygulamasi.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kisileruygulamasi.data.entitiy.Kisiler;
import com.example.kisileruygulamasi.data.repo.KisilerDaoRepository;
import com.example.kisileruygulamasi.databinding.CardTasarimBinding;
import com.example.kisileruygulamasi.ui.fragment.AnasayfaFragment;
import com.example.kisileruygulamasi.ui.fragment.AnasayfaFragmentDirections;
import com.example.kisileruygulamasi.ui.viewmodel.AnasayfaVievModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class KisilerAdapter extends RecyclerView.Adapter<KisilerAdapter.CardTasarimHolder> {

    private List<Kisiler> kisilerListesi;
    private Context mContext;

//    public KisilerDaoRepository krepo = new KisilerDaoRepository();

    private AnasayfaVievModel viewModel;

    public KisilerAdapter(List<Kisiler> kisilerListesi, Context mContext, AnasayfaVievModel viewModel) {
        this.kisilerListesi = kisilerListesi;
        this.mContext = mContext;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public CardTasarimHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //ViewBinding kodlaması burada yapılır.
        CardTasarimBinding binding =
                CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false);
        return new CardTasarimHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimHolder holder, int position) {
        Kisiler kisi = kisilerListesi.get(position);
        CardTasarimBinding t = holder.tasarim;

        t.textViewKisiAd.setText(kisi.getKisi_ad());

        t.cardViewSatir.setOnClickListener(v->{
            AnasayfaFragmentDirections.GecisDetay gecis = AnasayfaFragmentDirections.gecisDetay(kisi);
            Navigation.findNavController(v).navigate(gecis);



        });


        t.imageViewSil.setOnClickListener(v->{
            Snackbar.make(v,kisi.getKisi_ad()+ " silinsin mi?"  ,Snackbar.LENGTH_SHORT)
                    .setAction("Evet", v1->{
                        viewModel.sil(kisi.getKisi_id());
                    })
                    .show();
        });
    }

    @Override
    public int getItemCount() {
        return kisilerListesi.size();
    }



    public class CardTasarimHolder extends RecyclerView.ViewHolder{ //üst classa bağlanmalı
        private CardTasarimBinding tasarim;

        public CardTasarimHolder(CardTasarimBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }  //HOLDER
}
