/**
 *  MeDitationTime
 *
 *  RelativeLayoutButton.class: Creates custom buttons from relative layouts
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

package org.meditatetoregenerate.metime;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RelativeLayoutButton extends RelativeLayout {

    public RelativeLayoutButton(Context context, int id)
    {
        super(context);

        // if our context is not Activity we can't get View supplied by id
        if (!(context instanceof Activity))
            return;

        // find relative layout by id
        View v = ((Activity)context).findViewById(id);

        // is it RelativeLayout ?
        if (!(v instanceof RelativeLayout))
            return;

        //cast it to relative layout
        RelativeLayout layout = (RelativeLayout)v;

        // copy layout parameters
        ViewGroup.LayoutParams params = layout.getLayoutParams();
        this.setLayoutParams(params);

        // set button background to layout background
        this.setBackgroundDrawable(v.getBackground());

        // set button padding to layout padding
        this.setPadding(v.getPaddingLeft(),v.getPaddingTop(),v.getPaddingRight(),v.getPaddingBottom());

        // copy all child from relative layout to this button
        while (layout.getChildCount() > 0)
        {
            View vchild = layout.getChildAt(0);
            layout.removeViewAt(0);
            this.addView(vchild);

            // just to be sure that child views can't be clicked and focused
            vchild.setClickable(false);
            vchild.setFocusable(false);
            vchild.setFocusableInTouchMode(false);
        }

        // remove all view from layout (maybe it's not necessary)
        layout.removeAllViews();

        // set that this button is clickable, focusable, ...
        this.setClickable(true);
        this.setFocusable(true);
        this.setFocusableInTouchMode(false);

        // replace relative layout in parent with this one modified to looks like button
        ViewGroup vp = (ViewGroup)layout.getParent();
        int index = vp.indexOfChild(layout);
        vp.removeView(layout);
        vp.addView(this,index);

        this.setId(id);

    }

    // set text for textView
    public void setText(int id, CharSequence text)
    {
        View v = findViewById(id);
        if (null != v && v instanceof TextView)
        {
            ((TextView)v).setText(text);
        }

    }

    // set text color
    public void setTextColor(int id, int color)
    {

        View v = findViewById(id);
        if (null != v && v instanceof TextView)
        {
            ((TextView)v).setTextColor(color);
        }

    }

    // set drawable for an image
    public void setImageDrawable(int id, Drawable drawable)
    {

        View v = findViewById(id);
        if (null != v && v instanceof ImageView)
        {
            ((ImageView)v).setImageDrawable(drawable);
        }

    }

    // set image by resource id
    public void setImageResource(int id, int image_resource_id)
    {

        View v = findViewById(id);
        if (null != v && v instanceof ImageView)
        {
            ((ImageView)v).setImageResource(image_resource_id);
        }

    }

}