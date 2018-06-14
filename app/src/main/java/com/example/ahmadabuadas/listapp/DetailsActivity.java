package com.example.ahmadabuadas.listapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent in = getIntent();
        int index =in.getIntExtra("com.example.ahmadabuadas.Item_Index",-1);

        if(index> -1){
            int pic = getimg(index);
            ImageView img = (ImageView) findViewById(R.id.imageView);
            scaleImg(img,pic);
        }
    }
    private int getimg(int index){
        switch (index){
            case 0: return R.drawable.peach;
            case 1: return R.drawable.tomato;
            case 2: return R.drawable.squash;
            default: return -1;
        }
    }

    private void  scaleImg (ImageView img, int pic){
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options option = new BitmapFactory.Options();
        option.inJustDecodeBounds =true;
        BitmapFactory.decodeResource(getResources(),pic,option);

        int imgwidth = option.outWidth;
        int screenwidth = option.outHeight;
        if(imgwidth>screenwidth){
            int ratio = Math.round((float) imgwidth /(float) screenwidth  );
            option.inSampleSize = ratio;

            option.inJustDecodeBounds =false;

            Bitmap scaleImg = BitmapFactory.decodeResource(getResources(),pic,option);
            img.setImageBitmap(scaleImg);

        }
    }
}
