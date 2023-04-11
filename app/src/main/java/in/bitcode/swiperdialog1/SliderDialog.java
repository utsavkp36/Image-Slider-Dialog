package in.bitcode.swiperdialog1;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class SliderDialog extends Dialog {
    private ImageView imgViewSwiper;
    private int index;
    SliderThread sliderThread;
    private ArrayList<Integer> imageViewArrayList;

    public SliderDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.swiper_dialog);

        initViews();
        initList();
    }

    public void setImage(int index){
        this.index=index;
        imgViewSwiper.setImageResource(imageViewArrayList.get(index));
        this.index++;
        sliderThread=new SliderThread();
        sliderThread.execute((Object) null);
    }

    private void updateImage(){
        imgViewSwiper.setImageResource(imageViewArrayList.get(index));
        index++;
        if(index==(imageViewArrayList.size())){
            index=0;
        }
    }
    private void initViews(){
        imgViewSwiper=findViewById(R.id.imgViewSwiper);
    }

    private void initList(){
        imageViewArrayList=new ArrayList<Integer>();
        imageViewArrayList.add(R.drawable.flag_france);
        imageViewArrayList.add(R.drawable.flag_germany);
        imageViewArrayList.add(R.drawable.flag_italy);
        imageViewArrayList.add(R.drawable.flag_japan);
    }

    private class SliderThread extends AsyncTask<Object,Integer,Object>{
        private boolean state=true;
        @Override
        protected Object doInBackground(Object... objects) {
            while (state) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                publishProgress(null);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            updateImage();
        }
    }

}
