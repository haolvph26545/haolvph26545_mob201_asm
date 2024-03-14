package vn.edu.spx.haolvph26545_mob201_asm.adapter;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import vn.edu.spx.haolvph26545_mob201_asm.DTO.TinTucDTO;
import vn.edu.spx.haolvph26545_mob201_asm.R;


public class TinTucAdapter extends BaseAdapter {

    List<TinTucDTO> list;
    Context context;
    onclicktintuc onclicktintuc;

    public TinTucAdapter(List<TinTucDTO> list, Context context, onclicktintuc onclicktintuc){
        this.list = list;
        this.context = context;
        this.onclicktintuc = onclicktintuc;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        TinTucDTO tinTucDTO = list.get(position);
        return tinTucDTO;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        if(convertView ==null){
            row = View.inflate(parent.getContext(), R.layout.layout_item,null);
        }else{
            row = convertView;
        }
        TextView tv_td = row.findViewById(R.id.tv_td);
        TextView tv_nd = row.findViewById(R.id.tv_nd);



        TinTucDTO tinTucDTO = list.get( position );
        tv_td.setText(  tinTucDTO.getTitle());
        tv_nd.setText(Html.fromHtml(tinTucDTO.getDescription()));
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclicktintuc.hihi(tinTucDTO);
            }
        });


        return  row;
    }

    public interface onclicktintuc{
         void hihi(TinTucDTO tinTucDTO);


    }
}
