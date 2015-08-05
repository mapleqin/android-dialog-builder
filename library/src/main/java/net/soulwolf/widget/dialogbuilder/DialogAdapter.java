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

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import net.soulwolf.widget.dialogbuilder.adapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * author : Soulwolf Create by 2015/8/5 14:24
 * email  : ToakerQin@gmail.com.
 */
public abstract class DialogAdapter<ITEM> extends BaseAdapter {

    protected Context mContext;

    protected List<ITEM> mData;

    protected final int mItemLayoutId;


    public DialogAdapter(Context context,@LayoutRes int layoutResource){
        this(context, new ArrayList<ITEM>(), layoutResource);
    }

    public DialogAdapter(Context context,ITEM [] data,@LayoutRes int layoutResource){
        this(context, Utils.asList(data), layoutResource);
    }

    public DialogAdapter(Context context,List<ITEM> data,@LayoutRes int layoutResource){
        this.mContext = context;
        this.mData = Utils.checkList(data);
        this.mItemLayoutId = layoutResource;
    }

    public List<ITEM> getData(){
        return mData;
    }

    @Override
    public boolean isEnabled(int position) {
        return position < mData.size();
    }

    public void add(ITEM elem) {
        mData.add(elem);
        notifyDataSetChanged();
    }

    public void addAll(List<ITEM> elem) {
        mData.addAll(elem);
        notifyDataSetChanged();
    }

    public void set(ITEM oldElem, ITEM newElem) {
        set(mData.indexOf(oldElem), newElem);
    }

    public void set(int index, ITEM elem) {
        mData.set(index, elem);
        notifyDataSetChanged();
    }

    public void remove(ITEM elem) {
        mData.remove(elem);
        notifyDataSetChanged();
    }

    public void remove(int index) {
        mData.remove(index);
        notifyDataSetChanged();
    }

    public void replaceAll(List<ITEM> elem) {
        mData.clear();
        mData.addAll(elem);
        notifyDataSetChanged();
    }

    public boolean contains(ITEM elem) {
        return mData.contains(elem);
    }

    /** Clear data list */
    public void clear() {
        mData.clear();
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public ITEM getItem(int position) {
        if(isEnabled(position)){
            return mData.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder baseViewHolder = getViewHolder(position, convertView,
                parent);
        ITEM item = getItem(position);
        if(item != null){
            convert(baseViewHolder, item,position);
        }
        return baseViewHolder.getConvertView();

    }

    public abstract void convert(ViewHolder helper, ITEM item,int position);

    private ViewHolder getViewHolder(int position, View convertView,
                                     ViewGroup parent) {
        return ViewHolder.create(mContext, convertView, parent, mItemLayoutId,
                position);
    }

    public Context getContext(){
        return mContext;
    }
}
