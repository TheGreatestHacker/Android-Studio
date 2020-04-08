package com.example.quotes;
import java.util.ArrayList;

public class DataSource {
    //data fields
    private ArrayList<Integer> mPhotoPool;
    private ArrayList<Integer> mQuotePool;
    private ArrayList<Integer> mPhotoHdPool;

    //class DataSource default constructor
    public DataSource() {
        mPhotoPool = new ArrayList();
        mQuotePool = new ArrayList();
        mPhotoHdPool = new ArrayList();

        setupQuotePool();
        setupPhotoPool();
        setupPhotoHDPool();
    }

    //class methods below
    public ArrayList<Integer> getmPhotoHdPool() {
        return mPhotoHdPool;
    }

    public ArrayList<Integer> getmPhotoPool() {
        return mPhotoPool;
    }

    public ArrayList<Integer> getmQuotePool() {
        return mQuotePool;
    }

    public int getDataSourceLength() {
        return mPhotoPool.size();
    }

    private void setupPhotoPool() {
        mPhotoPool.add(R.drawable.steve_1);
        mPhotoPool.add(R.drawable.steve_2);
        mPhotoPool.add(R.drawable.steve_3);
        mPhotoPool.add(R.drawable.steve_4);
        mPhotoPool.add(R.drawable.apple);
        mPhotoPool.add(R.drawable.image6);
        mPhotoPool.add(R.drawable.image7);
        mPhotoPool.add(R.drawable.image8);
        mPhotoPool.add(R.drawable.image9);
        mPhotoPool.add(R.drawable.image10);
    }
    private void setupQuotePool() {

        mQuotePool.add(R.string.quote_1);
        mQuotePool.add(R.string.quote_2);
        mQuotePool.add(R.string.quote_3);
        mQuotePool.add(R.string.quote_4);
        mQuotePool.add(R.string.quote_5);
        mQuotePool.add(R.string.quote_6);
        mQuotePool.add(R.string.quote_7);
        mQuotePool.add(R.string.quote_8);
        mQuotePool.add(R.string.quote_9);
        mQuotePool.add(R.string.quote_10);

        /*
        mQuotePool.add(R.string.quote_1);
        mQuotePool.add(R.string.quote_2);
        mQuotePool.add(R.string.quote_3);
        mQuotePool.add(R.string.quote_4);
        mQuotePool.add(R.string.quote_5);
        mQuotePool.add(R.string.quote_6);
        mQuotePool.add(R.string.quote_7);
        mQuotePool.add(R.string.quote_8);
        mQuotePool.add(R.string.quote_9);
        mQuotePool.add(R.string.quote_10);
        */
    }


    private void setupPhotoHDPool() {
        mPhotoHdPool.add(R.drawable.steve_hd_1);
        mPhotoHdPool.add(R.drawable.steve_hd_2);
        mPhotoHdPool.add(R.drawable.steve_hd_3);
        mPhotoHdPool.add(R.drawable.steve_hd_4);
        mPhotoHdPool.add(R.drawable.apple1_hd);
        mPhotoHdPool.add(R.drawable.image6_hd);
        mPhotoHdPool.add(R.drawable.image7_hd);
        mPhotoHdPool.add(R.drawable.image8_hd);
        mPhotoHdPool.add(R.drawable.image9_hd);
        mPhotoHdPool.add(R.drawable.image10_hd);
    }

}
