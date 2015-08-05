# android-dialog-builder
This is an android in the Dialog library, not based on a systematic way to achieve Dialog using Activity root view of the Add Dialog, it has strong scalability and customizability!

For more information please see <a href='http://devsoulwolf.github.io/android-dialog-builder'>the website</a>

## Screenshots




## PictureChooseLib with Java code
```java
public void onClick(View v){
        if(v.getId() == R.id.left){
            DialogBuilder builder = new DialogBuilder(this)
                    .setAnimation(R.anim.da_slide_in_left, R.anim.da_slide_out_left)
                    //.setIgnoreStatusBar(false)
                    .setLayoutParams(700, ViewGroup.LayoutParams.MATCH_PARENT)
                    .setGravity(Gravity.LEFT)
                    .setOnItemClickListener(this)
                    .setBackgroundResource(R.color.toolbar_background);
            ListMasterDialog dialog = new ListMasterDialog(builder);
            dialog.setAdapter(new TextDialogAdapter(this,getSimpleStringData(8)));
            dialog.show();
        }else if(v.getId() == R.id.top){
            DialogBuilder builder = new DialogBuilder(this)
                    .setAnimation(R.anim.da_slide_in_top, R.anim.da_slide_out_top)
                    //.setIgnoreStatusBar(false)
                    .setGravity(Gravity.TOP)
                    .setOnItemClickListener(this)
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
                    .setOnItemClickListener(this)
                    .setBackgroundResource(R.color.toolbar_background);
            ListMasterDialog dialog = new ListMasterDialog(builder);
            dialog.setAdapter(new TextDialogAdapter(this,getSimpleStringData(8)));
            dialog.show();
        }else if(v.getId() == R.id.bottom){
            DialogBuilder builder = new DialogBuilder(this)
                    .setAnimation(R.anim.da_slide_in_bottom, R.anim.da_slide_out_bottom)
                    .setOnItemClickListener(this)
                    //.setIgnoreStatusBar(false)
                    .setGravity(Gravity.BOTTOM);
            ListMasterDialog dialog = new ListMasterDialog(builder);
            dialog.setAdapter(new TextDialogAdapter(this,getSimpleStringData(4)));
            dialog.show();
        }else if(v.getId() == R.id.center){
            DialogBuilder builder = new DialogBuilder(this)
                    .setOnItemClickListener(this)
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
                    .setOnItemClickListener(this)
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
                    .setOnItemClickListener(this)
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
    public void onItemClick(MasterDialog dialog, View view, int position) {
        Toast.makeText(this,"Item click:" + position,Toast.LENGTH_SHORT).show();
    }
```

## Maven
	<dependency>
  	    <groupId>net.soulwolf.widget</groupId>
		<url>https://dl.bintray.com/soulwolf/maven</url>
  	    <artifactId>dialogBuilder</artifactId>
  	    <version>1.0.0</version>
	</dependency>
## Gradle
	allprojects {
       repositories {
          jcenter()
       }
	}
	
	compile 'net.soulwolf.widget:dialogBuilder:1.0.0'

## Developed by
 Ching Soulwolf - <a href='javascript:'>Ching.Soulwolf@gmail.com</a>


## License
	Copyright 2015 Soulwolf Ching
	Copyright 2015 The Android Open Source Project for android-dialog-builder
	
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	    http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
	
