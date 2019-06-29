/**
 *  MeDitationTime
 *
 *  MainMenu.class: Controller class for the main menu
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

public class MainMenu extends BaseActivityWithDrawer {

    // Locking status
    private PrefManager prefManager;

    @Override
    public boolean shouldEnableDrawer() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefManager = new PrefManager(this);

        LayoutInflater.from(this).inflate(R.layout.activity_main_menu, getFrame());


        // journey button
        RelativeLayoutButton Jou_btn = new RelativeLayoutButton(this, R.id.Journey_btn);
        Jou_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Info_Journey.class);
                intent.putExtra("firstCall", true);
                startActivity(intent);
            }
        });

        // mood button
        RelativeLayoutButton mo_btn = new RelativeLayoutButton(this, R.id.Mood_btn);
        mo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Info_Mood.class);
                intent.putExtra("firstCall", true);
                startActivity(intent);
            }
        });
        // lock button if intro meditation has not yet been completed
        if(prefManager.isLocked(1)) {
            mo_btn.setEnabled(false);
            mo_btn.setImageResource(R.id.button_image, R.drawable.icn_mood_lightblue);
            mo_btn.setTextColor(R.id.button_text, getResources().getColor(R.color.element_inactive_mainMenu));
        }

        // balancing button
        RelativeLayoutButton balancing_btn = new RelativeLayoutButton(this, R.id.Bala_btn);
        balancing_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Info_Balancing.class);
                intent.putExtra("firstCall", true);
                startActivity(intent);
            }
        });
        // lock button if intro meditation has not yet been completed
        if(prefManager.isLocked(1)) {
            balancing_btn.setEnabled(false);
            balancing_btn.setImageResource(R.id.button_image, R.drawable.icn_balancing_lightblue);
            balancing_btn.setTextColor(R.id.button_text, getResources().getColor(R.color.element_inactive_mainMenu));
        }

        // info button
        ImageButton info_btn = (ImageButton) findViewById(information);
        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Info_Intro.class);
                intent.putExtra("infoBtn", true);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        prefManager = new PrefManager(this);

        RelativeLayoutButton mo_btn = new RelativeLayoutButton(this, R.id.Mood_btn);
        RelativeLayoutButton balancing_btn = new RelativeLayoutButton(this, R.id.Bala_btn);
        // check if intro meditation has been done
        if(!prefManager.isLocked(1)) {
            // re-enable buttons
            mo_btn.setEnabled(true);
            mo_btn.setImageResource(R.id.button_image, R.drawable.icn_mood_blue);
            mo_btn.setTextColor(R.id.button_text, getResources().getColor(R.color.element_active_mainMenu));
            mo_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(getApplicationContext(), Info_Mood.class);
                    intent.putExtra("firstCall", true);
                    startActivity(intent);
                }
            });
            balancing_btn.setEnabled(true);
            balancing_btn.setImageResource(R.id.button_image, R.drawable.icn_balancing_blue);
            balancing_btn.setTextColor(R.id.button_text, getResources().getColor(R.color.element_active_mainMenu));
            balancing_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(getApplicationContext(), Info_Balancing.class);
                    intent.putExtra("firstCall", true);
                    startActivity(intent);
                }
            });
        }
    }
}
