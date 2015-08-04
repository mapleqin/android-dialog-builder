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
import android.support.annotation.AnimRes;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

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

    private boolean mCancelable;

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
    public IDialogBuilder setOnCancelListener(OnCancelListener listener) {
        this.mOnCancelListener = listener;
        return this;
    }

    @Override
    public IDialogBuilder setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
        return this;
    }

    @Override
    public IDialogBuilder setOnDismissListener(OnDismissListener listener) {
        this.mOnDismissListener = listener;
        return this;
    }

    @Override
    public IDialogBuilder setOnShowListener(OnShowListener listener) {
        this.mOnShowListener = listener;
        return this;
    }

    @Override
    public IDialogBuilder setOnKeyListener(OnKeyListener listener) {
        this.mOnKeyListener = listener;
        return this;
    }

    @Override
    public IDialogBuilder setAnimation(@AnimRes int in, @AnimRes int out) {
        this.mDialogInAnimation = AnimationUtils.loadAnimation(mContext,in);
        this.mDialogOutAnimation = AnimationUtils.loadAnimation(mContext,out);
        return this;
    }

    @Override
    public IDialogBuilder setAnimation(Animation in, Animation out) {
        this.mDialogInAnimation = in;
        this.mDialogOutAnimation = out;
        return this;
    }

    @Override
    public IDialogBuilder setCancelable(boolean isCancelable) {
        this.mCancelable = isCancelable;
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

    public void setmOnKeyListener(OnKeyListener mOnKeyListener) {
        this.mOnKeyListener = mOnKeyListener;
    }

    public boolean isCancelable() {
        return mCancelable;
    }
}
