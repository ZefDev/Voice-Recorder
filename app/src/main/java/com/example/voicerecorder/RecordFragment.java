package com.example.voicerecorder;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecordFragment extends Fragment implements View.OnClickListener{

    private NavController navController;
    private ImageButton listBtn;
    private ImageButton recordBtn;
    private boolean isRecording = false;

    public RecordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_record, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        listBtn = view.findViewById(R.id.record_list_btn);
        listBtn.setOnClickListener(this);
        recordBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
       switch (v.getId()){
           case R.id.record_list_btn:
               navController.navigate(R.id.action_recordFragment_to_audioListFragment);
               break;
           case R.id.record_btn:
                if (isRecording){
                    recordBtn.setImageDrawable(getResources().getDrawable(R.drawable.record_btn_stopped));
                    isRecording = false;
                }else {
                    recordBtn.setImageDrawable(getResources().getDrawable(R.drawable.record_btn_recording));
                    isRecording=true;
                }
               break;
       }
    }
}
