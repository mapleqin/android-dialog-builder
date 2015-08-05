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
package net.soulwolf.widget.dialogbuilder.adapter;

import android.content.Context;

import net.soulwolf.widget.dialogbuilder.DialogAdapter;
import net.soulwolf.widget.dialogbuilder.R;
import net.soulwolf.widget.dialogbuilder.model.GridModel;

import java.util.List;

/**
 * author : Soulwolf Create by 2015/8/5 15:39
 * email  : ToakerQin@gmail.com.
 */
public class GridDialogAdapter extends DialogAdapter<GridModel> {

    public GridDialogAdapter(Context context) {
        super(context, R.layout.dl_simple_grid_item);
    }

    public GridDialogAdapter(Context context, GridModel[] data) {
        super(context, data,  R.layout.dl_simple_grid_item);
    }

    public GridDialogAdapter(Context context, List<GridModel> data) {
        super(context, data, R.layout.dl_simple_grid_item);
    }

    @Override
    public void convert(ViewHolder helper, GridModel gridModel, int position) {
        helper.setImageResource(android.R.id.icon1,gridModel.mIconResource);
        helper.setText(android.R.id.text1,gridModel.mText);
    }
}
