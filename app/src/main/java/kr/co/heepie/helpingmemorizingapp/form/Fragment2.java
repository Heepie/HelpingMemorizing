package kr.co.heepie.helpingmemorizingapp.form;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.co.heepie.helpingmemorizingapp.R;
import kr.co.heepie.helpingmemorizingapp.ui.MainActivity;

/**
 * Created by Hee_Ju.M on 2017-04-01.
 */

public class Fragment2 extends Fragment {
    private static final String TAG = Fragment2.class.getSimpleName();

    @Override
    public void onAttach(Context context) {
        Log.i(TAG, TAG + " onAttach");
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, TAG + " onCreate");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, TAG + " onCreateView");
        return inflater.inflate(R.layout.fragment2, null);
    }

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        Log.i(TAG, TAG + " onInflate");
        super.onInflate(context, attrs, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.i(TAG, TAG + " onViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i(TAG, TAG + " onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i(TAG, TAG + " onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i(TAG, TAG + " onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i(TAG, TAG + " onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(TAG, TAG + " onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, TAG + " onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, TAG + " onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i(TAG, TAG + " onDetach");
        super.onDetach();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.i(TAG, TAG + " onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }
}
