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
import android.support.annotation.IdRes;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;

/**
 * author: Soulwolf Created on 2015/8/4 21:41.
 * email : Ching.Soulwolf@gmail.com
 */
public abstract class MasterDialog implements IMasterDialog{

    protected ViewGroup mDecorView;

    protected DialogBuilder mDialogBuilder;

    protected View mContentView;

    protected View mShadowView;

    protected ViewGroup mContainer;

    protected Activity mContext;

    protected boolean mShowing;

    protected boolean mCancelable;

    public MasterDialog(Context context){
        this(new DialogBuilder(context));
    }

    public MasterDialog(DialogBuilder builder){
        if(builder == null){
            throw new NullPointerException("DialogBuilder == null");
        }
        this.mDialogBuilder = builder;
        this.mCancelable = mDialogBuilder.isCancelable();
        this.mContext = mDialogBuilder.getContext();
        this.mDecorView = (ViewGroup) mContext.getWindow().getDecorView();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        this.mContainer = (ViewGroup) inflater.inflate(R.layout.dl_dialog_container,mDecorView,false);
        this.mShadowView = mContainer.findViewById(R.id.di_dialog_container_shadow);
        this.mContentView = onCreateView(inflater, mContainer);
        this.mContainer.addView(mContentView);
    }

    protected abstract View onCreateView(LayoutInflater inflater,ViewGroup container);

    @Override
    public void show() {
        if(isShowing()){
            return;
        }
        attachToWindow();
    }

    private void attachToWindow() {
        mDecorView.addView(mContainer,FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT);
        playDialogInAnimation();
        mContainer.requestFocus();
        mContainer.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_BACK
                        && event.getAction() == KeyEvent.ACTION_UP){
                    if(mDialogBuilder.getOnKeyListener() != null){
                        return onBackPressed()
                                && mDialogBuilder.getOnKeyListener()
                                .onKey(MasterDialog.this,keyCode,event);
                    }
                    return onBackPressed();
                }
                return false;
            }
        });
    }

    public boolean onBackPressed(){
        return false;
    }

    protected void playDialogInAnimation() {
        Animation inAnimation = mDialogBuilder.getDialogInAnimation();
        if(inAnimation != null){
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f,1.0f);
            alphaAnimation.setDuration(inAnimation.getDuration());
            mContentView.startAnimation(inAnimation);
            mShadowView.startAnimation(alphaAnimation);
        }
    }


    @Override
    public void cancel() {
        if(isShowing()){

        }
    }

    @Override
    public void dismiss() {

    }

    @Override
    public boolean isShowing() {
        return mShowing;
    }

    public View findViewById(@IdRes int id){
        if(mContentView != null){
            return mContentView.findViewById(id);
        }
        return null;
    }

    @Override
    public Context getContext() {
        return mContext;
    }
}
