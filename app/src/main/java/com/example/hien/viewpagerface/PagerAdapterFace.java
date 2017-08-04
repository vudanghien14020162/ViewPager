package com.example.hien.viewpagerface;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hien on 8/4/17.
 */

public class PagerAdapterFace extends PagerAdapter{

    private IFace mIF;

    private Context mContext;

    public PagerAdapterFace(IFace mIF, Context mContext) {
        this.mIF = mIF;
        this.mContext = mContext;
    }


    @Override
    public int getCount() {
        return mIF.getSize();
    }

    //kiem tra xem objecdc tra ve co phai view k de hien thi
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View) object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater inflater = LayoutInflater.from(container.getContext());

        View view = inflater.inflate(R.layout.item_face, container, false);

        ItemFace itemFace = mIF.getItemFace(position);

        TextView tvName = view.findViewById(R.id.tv_face);
        tvName.setText(itemFace.getTvFace());

        ImageView imgFace = view.findViewById(R.id.img_face);

        imgFace.setImageResource(itemFace.getIdImg());

        Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.translate_vp);
        imgFace.startAnimation(animation);
        tvName.startAnimation(animation);
        container.addView(view);
        return view;
    }

    public interface IFace{
        int getSize();
        ItemFace getItemFace(int position);
    }
}
