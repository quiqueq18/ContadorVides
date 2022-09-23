package com.example.contadorvides;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.contadorvides.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private int vida1;
    private int veneno1;
    private int vida2;
    private int veneno2;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);

        reset();

        if(savedInstanceState==null){
            vida1= savedInstanceState.getInt(key"vida1");
            veneno1= savedInstanceState.getInt(key"veneno1");
            vida2= savedInstanceState.getInt(key"vida2");
            veneno2= savedInstanceState.getInt(key"veneno2");
        }

        binding.Vida2a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vida1++;
                vida2--;
                updateViews();
            }
        });
        binding.Vida1a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vida1--;
                vida2++;
                updateViews();
            }
        });
        binding.btnP1VidasMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vida1++;
                updateViews();
            }
        });
        binding.btnP1VidasMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vida1--;
                updateViews();
            }
        });
        binding.btnP2VidasMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vida2++;
                updateViews();
            }
        });
        binding.btnP2VidasMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vida2--;
                updateViews();
            }
        });
        binding.btnP1PMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                veneno1++;
                updateViews();
            }
        });
        binding.btnP1PMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                veneno1--;
                updateViews();
            }
        });
        binding.btnP2PMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                veneno2++;
                updateViews();
            }
        });
        binding.btnP2PMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                veneno2--;
                updateViews();
            }
        });
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private void reset(){
        veneno1=0;
        veneno2=0;
        vida1=20;
        vida2=20;

        updateViews();
    }

    private void updateViews() {
        binding.ValoresP1.setText(String.format(vida1+"/"+veneno1));
        binding.ValoresP2.setText(String.format(vida2+"/"+veneno2));

    }

}