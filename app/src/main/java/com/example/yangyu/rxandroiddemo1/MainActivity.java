package com.example.yangyu.rxandroiddemo1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.yangyu.rxandroiddemo1.R.id.img;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private RecyclerView mList;
    private Button mStart;

    private Result result;
    private ArrayList<Result.ResultsBean> mBeans;
    private MyAdaptor mAdaptor;
    private ProgressBar mPb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mList = (RecyclerView) findViewById(R.id.show_data);
        mStart = (Button) findViewById(R.id.start);
        mPb = (ProgressBar) findViewById(R.id.progress);
        mStart.setOnClickListener(mStartListener);
        mAdaptor = new MyAdaptor();
        mList.setLayoutManager(new LinearLayoutManager(this));
        mList.addItemDecoration(new MyDecoration(this));
        mList.setAdapter(mAdaptor);
    }

    private void getData() {
        Observable<ArrayList<Result.ResultsBean>> mObservable = Observable.create(new ObservableOnSubscribe<ArrayList<Result.ResultsBean>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<ArrayList<Result.ResultsBean>> e) throws Exception {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://gank.io/api/data/Android/10/1")
                        .build();
                Response response = client.newCall(request).execute();
                if (response.isSuccessful()) {
                    result = Utils.transform(response.body().string(), Result.class);
                    e.onNext((ArrayList<Result.ResultsBean>) result.getResults());
                }
            }
        });

        Observer<ArrayList<Result.ResultsBean>> mObserver = new Observer<ArrayList<Result.ResultsBean>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull ArrayList<Result.ResultsBean> s) {
                mBeans = s;
                mPb.setVisibility(View.GONE);
                mAdaptor.notifyDataSetChanged();
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        mObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mObserver);
    }

    private View.OnClickListener mStartListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mPb.setVisibility(View.VISIBLE);
            getData();
        }
    };


    class MyAdaptor extends RecyclerView.Adapter<MyHolder> {

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_recycler_view, parent, false);
            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            if (mBeans != null) {
                Result.ResultsBean resultsBean = mBeans.get(position);
                ArrayList<String> imgs = (ArrayList<String>) resultsBean.getImages();
                if (imgs != null) {
                    holder.setData(imgs.get(0), resultsBean.getDesc());
                } else {
                    holder.setData(R.drawable.default_icon, resultsBean.getDesc());
                }
            }
        }

        @Override
        public int getItemCount() {
            return result == null ? 0 : result.getResults().size();
        }
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView textView;

        public MyHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(img);
            textView = (TextView) itemView.findViewById(R.id.dsc);
        }

        public void setData(String img, String dsc) {
            Glide.with(MainActivity.this).load(img).into(imageView);
            textView.setText(dsc);
        }

        public void setData(int img, String dsc) {
            Glide.with(MainActivity.this).load(img).into(imageView);
            textView.setText(dsc);
        }

    }

    private class MyDecoration extends RecyclerView.ItemDecoration {
        private int[] ATTRS = new int[]{
                android.R.attr.listDivider
        };
        private Drawable mDrawable;

        MyDecoration(Context context) {
            final TypedArray array = context.obtainStyledAttributes(ATTRS);
            mDrawable = array.getDrawable(0);
            array.recycle();
        }

        @Override
        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
            super.onDraw(c, parent, state);
            final int left = parent.getPaddingLeft();
            final int right = parent.getWidth() - parent.getPaddingRight();

            final int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View child = parent.getChildAt(i);
                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                        .getLayoutParams();
                final int top = child.getBottom() + params.bottomMargin;
                final int bottom = top + mDrawable.getIntrinsicHeight();
                mDrawable.setBounds(left, top, right, bottom);
                mDrawable.draw(c);
            }
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0, 0, 0, mDrawable.getIntrinsicHeight());
        }
    }
}
