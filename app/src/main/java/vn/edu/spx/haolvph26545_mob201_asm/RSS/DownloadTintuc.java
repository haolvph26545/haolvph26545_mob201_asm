package vn.edu.spx.haolvph26545_mob201_asm.RSS;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import vn.edu.spx.haolvph26545_mob201_asm.DTO.TinTucDTO;
import vn.edu.spx.haolvph26545_mob201_asm.MainActivity;
import vn.edu.spx.haolvph26545_mob201_asm.R;
import vn.edu.spx.haolvph26545_mob201_asm.WebviewActivity;
import vn.edu.spx.haolvph26545_mob201_asm.adapter.TinTucAdapter;

public class DownloadTintuc extends AsyncTask<String,Void, List<TinTucDTO> > {

        MainActivity activity = null;
        public  DownloadTintuc(MainActivity activity){
            this.activity = activity;
        }
        TinTucLoader loader = new TinTucLoader();
        List<TinTucDTO> list = new ArrayList<TinTucDTO>();
        @Override
        protected List<TinTucDTO> doInBackground(String... strings) {



            // tạo url Connection để tải RSS
            String urlRss = strings[0];

            try {
                URL url = new URL(urlRss);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();
                if(urlConnection.getResponseCode() ==200){
                    // kết nối thành công thì mới lấy luồng dữ liệu
                    InputStream inputStream = urlConnection.getInputStream();
                    list = loader.getTinTucList( inputStream );

                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return list;
        }

        @Override
        protected void onPostExecute(List<TinTucDTO> tinTucs) {
            super.onPostExecute(tinTucs);

            Log.d("zzzzz", "onPostExecute: số lượng bài viết = " + tinTucs.size());
            for(int i = 0; i< tinTucs.size(); i++){
                Log.d("zzzzz", "Tiêu đề bài viết:  " + tinTucs.get(i).getTitle()  );
                Log.d("zzzzz", "Nội Dung:  "+ tinTucs.get(i).getDescription() );
                Log.d("zzzzz", "Link: "+tinTucs.get(i).getLink());
            }


            ListView lv_ds = activity.findViewById(R.id.lv_ds);

            TinTucAdapter adapter = new TinTucAdapter(tinTucs, activity.getBaseContext(), new TinTucAdapter.onclicktintuc() {
                @Override
                public void hihi(TinTucDTO tinTucDTO) {
                    Intent intent = new Intent(activity.getApplicationContext(), WebviewActivity.class);

                    intent.putExtra("link",tinTucDTO.getLink());

                    activity.startActivity(intent);

                }
            });


            lv_ds.setAdapter(adapter);



//
//            TinTucLoader tinTucLoader = new TinTucLoader();
//
//            ArrayAdapter<TinTucDTO> adapter = new ArrayAdapter<TinTucDTO>(this,
//                    android.R.layout.simple_list_item_1,(InputStream) tinTucs);

            // đổ lên listView thì viết code ở đây
            // ListView lv = activity.findViewById(R.id.lv01);
            // làm tiếp với adapter....


        /*
        quay sang activity viết code thực thi như sau:
         String urlRss = "https://vnexpress.net/rss/cuoi.rss";

        DownloadTinTuc downloadTinTuc = new DownloadTinTuc(MainActivity.this);
        downloadTinTuc.execute(urlRss );
         */


        }


}
