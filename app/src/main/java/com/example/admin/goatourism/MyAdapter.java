package com.example.admin.goatourism;

/**
 * Created by Admin on 16-Jan-20.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
private List<ListData>listData;
    Context context;
    public interface OnItemClickListener{

        void onItemClick(int position);
    }

     private OnItemClickListener mListener;


    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }

public MyAdapter(List<ListData> listData, Context context) {
        this.listData = listData;
        this.context=context;
        }

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_monument_list,parent,false);
        return new ViewHolder(view,mListener);
        }

@Override
public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListData ld=listData.get(position);
    String url=ld.getImage();
    holder.txtname.setText(ld.getName());

    Picasso.with(context).load(url).into(holder.img);





}

@Override
public int getItemCount() {
        return listData.size();
        }



    public class ViewHolder extends RecyclerView.ViewHolder{
    private TextView txtid,txtname,txtmovie;
    ImageView img;
    public ViewHolder(View itemView, final OnItemClickListener listener) {
        super(itemView);
        txtname=(TextView)itemView.findViewById(R.id.nametxt);
         img=(ImageView)itemView.findViewById(R.id.img);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener!= null)
                {
                    int position=getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        listener.onItemClick(position);
                    }
                }
            }
        });

    }


}
}

