/**
 * <pre>
 * Copyright 2015 Soulwolf Ching
 * Copyright 2015 The Android Open Source Project for android-dialog-builder
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </pre>
 */
package net.soulwolf.widget.dialogbuilder;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.AnimRes;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

/**
 * author: Soulwolf Created on 2015/8/4 22:31.
 * email : Ching.Soulwolf@gmail.com
 */
public class DialogBuilder implements IDialogBuilder{

    private Activity mContext;

    private OnCancelListener mOnCancelListener;

    private OnItemClickListener mOnItemClickListener;

    private OnDismissListener mOnDismissListener;

    private OnKeyListener mOnKeyListener;

    private OnShowListener mOnShowListener;

    private Animation mDialogInAnimation;

    private Animation mDialogOutAnimation;

    private boolean mCancelable = true;

    private int mGravity = Gravity.CENTER;

    private FrameLayout.LayoutParams mLayoutParams;

    private Drawable mBackground;

    private boolean mCustomSize;

    private boolean mIgnoreStatusBar = true;

    public DialogBuilder(Context context){
        if(context == null){
            throw new NullPointerException("context == null");
        }
        if(!(context instanceof Activity)){
            throw new IllegalArgumentException("android.view.WindowManager$BadTokenException:Unable to add window");
        }
        this.mContext = (Activity) context;
    }


    public Activity getContext(){
        return mContext;
    }

    @Override
    public DialogBuilder setOnCancelListener(OnCancelListener listener) {
        this.mOnCancelListener = listener;
        return this;
    }

    @Override
    public DialogBuilder setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
        return this;
    }

    @Override
    public DialogBuilder setOnDismissListener(OnDismissListener listener) {
        this.mOnDismissListener = listener;
        return this;
    }

    @Override
    public DialogBuilder setOnShowListener(OnShowListener listener) {
        this.mOnShowListener = listener;
        return this;
    }

    @Override
    public DialogBuilder setOnKeyListener(OnKeyListener listener) {
        this.mOnKeyListener = listener;
        return this;
    }

    @Override
    public DialogBuilder setAnimation(@AnimRes int in, @AnimRes int out) {
        this.mDialogInAnimation = AnimationUtils.loadAnimation(mContext,in);
        this.mDialogOutAnimation = AnimationUtils.loadAnimation(mContext,out);
        return this;
    }

    @Override
    public DialogBuilder setAnimation(Animation in, Animation out) {
        this.mDialogInAnimation = in;
        this.mDialogOutAnimation = out;
        return this;
    }

    @Override
    public DialogBuilder setCancelable(boolean isCancelable) {
        this.mCancelable = isCancelable;
        return this;
    }

    @Override
    public DialogBuilder setLayoutParams(int width, int height) {
        mCustomSize = true;
        if(mLayoutParams == null){
            mLayoutParams = new FrameLayout.LayoutParams(width,height);
            mLayoutParams.gravity = Gravity.parserGravity(mGravity);
            mLayoutParams.topMargin = getStatusBarHeight();
        }else {
            mLayoutParams.width = width;
            mLayoutParams.height = height;
        }
        return this;
    }

    @Override
    public DialogBuilder setGravity(@Gravity.GravityMode int gravity) {
        this.mGravity = gravity;
        initializeLayoutParams();
        return this;
    }

    private void initializeLayoutParams() {
        int width,height;
        switch (mGravity){
            case Gravity.LEFT:
            case Gravity.RIGHT:
                width = FrameLayout.LayoutParams.WRAP_CONTENT;
                height = FrameLayout.LayoutParams.MATCH_PARENT;
                break;

            case Gravity.TOP:
            case Gravity.BOTTOM:
                width = FrameLayout.LayoutParams.MATCH_PARENT;
                height = FrameLayout.LayoutParams.WRAP_CONTENT;
                break;

            default:
                width = FrameLayout.LayoutParams.WRAP_CONTENT;
                height = FrameLayout.LayoutParams.WRAP_CONTENT;
                break;
        }
        if(mLayoutParams == null){
            mLayoutParams = new FrameLayout.LayoutParams(width,height);
            mLayoutParams.topMargin = getStatusBarHeight();
        }else {
            if(!mCustomSize){
                mLayoutParams.width = width;
                mLayoutParams.height = height;
            }
        }
        mLayoutParams.gravity = Gravity.parserGravity(mGravity);
    }


    @Override
    public DialogBuilder setMargin(int l, int t, int r, int b) {
        if(mLayoutParams == null){
            mLayoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT
                    ,FrameLayout.LayoutParams.WRAP_CONTENT);
            mLayoutParams.gravity = Gravity.parserGravity(mGravity);
        }
        mLayoutParams.leftMargin = l;
        mLayoutParams.topMargin = t;
        mLayoutParams.rightMargin = r + getStatusBarHeight();
        mLayoutParams.bottomMargin = b ;
        return this;
    }

    private int getStatusBarHeight(){
        if(mIgnoreStatusBar){
            return Utils.getStatusBarHeight(getContext());
        }
        return 0;
    }

    @Override
    public DialogBuilder setBackground(int color) {
        this.mBackground = new ColorDrawable(color);
        return this;
    }

    @Override
    public DialogBuilder setBackgroundResource(int resource) {
        this.mBackground = getContext().getResources().getDrawable(resource);
        return this;
    }

    @Override
    public DialogBuilder setBackground(Drawable drawable) {
        this.mBackground = drawable;
        return this;
    }

    @Override
    public DialogBuilder setIgnoreStatusBar(boolean isIgnoreStatusBar) {
        this.mIgnoreStatusBar = isIgnoreStatusBar;
        return this;
    }

    public OnCancelListener getOnCancelListener() {
        return mOnCancelListener;
    }

    public OnItemClickListener getOnItemClickListener() {
        return mOnItemClickListener;
    }

    public OnDismissListener getOnDismissListener() {
        return mOnDismissListener;
    }

    public OnShowListener getOnShowListener() {
        return mOnShowListener;
    }

    public Animation getDialogInAnimation() {
        return mDialogInAnimation;
    }

    public Animation getDialogOutAnimation() {
        return mDialogOutAnimation;
    }

    public OnKeyListener getOnKeyListener() {
        return mOnKeyListener;
    }
    public boolean isCancelable() {
        return mCancelable;
    }

    public int getGravity() {
        return mGravity;
    }

    public FrameLayout.LayoutParams getLayoutParams() {
        if(mLayoutParams == null){
            mLayoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT
                    ,FrameLayout.LayoutParams.WRAP_CONTENT);
            mLayoutParams.gravity = Gravity.parserGravity(mGravity);
            mLayoutParams.topMargin = getStatusBarHeight();
        }
        return mLayoutParams;
    }

    public Drawable getBackground() {
        if(mBackground == null){
            mBackground = new ColorDrawable(Color.TRANSPARENT);
        }
        return mBackground;
    }
}
