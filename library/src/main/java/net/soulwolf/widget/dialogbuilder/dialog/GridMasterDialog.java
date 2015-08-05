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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import net.soulwolf.widget.dialogbuilder.DialogBuilder;
import net.soulwolf.widget.dialogbuilder.R;
import net.soulwolf.widget.dialogbuilder.DialogAdapter;

/**
 * author : Soulwolf Create by 2015/8/5 15:23
 * email  : ToakerQin@gmail.com.
 */
public class GridMasterDialog extends AbsListMasterDialog {

    GridView mGridView;

    public GridMasterDialog(DialogBuilder builder) {
        super(builder);
    }

    @Override
    public void setAdapter(DialogAdapter adapter) {
        mGridView.setAdapter(adapter);
    }

    @Override
    protected View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.dl_dialog_grid, container, false);
        mGridView = (GridView) view.findViewById(R.id.di_dialog_grid);
        mGridView.setOnItemClickListener(this);
        return view;
    }

    public void setNumColumns(int columns){
        mGridView.setNumColumns(columns);
    }

    public void setColumnWidth(int width){
        mGridView.setColumnWidth(width);
    }
}
