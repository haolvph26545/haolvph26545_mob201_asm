package vn.edu.spx.haolvph26545_mob201_asm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import vn.edu.spx.haolvph26545_mob201_asm.RSS.DownloadTintuc;

public class thoisuFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.thoisu_frag,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        String urlRss = "hhttps://vnexpress.net/rss/thoi-su.rss";


        DownloadTintuc downloadTinTuc = new DownloadTintuc((MainActivity) getActivity());
        downloadTinTuc.execute(urlRss );
    }
    public static thoisuFragment newInstance() {

        thoisuFragment fragment = new thoisuFragment();

        return fragment;
    }
}
