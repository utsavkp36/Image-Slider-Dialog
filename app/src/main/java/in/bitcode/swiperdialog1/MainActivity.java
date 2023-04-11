package in.bitcode.swiperdialog1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private SliderDialog sliderDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showSliderDialog();
    }

    private void showSliderDialog(){
        sliderDialog =new SliderDialog(this);
        sliderDialog.setImage(0);
        sliderDialog.show();
    }
}