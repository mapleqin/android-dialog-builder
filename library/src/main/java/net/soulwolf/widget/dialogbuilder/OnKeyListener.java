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

import android.view.KeyEvent;

/**
 * author: Soulwolf Created on 2015/8/4 21:57.
 * email : Ching.Soulwolf@gmail.com
 *
 * Interface definition for a callback to be invoked when a key event is
 * dispatched to this dialog. The callback will be invoked before the key
 * event is given to the dialog.
 */
public interface OnKeyListener {

    /**
     * Called when a key is dispatched to a dialog. This allows listeners to
     * get a chance to respond before the dialog.
     *
     * @param dialog The dialog the key has been dispatched to.
     * @param keyCode The code for the physical key that was pressed
     * @param event The KeyEvent object containing full information about
     *            the event.
     * @return True if the listener has consumed the event, false otherwise.
     */
    public boolean onKey(IMasterDialog dialog, int keyCode, KeyEvent event);
}
