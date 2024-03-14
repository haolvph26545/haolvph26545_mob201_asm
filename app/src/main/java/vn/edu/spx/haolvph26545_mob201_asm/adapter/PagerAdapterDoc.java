package vn.edu.spx.haolvph26545_mob201_asm.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vn.edu.spx.haolvph26545_mob201_asm.thethaoFragment;
import vn.edu.spx.haolvph26545_mob201_asm.thoisuFragment;
import vn.edu.spx.haolvph26545_mob201_asm.tinnoibatFragment;

public class PagerAdapterDoc extends FragmentStateAdapter {

    int soluongPage = 3;
    public PagerAdapterDoc(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return  new tinnoibatFragment();
            case 1:
                return new thethaoFragment();
            case 2:
                return new thoisuFragment();

            default:
                return new tinnoibatFragment();
        }
    }

    @Override
    public int getItemCount() {
        return soluongPage;
    }
}