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

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;

import net.soulwolf.widget.dialogbuilder.DialogBuilder;
import net.soulwolf.widget.dialogbuilder.MasterDialog;
import net.soulwolf.widget.dialogbuilder.R;

/**
 * author : Soulwolf Create by 2015/8/5 14:22
 * email  : ToakerQin@gmail.com.
 */
public abstract class AbsListMasterDialog extends MasterDialog
        implements IAbsListControl,ICancelButton, View.OnClickListener,
        AdapterView.OnItemClickListener {

    public AbsListMasterDialog(DialogBuilder builder) {
        super(builder);
        findViewById(R.id.di_dialog_cancel).setOnClickListener(this);
    }

    @Override
    public void setCancelButton(boolean display) {
        View view = findViewById(R.id.di_dialog_cancel_layout);
        if(view != null){
            view.setVisibility(display ? View.VISIBLE : View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.di_dialog_cancel){
            cancel();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(mDialogBuilder.getOnItemClickListener() != null){
            mDialogBuilder.getOnItemClickListener().onItemClick(this,view,position);
        }
    }
}
