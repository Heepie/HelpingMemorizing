package com.heepie.helpingmemorizingapp.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import kr.co.heepie.helpingmemorizingapp.BR;
import kr.co.heepie.helpingmemorizingapp.R;
import kr.co.heepie.helpingmemorizingapp.databinding.ViewMainBinding;

public class MainActivity extends AppCompatActivity {
    private ViewMainBinding binding;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding();
    }

   private void binding() {
       binding = DataBindingUtil.setContentView(this, R.layout.view_main, null);
       binding.setVariable(BR.view, this);
   }

   public void onClickedMenu(View v) {
        binding.drawerLayout.openDrawer(binding.includedView.navigationMenu);
   }

   View targetView;
   public void onClickedFunc(View v) {
        switch (v.getId()) {
           case R.id.check_folder:     intent = new Intent(this, CheckFolderActivity.class);   break;
           case R.id.test:             intent = new Intent(this, TestActivity.class);          break;
           case R.id.create_folder:    intent = new Intent(this, CreateFolderActivity.class);  break;
           case R.id.create_card:      intent = new Intent(this, CreateCardActivity.class);    break;
        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            switch (v.getId()) {
                case R.id.check_folder:     targetView = binding.checkFolder;   break;
                case R.id.test:             targetView = binding.test;          break;
                case R.id.create_folder:    targetView = binding.createFolder;  break;
                case R.id.create_card:      targetView = binding.createCard;    break;
            }
            Pair<View, String> pair1 = Pair.create(targetView, targetView.getTransitionName());

            ActivityOptionsCompat transitionActivityOptions
                    = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, pair1);
            startActivity(intent, transitionActivityOptions.toBundle());

        } else {
            startActivity(intent);
        }
   }
}
