package com.example.hien.viewpagerface;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PagerAdapterFace.IFace, View.OnDragListener, ViewPager.OnPageChangeListener, View.OnTouchListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ViewPager mVp;

    private PagerAdapterFace mAdapter;

    private List<ItemFace> listItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewByIds();

        initData();

        initComponents();
        setEvents();
    }

    private void initData() {

        listItem = new ArrayList<>();

        listItem.add(new ItemFace(R.drawable.beauty, "Beauty"));
        listItem.add(new ItemFace(R.drawable.boss, "Boss"));
        listItem.add(new ItemFace(R.drawable.doubt, "Doubt"));
        listItem.add(new ItemFace(R.drawable.choler, "Choler"));
        listItem.add(new ItemFace(R.drawable.love, "Love"));
        listItem.add(new ItemFace(R.drawable.too_sad, "Sad"));
        listItem.add(new ItemFace(R.drawable.dribble, "Dribble"));
        listItem.add(new ItemFace(R.drawable.what, "What"));
        listItem.add(new ItemFace(R.drawable.oh, "Oh"));
        listItem.add(new ItemFace(R.drawable.met, "Met"));
        listItem.add(new ItemFace(R.drawable.nhan, "Nhan"));
        listItem.add(new ItemFace(R.drawable.feel_good, "Feel good"));
        listItem.add(new ItemFace(R.drawable.presence_offline, "Presence"));
        listItem.add(new ItemFace(R.drawable.xanh, "Xanh"));

    }

    private void findViewByIds() {
        mVp = (ViewPager) findViewById(R.id.vp_face);

    }

    private void initComponents() {
        mAdapter = new PagerAdapterFace(this, this);

        mVp.setAdapter(mAdapter);

        Animation animation = AnimationUtils.loadAnimation(
                this, R.anim.translate_vp);

        mVp.startAnimation(animation);

        mVp.setOnDragListener(this);

        mVp.setOnPageChangeListener(this);
        //thay doi khoang trang o giua khi cuon
        mVp.setPageMarginDrawable(android.R.drawable.ic_menu_send);

//        mVp.setOnTouchListener(this);
    }

    private void setEvents() {

    }

    @Override
    public int getSize() {
        return listItem.size();
    }

    @Override
    public ItemFace getItemFace(int position) {
        return listItem.get(position);
    }

    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {

        showMsg("Drag Keo VP");
        return false;
    }


   //khi nguoi dung kich chuot de cuon trang
    @Override
    public void onPageScrolled(int position,
                               float positionOffset,
                               int positionOffsetPixels) {
        Log.d(TAG, "Cuon trang thu: " + position);

    }

    @Override
    public void onPageSelected(int position) {

        Log.d(TAG, "Trang duoc lua chon: " + position);
    }

    //Gọi khi thay đổi trạng thái di chuyển.
    @Override
    public void onPageScrollStateChanged(int state) {
        //trang thai thay doi co hau trang 3 trang thai thay doi
        //0 la chua cuon gi
        //1 la nguoi dung dang cuon
        //2 la nguoi dung daa thay doi trang moi
        Log.d(TAG, "Trang thai thay doi trang: " + state);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        showMsg("Cham page!!!");
        return true;
    }


    private void showMsg(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
