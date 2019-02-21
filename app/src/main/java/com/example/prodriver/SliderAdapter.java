package com.example.prodriver;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    //Variables needed

    Context context;
    LayoutInflater layoutInflater;
    ImageView mImageView;
    LinearLayout mLinearLayout;
    TextView mTitleTextView;

    //default constructor
    public SliderAdapter(Context context) {
        this.context = context;
    }

    //Create arrays to hold data to be displayed in the view
    /*In This case we will define three arrays*/

    public int[] imagesArray = {
            R.drawable.ic_android, R.drawable.ic_code,
            R.drawable.ic_format, R.drawable.ic_grain
    };

    /*Titles Array*/
    public String[] titleArray = {
            "Live WallPapers", "StaticWallPapers", "AnimatedWallPapers", "LovePortions"
    };

    /*DescriptionArray*/
    public String[] descriptionArray = {"Live wall papers description goes here", "Static wallpapers that spares your Ram",
            "Animated wallpapers to ensureSmartLook", "Love Wallpapers to foster your esteem"};

    /*BAckgroundColorArray*/
    public int[] backgroundArray = {
            Color.rgb(125, 23, 58), Color.rgb(125, 23, 158),
            Color.rgb(123, 152, 58), Color.rgb(125, 2, 78)
    };


    @Override
    public int getCount() {
        //return TitleArray Length
        return titleArray.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        //return View -- > Object
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        /*Inflate your slide.xml file in activity_main.xml*/
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        /*Create aview to inflate*/
        View view = layoutInflater.inflate(R.layout.slider,container,false);

        /*Initialize all our variables*/
        LinearLayout mLinearLayout = (LinearLayout)view.findViewById(R.id.linearLayout);
        ImageView mImageView = (ImageView) view.findViewById(R.id.imageView);
        TextView mTitleTextView = (TextView) view.findViewById(R.id.textViewTiltle);
        TextView mDescriptionTextView = (TextView) view.findViewById(R.id.textViewDescription);

        /*Set values to Our slide*/
        mLinearLayout.setBackgroundColor(backgroundArray[position]);
        mImageView.setImageResource(imagesArray[position]);
        mTitleTextView.setText(titleArray[position]);
        mDescriptionTextView.setText(descriptionArray[position]);

        container.addView(view);
            /*ReturnView*/
        return view;
    }
}
