package com.example.kisileruygulamasi.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kisileruygulamasi.R;
import com.example.kisileruygulamasi.data.entitiy.Kisiler;
import com.example.kisileruygulamasi.data.repo.KisilerDaoRepository;
import com.example.kisileruygulamasi.databinding.FragmentKisiDetayBinding;
import com.example.kisileruygulamasi.ui.adapter.KisilerAdapter;
import com.example.kisileruygulamasi.ui.viewmodel.KisiDetayViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class KisiDetayFragment extends Fragment {
    private FragmentKisiDetayBinding binding;

    private KisiDetayViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentKisiDetayBinding.inflate(getLayoutInflater());

        KisiDetayFragmentArgs bundle = KisiDetayFragmentArgs.fromBundle(getArguments());
        Kisiler gelenKisi = bundle.getKisi();

        binding.editTextContent.setText(gelenKisi.getKisi_ad());


        binding.butonGuncelle.setOnClickListener(v->{
            String kisi_ad = binding.editTextContent.getText().toString();
            viewModel.guncelle(gelenKisi.getKisi_id(),kisi_ad);
            Navigation.findNavController(v).navigate(R.id.finshPath);
        });

        return binding.getRoot();
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(KisiDetayViewModel.class);
    }
}