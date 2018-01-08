package com.heepie.helpingmemorizingapp.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kr.co.heepie.helpingmemorizingapp.R;
import kr.co.heepie.helpingmemorizingapp.databinding.ViewMainBinding;

public class MainActivity extends AppCompatActivity {
    private ViewMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding();
    }

   private void binding() {
       binding = DataBindingUtil.setContentView(this, R.layout.view_main, null);
   }
}
