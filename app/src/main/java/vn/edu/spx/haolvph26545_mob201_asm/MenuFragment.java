package vn.edu.spx.haolvph26545_mob201_asm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import vn.edu.spx.haolvph26545_mob201_asm.RSS.DownloadTintuc;
import vn.edu.spx.haolvph26545_mob201_asm.adapter.PagerAdapterDoc;

public class MenuFragment extends Fragment {

    PagerAdapterDoc adapter;
    ViewPager2 viewPager2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_frag,container,false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager2 = view.findViewById(R.id.viewPagerDoc);
        adapter = new PagerAdapterDoc(this);

        viewPager2.setAdapter(adapter);
        TabLayout tab = view.findViewById(R.id.tabLayoutDoc);

        TabLayoutMediator mediator = new TabLayoutMediator(tab, viewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        if (position == 0) {
                            tab.setText("Tin Nổi Bật");
                        } else if (position == 1) {
                            tab.setText("Thế Giới");
                        } else if (position == 2) {
                            tab.setText("Thời Sự");
                        } else if (position == 3) {
                            tab.setText("Sức Khỏe");
                        } else if (position==4){
                            tab.setText("Đời Sống");
                        }else if (position==5) {
                            tab.setText("Tin Xem Nhiều");
                        }else {
                            tab.setText("Hài hước");
                        }
                    }
                });
        mediator.attach();
    }
    public static MenuFragment newInstance() {

        MenuFragment fragment = new MenuFragment();

        return fragment;
    }

}
