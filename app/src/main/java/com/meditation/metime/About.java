/**
 *  MeDitationTime
 *
 *  About.class: Controller class for the about section
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

package com.meditation.metime;

import android.os.Bundle;
import android.view.LayoutInflater;


public class About extends BaseActivityWithDrawer {

    // enables drawer
    @Override
    public boolean shouldEnableDrawer() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // sets the balancing layout to the BaseActivityWithDrawer
        LayoutInflater.from(this).inflate(R.layout.activity_about, getFrame());

    }

}
