/**
 *  MeDitationTime
 *
 *  Balancing.class: Controller class for the balancing section
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

package org.meditatetoregenerate.metime;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

import org.meditatetoregenerate.metime.R;

import static org.meditatetoregenerate.metime.R.id.information;

public class Balancing extends BaseActivityWithDrawer {

    // enables drawer
    @Override
    public boolean shouldEnableDrawer() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // sets the balancing layout to the BaseActivityWithDrawer
        LayoutInflater.from(this).inflate(R.layout.activity_balancing, getFrame());


        //App Buttons
        ImageButton info_btn = (ImageButton) findViewById(information);
        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Info_Balancing.class);
                startActivity(intent);
            }
        });

        //Element Buttons
        //Water
        RelativeLayoutButton water_btn = new RelativeLayoutButton(this,R.id.Water_btn);
        water_btn.setText(R.id.button_text, "Water");
        water_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Balancing_water.class);
                startActivity(intent);
            }
        });

        //Fire
        RelativeLayoutButton fire_btn = new RelativeLayoutButton(this,R.id.Fire_btn);
        fire_btn.setText(R.id.button_text, "Fire");
        fire_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Balancing_fire.class);
                startActivity(intent);
            }
        });

        //Air
        RelativeLayoutButton air_btn = new RelativeLayoutButton(this,R.id.Air_btn);
        air_btn.setText(R.id.button_text, "Air/Ether");
        air_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Balancing_air.class);
                startActivity(intent);
            }
        });

        //Earth
        RelativeLayoutButton earth_btn = new RelativeLayoutButton(this,R.id.Earth_btn);
        earth_btn.setText(R.id.button_text, "Earth");
        earth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Balancing_earth.class);
                startActivity(intent);
            }
        });

    }
}
