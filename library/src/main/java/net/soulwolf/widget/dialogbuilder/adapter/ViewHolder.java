package net.soulwolf.widget.dialogbuilder.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public final class ViewHolder {

    protected View mConvertView;

    protected Context mContext;

    protected SparseArray<View> mViews;

    ViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.mViews = new SparseArray<View>();
        this.mContext = context;
        this.mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,
                false);
        this.mConvertView.setTag(this);
    }

    /**
     * @param context app context
     * @param convertView container view
     * @param parent      parent view
     * @param layoutId    layout id
     * @param position    position
     * @return view holder
     */
    public static ViewHolder create(Context context, View convertView,
                                           ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId, position);
        }
        return (ViewHolder) convertView.getTag();
    }


    public View getConvertView() {
        return mConvertView;
    }

    /**
     * @param viewId view id
     * @return view
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }


    /**
     * @param viewId view id
     * @param text view text
     * @return view holder
     */
    public ViewHolder setText(@IdRes int viewId, CharSequence text) {
        TextView view = getView(viewId);
        if(view != null){
            view.setText(text);
        }
        return this;
    }
    /**
     * 为TextView设置字符串
     *
     * @param viewId view id
     * @param resId string res id
     * @return view holder
     */
    public ViewHolder setText(@IdRes int viewId, @StringRes int resId) {
        return setText(viewId,mContext.getString(resId));
    }

    /**
     * @param viewId view id
     * @param tag    view tag
     * @param listener click listener
     * @return view holder
     */
    public ViewHolder setOnClickListener(int viewId, Object tag, View.OnClickListener listener) {
        View view = getView(viewId);
        if(view != null){
            view.setTag(tag);
            view.setOnClickListener(listener);
        }
        return this;
    }

    /**
     * @param viewId view id
     * @param visibility view display state
     * @return view holder
     */
    public ViewHolder setVisibility(int viewId, int visibility) {
        View view = getView(viewId);
        if(view != null && view.getVisibility() != visibility){
            view.setVisibility(visibility);
        }
        return this;
    }

    /**
     * @param viewId view id
     * @param listener click listener
     * @return view holder
     */
    public ViewHolder setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        if(view != null){
            view.setOnClickListener(listener);
        }
        return this;
    }

    /**
     * @param viewId view id
     * @param textColor text color
     * @return view holder
     */
    public ViewHolder setTextColor(int viewId, @ColorInt int textColor) {
        TextView view = getView(viewId);
        if(view != null){
            view.setTextColor(textColor);
        }
        return this;
    }

    /**
     * @param viewId view id
     * @param resId text color
     * @return view holder
     */
    public ViewHolder setTextColorRes(int viewId, @ColorRes int resId) {
        TextView view = getView(viewId);
        if(view != null){
            view.setTextColor(getColor(resId));
        }
        return this;
    }

    public int getColor(@ColorRes int resId){
        return mContext.getResources().getColor(resId);
    }

    public String getString(@StringRes int resId){
        return mContext.getResources().getString(resId);
    }

    /**
     * @param viewId view
     * @param drawable drawable
     * @return view holder
     */
    public ViewHolder setBackgroundDrawable(int viewId, Drawable drawable) {
        View view = getView(viewId);
        if(view != null){
            view.setBackgroundDrawable(drawable);
        }
        return this;
    }

    /**
     * @param viewId view
     * @param drawable drawable red Id
     * @return view holder
     */
    public ViewHolder setBackgroundResource(@IdRes int viewId, @DrawableRes int drawable) {
        View view = getView(viewId);
        if(view != null){
            view.setBackgroundResource(drawable);
        }
        return this;
    }

    /**
     * @param viewId view
     * @param drawableId res Id
     * @return view holder
     */
    public ViewHolder setImageResource(@IdRes int viewId, @DrawableRes int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);
        return this;
    }

    /**
     * @param viewId view
     * @return view holder
     */
    public ViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

    public CharSequence getText(@IdRes int viewId) {
        TextView textView = getView(viewId);
        return textView.getText();
    }

    public void recycle() {
        mViews.clear();
        mViews = null;
        mConvertView = null;
        mContext = null;
        System.gc();
    }

}