package net.soulwolf.widget.dialogbuilder.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import net.soulwolf.widget.dialogbuilder.DialogBuilder;
import net.soulwolf.widget.dialogbuilder.Gravity;
import net.soulwolf.widget.dialogbuilder.adapter.GridDialogAdapter;
import net.soulwolf.widget.dialogbuilder.adapter.TextDialogAdapter;
import net.soulwolf.widget.dialogbuilder.dialog.AlertMasterDialog;
import net.soulwolf.widget.dialogbuilder.dialog.GridMasterDialog;
import net.soulwolf.widget.dialogbuilder.dialog.ListMasterDialog;
import net.soulwolf.widget.dialogbuilder.model.GridModel;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(mToolbar);
        findViewById(R.id.left).setOnClickListener(this);
        findViewById(R.id.top).setOnClickListener(this);
        findViewById(R.id.right).setOnClickListener(this);
        findViewById(R.id.bottom).setOnClickListener(this);
        findViewById(R.id.center).setOnClickListener(this);
        findViewById(R.id.center1).setOnClickListener(this);
        findViewById(R.id.grid).setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.left){
            DialogBuilder builder = new DialogBuilder(this)
                    .setAnimation(R.anim.da_slide_in_left, R.anim.da_slide_out_left)
                    //.setIgnoreStatusBar(false)
                    .setLayoutParams(700, ViewGroup.LayoutParams.MATCH_PARENT)
                    .setGravity(Gravity.LEFT)
                    .setBackgroundResource(R.color.toolbar_background);
            ListMasterDialog dialog = new ListMasterDialog(builder);
            dialog.setAdapter(new TextDialogAdapter(this,getSimpleStringData(8)));
            dialog.show();
        }else if(v.getId() == R.id.top){
            DialogBuilder builder = new DialogBuilder(this)
                    .setAnimation(R.anim.da_slide_in_top, R.anim.da_slide_out_top)
                    //.setIgnoreStatusBar(false)
                    .setGravity(Gravity.TOP)
                    .setBackgroundResource(R.color.toolbar_background);
            ListMasterDialog dialog = new ListMasterDialog(builder);
            dialog.setCancelButton(false);
            dialog.setAdapter(new TextDialogAdapter(this,getSimpleStringData(3)));
            dialog.show();
        }else if(v.getId() == R.id.right){
            DialogBuilder builder = new DialogBuilder(this)
                    .setAnimation(R.anim.da_slide_in_right, R.anim.da_slide_out_right)
                    //.setIgnoreStatusBar(false)
                    .setLayoutParams(700, ViewGroup.LayoutParams.MATCH_PARENT)
                    .setGravity(Gravity.RIGHT)
                    .setBackgroundResource(R.color.toolbar_background);
            ListMasterDialog dialog = new ListMasterDialog(builder);
            dialog.setAdapter(new TextDialogAdapter(this,getSimpleStringData(8)));
            dialog.show();
        }else if(v.getId() == R.id.bottom){
            DialogBuilder builder = new DialogBuilder(this)
                    .setAnimation(R.anim.da_slide_in_bottom, R.anim.da_slide_out_bottom)
                    //.setIgnoreStatusBar(false)
                    .setGravity(Gravity.BOTTOM);
            ListMasterDialog dialog = new ListMasterDialog(builder);
            dialog.setAdapter(new TextDialogAdapter(this,getSimpleStringData(4)));
            dialog.show();
        }else if(v.getId() == R.id.center){
            DialogBuilder builder = new DialogBuilder(this)
                    .setAnimation(R.anim.da_fade_in_center, R.anim.da_fade_out_center)
                    //.setIgnoreStatusBar(false)
                    .setGravity(Gravity.CENTER);
            AlertMasterDialog dialog = new AlertMasterDialog(builder);
            dialog.setTitle("提示");
            dialog.setContent("校导网是一家专注于校园精英人才孵化的移动互联网公司，\n" +
                    "以帮助大学生成才为使命，打造了一个基于精品活动的校园交友及职业素养提升平台，\n" +
                    "通过各种比赛、拓展、培训、实习、演讲、沙龙等活动来帮助大学生走出迷茫，\n" +
                    "锻炼实践能力，拓展交际圈子，提升职业素养，实现成功就业与创业。");
            dialog.show();
        }else if(v.getId() == R.id.center1){
            DialogBuilder builder = new DialogBuilder(this)
                    .setAnimation(R.anim.da_fade_in_center, R.anim.da_fade_out_center)
                    //.setIgnoreStatusBar(false)
                    .setGravity(Gravity.CENTER);
            AlertMasterDialog dialog = new AlertMasterDialog(builder);
            dialog.setTitle("提示");
            dialog.setButton2("取消");
            dialog.setContent("校导网是一家专注于校园精英人才孵化的移动互联网公司，\n" +
                    "以帮助大学生成才为使命，打造了一个基于精品活动的校园交友及职业素养提升平台，\n" +
                    "通过各种比赛、拓展、培训、实习、演讲、沙龙等活动来帮助大学生走出迷茫，\n" +
                    "锻炼实践能力，拓展交际圈子，提升职业素养，实现成功就业与创业。");
            dialog.show();
        }else if(v.getId() == R.id.grid){
            DialogBuilder builder = new DialogBuilder(this)
                    .setAnimation(R.anim.da_slide_in_bottom, R.anim.da_slide_out_bottom)
                    //.setIgnoreStatusBar(false)
                    .setGravity(Gravity.BOTTOM);
            GridMasterDialog dialog = new GridMasterDialog(builder);
            dialog.setAdapter(new GridDialogAdapter(this, getSimpleGridModelData()));
            dialog.setNumColumns(4);
            dialog.show();
        }
    }

    private GridModel[] getSimpleGridModelData(){
        return new GridModel[]{
                new GridModel(R.mipmap.share_layout_qq_icon,"QQ"),
                new GridModel(R.mipmap.share_layout_wx_icon,"微信"),
                new GridModel(R.mipmap.share_layout_friends_icon,"朋友圈"),
                new GridModel(R.mipmap.share_layout_qq_icon,"QQ"),
                new GridModel(R.mipmap.share_layout_wx_icon,"微信"),
                new GridModel(R.mipmap.share_layout_friends_icon,"朋友圈")
        };
    }

    private String[] getSimpleStringData(int size){
        String[] array = new String[size];
        for (int i= 0;i< size ;i++){
            array[i] = "SIMPLE-DATA" + i;
        }
        return array;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
