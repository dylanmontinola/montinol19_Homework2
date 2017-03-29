package com.example.montinol19.homework2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import static android.graphics.Color.blue;
import static android.graphics.Color.green;
import static android.graphics.Color.red;
import android.widget.SeekBar;
import android.widget.TextView;
import static android.graphics.Color.rgb;

public class MainActivity extends AppCompatActivity
{
        public static TextView redValue, greenValue, blueValue, element;
        public static SeekBar redSeek, greenSeek, blueSeek;
        public MySurfaceView mainScreen;

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                //mainScreen = (MySurfaceView) this.findViewById(R.id.surfaceView);
                mainScreen.invalidate();

                redSeek	= (SeekBar)findViewById(R.id.redSeekBar);
                redValue 	= (TextView)findViewById(R.id.RedIntVal);

                greenSeek = (SeekBar)findViewById(R.id.greenSeekBar);
                greenValue = (TextView)findViewById(R.id.GreenIntVal);

                blueSeek = (SeekBar)findViewById(R.id.blueSeekBar);
                blueValue = (TextView)findViewById(R.id.BlueIntVal);

                element	= (TextView)findViewById(R.id.elementName);

                redSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
                {
                        @Override
                        public void onStopTrackingTouch(SeekBar arg0)
                        {

                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar arg0)
                        {

                        }

                        @Override
                        public void onProgressChanged(SeekBar arg0, int progress, boolean arg2)
                        {
                                redValue.setText("" + redSeek.getProgress());
                                if (mainScreen.numberElement == 1) {
                                        mainScreen.sun.setColor(rgb(redSeek.getProgress(),
                                                green(mainScreen.sun.getColor()), blue(mainScreen.sun.getColor())));
                                        mainScreen.invalidate();
                                } else if (mainScreen.numberElement == 2) {
                                        mainScreen.tower.setColor(rgb(redSeek.getProgress(),
                                                green(mainScreen.tower.getColor()), blue(mainScreen.tower.getColor())));
                                        mainScreen.invalidate();
                                }

                        }
                });


                greenSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
                {
                        @Override
                        public void onStopTrackingTouch(SeekBar arg0)
                        {

                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar arg0)
                        {

                        }

                        @Override
                        public void onProgressChanged(SeekBar arg0, int progress, boolean arg2)
                        {
                                greenValue.setText("" + greenSeek.getProgress());
                                if(mainScreen.numberElement == 1)
                                {
                                        mainScreen.sun.setColor(rgb(red(mainScreen.sun.getColor()),
                                                greenSeek.getProgress(), blue(mainScreen.sun.getColor())));
                                        mainScreen.invalidate();
                                }
                                else if(mainScreen.numberElement == 2)
                                {
                                        mainScreen.tower.setColor(rgb(red(mainScreen.tower.getColor()),
                                                greenSeek.getProgress(), blue(mainScreen.tower.getColor())));
                                        mainScreen.invalidate();
                                }




                        }
                });

                blueSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
                {
                        @Override
                        public void onStopTrackingTouch(SeekBar arg0)
                        {

                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar arg0)
                        {

                        }

                        @Override
                        public void onProgressChanged(SeekBar arg0, int progress, boolean arg2)
                        {
                                blueValue.setText("" + blueSeek.getProgress());
                                if(mainScreen.numberElement == 1)
                                {
                                        mainScreen.sun.setColor(rgb(red(mainScreen.sun.getColor()),
                                                green(mainScreen.sun.getColor()), blueSeek.getProgress()));

                                        mainScreen.invalidate();
                                }
                                else if(mainScreen.numberElement == 2)
                                {
                                        mainScreen.tower.setColor(rgb(red(mainScreen.tower.getColor()),
                                                green(mainScreen.tower.getColor()), blueSeek.getProgress()));
                                        mainScreen.invalidate();
                                }

                        }
                });
        }


}
