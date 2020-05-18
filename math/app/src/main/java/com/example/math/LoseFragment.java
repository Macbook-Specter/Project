package com.example.math;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.math.databinding.FragmentLoseBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoseFragment extends Fragment {

    public LoseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MyViewModal myViewModal;
        myViewModal = new ViewModelProvider(this, new SavedStateViewModelFactory(requireActivity().getApplication(), this)).get(MyViewModal.class);
        FragmentLoseBinding binding;
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_lose,container,false);
        binding.setData(myViewModal);
        binding.setLifecycleOwner(requireActivity());
        binding.button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Navigation.findNavController(v).navigate(R.id.action_loseFragment_to_titlekFragment);
            }
        });

        return binding.getRoot();
        // Inflate the layout for this fragment
    }
}
