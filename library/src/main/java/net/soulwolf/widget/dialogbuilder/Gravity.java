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
package net.soulwolf.widget.dialogbuilder;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * author : Soulwolf Create by 2015/8/5 9:36
 * email  : ToakerQin@gmail.com.
 */
public final class Gravity {

    /** Push object to the left of its container, not changing its size. */
    public static final int LEFT                = 0x00000020;

    /** Push object to the top of its container, not changing its size. */
    public static final int TOP                 = 0x00000040;

    /** Push object to the right of its container, not changing its size. */
    public static final int RIGHT               = 0x00000080;

    /** Push object to the bottom of its container, not changing its size. */
    public static final int BOTTOM              = 0x00000002;

    /** Place object in the center of its container, not changing its
     *  size. */
    public static final int CENTER              = 0x00000004;

    @IntDef({Gravity.LEFT,Gravity.TOP,Gravity.RIGHT,Gravity.BOTTOM,Gravity.CENTER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface GravityMode{
    }

    public static int parserGravity(@GravityMode int gravity){
        switch (gravity){
            case Gravity.LEFT:
                return  android.view.Gravity.LEFT | android.view.Gravity.CENTER_VERTICAL;

            case Gravity.TOP:
                return  android.view.Gravity.TOP | android.view.Gravity.CENTER_HORIZONTAL;

            case Gravity.RIGHT:
                return  android.view.Gravity.RIGHT | android.view.Gravity.CENTER_VERTICAL;

            case Gravity.BOTTOM:
                return  android.view.Gravity.BOTTOM | android.view.Gravity.CENTER_HORIZONTAL;

            default:
                return android.view.Gravity.CENTER_VERTICAL | android.view.Gravity.CENTER_HORIZONTAL;
        }
    }
}
