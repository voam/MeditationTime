/**
 *  MeDitationTime
 *
 *  Info_hand_5.class: Controller class for the info_hand section
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

package com.meditation.metime;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;


public class Info_hand_5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_hands);

        RelativeLayoutButton hand_btn = new RelativeLayoutButton(this,R.id.hand_btn);
        //set text on button
        hand_btn.setText(R.id.button_text, "OK");
        hand_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Journey_level_5.class);
                startActivity(intent);
            }
        });




    }
}
