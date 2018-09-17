package com.filipelipan.stepperview

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.content.res.TypedArray
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.animation.OvershootInterpolator
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.check_view.view.*

class CheckView  : LinearLayout {

    val STATUS_UNCHECK = 0
    val STATUS_CHECK = 1
    val STATUS_FINISHED = 2

    var status: Int = 0


    constructor(context: Context) : super(context) {
        init(null, 0)
    }


    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        layoutInflater.inflate(R.layout.check_view, this, true)


        val attr :TypedArray = context.obtainStyledAttributes(attrs, R.styleable.CheckView, 0, 0)
        val text =  attr.getString(R.styleable.CheckView_cv_text)


        button.setText(text)

        attr.recycle()
    }

    fun setText(text :String ){
        button.setText(text)
    }

    fun unCheckButton(){
        status = STATUS_UNCHECK

        background_view.background = ContextCompat.getDrawable(context , R.drawable.bg_stepper)
        button.setTextColor(ContextCompat.getColor(context, R.color.steper_view_gray))

        check_view_background.visibility = View.INVISIBLE
        mark_view_background.visibility = View.INVISIBLE
    }

    fun checkButton(){
        status = STATUS_CHECK

        check_view_background.visibility = View.VISIBLE
        mark_view_background.visibility = View.INVISIBLE

        val set = AnimatorSet();

        val scaleOutX = ObjectAnimator.ofFloat(check_view_background, "scaleX", 0.0f, 1.0f)
        val scaleOutY = ObjectAnimator.ofFloat(check_view_background, "scaleY", 0.0f, 1.0f)

        set.play(scaleOutX).with(scaleOutY)
        set.interpolator = OvershootInterpolator(1.5f);
        set.start()

        button.setTextColor(ContextCompat.getColor(context, android.R.color.white))
    }

    fun unChecked() : Boolean {
        return check_view_background.visibility == View.INVISIBLE
    }

    fun isChecked() : Boolean {
        return check_view_background.visibility == View.VISIBLE
    }

    fun isMarkAsFinished() : Boolean {
        return mark_view_background.visibility == View.VISIBLE
    }

    fun markAsFinished(){
        status = STATUS_FINISHED

        if(mark_view_background.visibility == View.VISIBLE)
            return;

        mark_view_background.visibility = View.VISIBLE

        val set = AnimatorSet();

        val scaleOutX = ObjectAnimator.ofFloat(mark_view_background, "scaleX", 0.0f, 1.0f)
        val scaleOutY = ObjectAnimator.ofFloat(mark_view_background, "scaleY", 0.0f, 1.0f)

        set.play(scaleOutX).with(scaleOutY)
        set.interpolator = OvershootInterpolator(1.5f);
        set.start()

        button.setTextColor(ContextCompat.getColor(context, android.R.color.white))
    }



    public override fun onSaveInstanceState(): Parcelable? {
        //begin boilerplate code that allows parent classes to save state
        val superState = super.onSaveInstanceState()

        val ss = SavedState(superState)
        //end

        ss.status = this.status


        return ss
    }

    public override fun onRestoreInstanceState(state: Parcelable) {
        //begin boilerplate code so parent classes can restore state
        if (state !is SavedState) {
            super.onRestoreInstanceState(state)
            return
        }

        super.onRestoreInstanceState(state.superState)
        //end

        this.status = state.status

        recoverState(status= status)
    }

    private fun recoverState(status: Int = 0) {

        when(status){
            STATUS_UNCHECK -> {
                unCheckButton()
            }
            STATUS_CHECK -> {
                checkButton()
            }
            STATUS_FINISHED -> {
                markAsFinished()
            }
        }
    }

    internal class SavedState : View.BaseSavedState {
        var status: Int = 0

        constructor(superState: Parcelable) : super(superState) {}

        private constructor(inParcelable: Parcel) : super(inParcelable) {
            this.status = inParcelable.readInt()
        }

        override fun writeToParcel(out: Parcel, flags: Int) {
            super.writeToParcel(out, flags)

            out.writeInt(status)
        }


        companion object {
            @JvmField
            val CREATOR = object : Parcelable.Creator<SavedState> {
                override fun createFromParcel(source: Parcel): SavedState {
                    return SavedState(source)
                }

                override fun newArray(size: Int): Array<SavedState?> {
                    return arrayOfNulls(size)
                }
            }
        }

    }
}