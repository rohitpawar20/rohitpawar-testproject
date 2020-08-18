package com.rohitpawarrrr.rohitpawar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Activity_displayContents extends AppCompatActivity {
    ArrayList <Model> models = new ArrayList<>(  );
    private ModelAdapter modelAdapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_display_contents );
        setTitle( "The Display - Rohit Pawar" ); //Title of an activity.

        recyclerView = (RecyclerView)findViewById( R.id.recyclerView ) ;
        recyclerView.setLayoutManager( new LinearLayoutManager(this) );

        getResponse();
    }

    public void getResponse() {
         Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( "https://rohitpawar20.github.io/" )
                 .addConverterFactory( GsonConverterFactory.create() )
                 .build();

         RequestInterface requestInterface = retrofit.create(RequestInterface.class);
         Call<List<Model>> call = requestInterface.getJson();

         call.enqueue( new Callback<List<Model>>() {
             @Override
             public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                 models = new ArrayList<>( response.body() );
                 modelAdapter = new ModelAdapter( Activity_displayContents.this, models);
                 recyclerView.setAdapter( modelAdapter );
                 Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
             }

             @Override
             public void onFailure(Call<List<Model>> call, Throwable t) {
                 Toast.makeText( getApplicationContext(),"Failed",Toast.LENGTH_SHORT ).show();

             }
         } );
    }
}