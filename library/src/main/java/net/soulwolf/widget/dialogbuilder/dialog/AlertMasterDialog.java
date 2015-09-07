/**
 * <pre>
 * Copyright (C) 2015  Soulwolf android-dialog-builder
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
package net.soulwolf.widget.dialogbuilder.dialog;

import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.soulwolf.widget.dialogbuilder.DialogBuilder;
import net.soulwolf.widget.dialogbuilder.MasterDialog;
import net.soulwolf.widget.dialogbuilder.R;

/**
 * author : Soulwolf Create by 2015/8/5 16:38
 * email  : ToakerQin@gmail.com.
 */
public class AlertMasterDialog extends MasterDialog implements View.OnClickListener {

    TextView mTitleView;

    TextView mContentText;

    TextView mButton1;

    TextView mButton2;

    View     mButtonSpace;

    public AlertMasterDialog(DialogBuilder builder) {
        super(builder);
    }

    @Override
    protected View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.dl_dialog_alert, container,false);
        this.mTitleView = (TextView) view.findViewById(android.R.id.text1);
        this.mContentText = (TextView) view.findViewById(android.R.id.text2);
        this.mButton1 = (TextView) view.findViewById(android.R.id.button1);
        this.mButton2 = (TextView) view.findViewById(android.R.id.button2);
        this.mButtonSpace = view.findViewById(android.R.id.icon1);
        this.mButton1.setText(R.string.ds_ok);
        this.mButton1.setOnClickListener(this);
        this.mButton2.setOnClickListener(this);
        return view;
    }

    public void setTitle(CharSequence title){
        this.mTitleView.setText(title);
    }

    public void setTitle(@StringRes int  title){
        this.mTitleView.setText(title);
    }

    public void setContent(CharSequence content){
        this.mContentText.setText(content);
    }

    public void setContent(@StringRes int  content){
        this.mContentText.setText(content);
    }

    public void setButton1(CharSequence button1){
        this.mButton1.setText(button1);
    }

    public void setButton1(@StringRes int  button1){
        this.mButton1.setText(button1);
    }

    public void setButton2(CharSequence button2){
        this.mButton2.setText(button2);
        this.mButton2.setVisibility(View.VISIBLE);
        this.mButtonSpace.setVisibility(View.VISIBLE);
    }

    public void setButton2(@StringRes int  button2){
        this.mButton2.setText(button2);
        this.mButton2.setVisibility(View.VISIBLE);
        this.mButtonSpace.setVisibility(View.VISIBLE);
    }

    public void setButton2Visibility(int visibility){
        this.mButton2.setVisibility(visibility);
        this.mButtonSpace.setVisibility(visibility);
    }

    @Override
    public void onClick(View v) {
        int position;
        if(v.getId() == android.R.id.button1){
            position = 0;
        }else {
            position = 1;
        }
        if(mDialogBuilder.getOnItemClickListener() != null){
            mDialogBuilder.getOnItemClickListener().onItemClick(this,v,position);
        }
    }

    public TextView getTitleView() {
        return mTitleView;
    }

    public TextView getContentText() {
        return mContentText;
    }

    public TextView getButton1() {
        return mButton1;
    }

    public TextView getButton2() {
        return mButton2;
    }

    public View getButtonSpace() {
        return mButtonSpace;
    }
}
