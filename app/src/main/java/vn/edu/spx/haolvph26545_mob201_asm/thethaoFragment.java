package vn.edu.spx.haolvph26545_mob201_asm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import vn.edu.spx.haolvph26545_mob201_asm.RSS.DownloadTintuc;

public class thethaoFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.thethao_frag,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        String urlRss = "https://vnexpress.net/rss/the-thao.rss";


        DownloadTintuc downloadTinTuc = new DownloadTintuc((MainActivity) getActivity());
        downloadTinTuc.execute(urlRss );
    }
    public static thethaoFragment newInstance() {

        thethaoFragment fragment = new thethaoFragment();

        return fragment;
    }
}
