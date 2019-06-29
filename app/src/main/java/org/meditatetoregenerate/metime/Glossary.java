/**
 *  MeDitationTime
 *
 *  Glossary.class: Controller class for the glossary section
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

package org.meditatetoregenerate.metime;

import android.os.Bundle;
import android.view.LayoutInflater;

import org.meditatetoregenerate.metime.R;


public class Glossary extends BaseActivityWithDrawer {

    // enables drawer
    @Override
    public boolean shouldEnableDrawer() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // sets the balancing layout to the BaseActivityWithDrawer
        LayoutInflater.from(this).inflate(R.layout.activity_terminology, getFrame());



    }

}
