package ru.mirea.vorobevavi.mireaproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ru.mirea.vorobevavi.mireaproject.databinding.FragmentNavWorkBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link nav_work#newInstance} factory method to
 * create an instance of this fragment.
 */
public class nav_work extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private FragmentNavWorkBinding binding;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public nav_work() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WorkerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static nav_work newInstance(String param1, String param2) {
        nav_work fragment = new nav_work();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(BackWorker.class)
                .build();

        WorkManager.getInstance(getContext()).enqueue(workRequest);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentNavWorkBinding.inflate(inflater, container, false);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { OnStartTaskButtonClicked(view); }
        });
        return binding.getRoot();

    }
    private void OnStartTaskButtonClicked(View v) {
        final OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(BackWorker.class).build();
        WorkManager.getInstance(requireContext()).enqueue(workRequest);
    }
}