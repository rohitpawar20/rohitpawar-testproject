package com.rohitpawarrrr.rohitpawar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ViewHolder> {

    private ArrayList<Model> models = new ArrayList<>(  );
    private Context context;

    public ModelAdapter(Context context, ArrayList<Model> models){
       this. models = models;
       this.context = context;
    }


    @NonNull
    @Override
    public ModelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate( R.layout.list_item,viewGroup,false );
        return new ModelAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelAdapter.ViewHolder viewHolder, int i) {

        viewHolder.textView_title.setText( models.get(i).getName() );
        viewHolder.textView_desc.setText( models.get(i).getDesc());
        Picasso.get().load( models.get( i ).getImage()).into( viewHolder.imageView );

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         private ImageView imageView;
         private TextView textView_title, textView_desc;
        public ViewHolder(@NonNull View itemView) {
            super( itemView );

            imageView = (ImageView)itemView.findViewById( R.id.imageView );
            textView_desc = (TextView)itemView.findViewById( R.id.textView_desc );
            textView_title = (TextView)itemView.findViewById( R.id.textView_title );

            //Displays the description text in toast message..
            itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText( itemView.getContext(),textView_desc.getText().toString(),Toast.LENGTH_SHORT ).show();
                }
            } );


        }
    }
}
