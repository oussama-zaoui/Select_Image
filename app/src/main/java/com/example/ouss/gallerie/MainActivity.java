package com.example.ouss.gallerie;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;
    Uri imageUri;
    public static final int  SELECTED_IMAGE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageView);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getItem();
            }

        });






    }

    public void getItem(){
        Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(intent,SELECTED_IMAGE);
    }


    @Override
    protected void  onActivityResult(int requiste_code,int result_code,Intent intent){
        super.onActivityResult(requiste_code,result_code,intent);
        if(result_code==RESULT_OK && requiste_code==SELECTED_IMAGE){
            imageUri=intent.getData();
            imageView.setImageURI(imageUri);
        }

    }



}
