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

import android.view.View;

/**
 * author: Soulwolf Created on 2015/8/4 21:56.
 * email : Ching.Soulwolf@gmail.com
 *
 * Interface used to allow the creator of a dialog to run some code when an
 * item on the dialog is clicked..
 */
public interface OnItemClickListener {

    /**
     * This method will be invoked when a button list in the dialog is clicked.
     *
     * @param dialog The dialog that received the click.
     * @param view Clicked View!
     * @param position Click the Dialog button list is the position!
     */
    public void onItemClick(MasterDialog dialog,View view, int position);
}
