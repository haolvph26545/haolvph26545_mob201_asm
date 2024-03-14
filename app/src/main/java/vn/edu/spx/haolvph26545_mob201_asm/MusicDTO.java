package vn.edu.spx.haolvph26545_mob201_asm;

import android.util.Log;

public class MusicDTO {
    String name;
    String file_path;
    public String toString(){
        Log.d("zzzzzz", "toString: file path " + file_path);
        return  name;
    }
}
