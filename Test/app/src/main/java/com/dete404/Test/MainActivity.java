package com.dete404.Test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

//implements View.OnClickListener另一种写法BV1Np4y1a7UN?p=11
public class MainActivity extends AppCompatActivity {
    //广播
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;
    //方便打印设置TAG并用当前活动页名称
    private static final String tag="Main";

//    //测试数据
//    private String[]List_Data={"AA","BA","CA","DA","EA","FA"};
    //Fruit类的数组列表
    private List<Fruit>fruitList=new ArrayList<>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //设置主页
        setContentView(R.layout.main_layout);

        //动态广播 监听网络状态
        intentFilter=new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver=new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);



//        //适配器将List_Data加载到列表
//        ArrayAdapter<String> adapter = new ArrayAdapter<String> (MainActivity.this,android.R.layout.simple_list_item_1,List_Data);
//        //按照id实例化ListView
//        ListView listView=(ListView)findViewById(R.id.list_view);
//        listView.setAdapter(adapter);


        initFruits();
        //实例化适配器
        Fruit_Adapter adapter= new Fruit_Adapter (MainActivity.this,R.layout.fruit,fruitList);
        ListView listView=(ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        //监听列表
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit=fruitList.get(position);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
//AdapterView<?>parent,View view,int position,long id
        //按照id绑定按钮1，
        Button button1=(Button)findViewById(R.id.Button1);
        //绑定EditText
        EditText editText=(EditText)findViewById(R.id.edit_text);
        //绑定ImageView
        ImageView imageView=(ImageView) findViewById(R.id.img_view);
        //绑定ProgressBar
        ProgressBar progressBar=(ProgressBar)findViewById(R.id.progress_bar);

        //监听按钮1,
        button1.setOnClickListener(new View.OnClickListener(){
            //监听到点击
            @Override
            public void onClick(View v){
                //进度弹窗
                ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("标题");
                progressDialog.setMessage("内容....");
                progressDialog.setCancelable(false);
                progressDialog.show();





//                //选择弹窗
//                AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
//                dialog.setTitle("我是弹窗标题");
//                dialog.setMessage("我是弹窗内容");
//                dialog.setPositiveButton("我知道了（确定）", new DialogInterface.OnClickListener() {
//                    //点击确定后的事件函数
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this,"点击了确定",Toast.LENGTH_LONG).show();
//                    }
//
//                });
//                //可点击周围关闭弹窗
//                dialog.setCancelable(true);
//                //取消键
//                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                //显示弾框
//                dialog.show();

                //更改进度条进度
//                int progress= progressBar.getProgress();
//                progress=progress+10;
//                progressBar.setProgress(progress);

                //进度条消失和出现
//                if (progressBar.getVisibility()==View.GONE){
//                    progressBar.setVisibility(View.VISIBLE);
//                }
//                else{
//                    progressBar.setVisibility(View.GONE);
//                }

                //通过按键修改图片显示
                imageView.setImageResource(R.drawable.two);

                //获取输入框内的内容转变为字符串
                String inputText=editText.getText().toString();
                Toast.makeText(MainActivity.this,"点我干啥+输入框内容："+inputText,Toast.LENGTH_LONG).show();

                //显式从哪一页到哪一页
                //Intent intent=new Intent( MainActivity.this,First_Activity.class);
                //隐式
                //Intent intent=new Intent( "First_Activity_Action");

                //调用浏览器打开网站\拨号
//                Intent intent=new Intent( Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("https://blog.csdn.net/qq_26230027"));
//                intent.setData(Uri.parse("tel:10086"));

                //传递数据 name来命名数据
//                String data="我是传递给打开页面的数据";
//                Intent intent=new Intent(MainActivity.this,First_Activity.class);
//                intent.putExtra("extra_data",data);
//                startActivity(intent);
            }

        });

        Log.v(tag,"onCreate");
        Log.d(tag,"onCreate");
        Log.i(tag,"onCreate");
        Log.w(tag,"onCreate");
        Log.w("tag","onCreate");
    }
    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    };
    //重写NetworkChangeReceiver实例
    class NetworkChangeReceiver extends BroadcastReceiver{
        @Override
        public void  onReceive(Context context,Intent intent){
            Toast.makeText(MainActivity.this,"network change",Toast.LENGTH_SHORT).show();
        }
    }
    //水果数据加载
    protected void initFruits(){
        for (int i=0;i<2;i++){
            Fruit apple =new Fruit("apple",R.drawable.apple);
            fruitList.add(apple);
            Fruit kiwi =new Fruit("kiwi",R.drawable.kiwi);
            fruitList.add(kiwi);
            Fruit fire =new Fruit("fire",R.drawable.fire);
            fruitList.add(fire);
            Fruit lemon =new Fruit("lemon",R.drawable.lemon);
            fruitList.add(lemon);
        }
    }
    //菜单显示
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    //菜单响应
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(MainActivity.this,"点添加干啥",Toast.LENGTH_LONG).show();
                break;
            case R.id.delete_item:
                Toast.makeText(MainActivity.this,"点删除干啥",Toast.LENGTH_LONG).show();
                break;
            default:
        }
        return false;
    }

}