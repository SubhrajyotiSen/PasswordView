package com.subhrajyoti.passwordview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class PasswordView extends AppCompatEditText {

    /*Follow Material Design guidelines for opacity of visibility toggle icon
        38% for disabled and 54% for enabled
    */
    private final static int VISIBILITY_ENABLED = (int) (255 * .54f);
    private final static int VISIBILITY_DISABLED = (int) (255 * .38f);

    //indicator if toggle icon is enabled or disabled
    private boolean visible = false;

    //Drawables for toggle icons
    private Drawable eyeWithoutStrike;
    private Drawable eyeWithStrike;

    //indicator if strike through drawable is to be use
    private boolean useStrikeThrough;

    //color for the visibility toggle
    private int eyeTint = Color.BLACK;

    //position of cursor in the view
    private int cursorPosition;

    public PasswordView(Context context) {
        super(context);
        init(null);
    }

    public PasswordView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public PasswordView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext().getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.PasswordView,
                    0, 0);
            useStrikeThrough = a.getBoolean(R.styleable.PasswordView_strikeThrough, false);
            eyeTint = a.getColor(R.styleable.PasswordView_eyeTint, Color.BLACK);
            a.recycle();
        }

        //Mute the drawables so that multiple views can have separate visibilities
        eyeWithoutStrike = ContextCompat.getDrawable(getContext(), R.drawable.ic_visibility_black_24dp).mutate();
        eyeWithStrike = ContextCompat.getDrawable(getContext(), R.drawable.ic_visibility_off_black_24dp).mutate();
        DrawableCompat.setTint(eyeWithoutStrike, eyeTint);
        DrawableCompat.setTint(eyeWithStrike, eyeTint);
        eyeWithStrike.setAlpha(VISIBILITY_ENABLED);
        cursorPosition = -1;
        setup();
    }

    private void setup() {
        this.cursorPosition = getSelectionStart();
        setInputType(InputType.TYPE_CLASS_TEXT | (visible ? InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD : InputType.TYPE_TEXT_VARIATION_PASSWORD));
        Drawable drawable = useStrikeThrough && !visible ? eyeWithStrike : eyeWithoutStrike;
        Drawable[] drawables = getCompoundDrawables();
        setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], drawable, drawables[3]);
        eyeWithoutStrike.setAlpha(visible && !useStrikeThrough ? VISIBILITY_ENABLED : VISIBILITY_DISABLED);
    }

    @Override public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP
                && event.getX() >= (getWidth() - getCompoundDrawables()[2].getBounds().width() - getPaddingRight())
                && event.getX() <= (getWidth() - getPaddingRight())) {
            visible = !visible;
            setup();
            invalidate();
            this.cursorPosition = getSelectionStart();
            return true;
        }

        return super.onTouchEvent(event);
    }

    @Override public void setInputType(int type) {
        super.setInputType(type);
        setTypeface(getTypeface());
    }

    public void useStrikeThrough(boolean useStrikeThrough){
        this.useStrikeThrough = useStrikeThrough;
        setup();
    }

    public void setEyeTint(@ColorInt int eyeTint) {
        this.eyeTint = eyeTint;
        setup();
    }

    @Override protected void onSelectionChanged(int selStart, int selEnd) {
        super.onSelectionChanged(selStart, selEnd);
        if (this.cursorPosition > -1) {
            setSelection(this.cursorPosition);
            this.cursorPosition = -1;
        }
    }
}
