package com.zhuandian.cropmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zhuandian.cropmanager.base.BaseActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tv_ph_level)
    TextView tvPhLevel;
    @BindView(R.id.tv_refresh_ph)
    TextView tvRefreshPh;
    @BindView(R.id.et_crop_name)
    EditText etCropName;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    private double phLevel = 0.0;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setUpView() {
        runServer();
    }

    public void runServer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                initServer();
            }
        }).start();
    }


    @OnClick({R.id.tv_refresh_ph, R.id.tv_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_refresh_ph:
                runServer();
                Toast.makeText(MainActivity.this, "正在重新获取PH值...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_search:

                Intent intent = new Intent(MainActivity.this, ResultAcitivity.class);
                intent.putExtra("ph", phLevel);
                intent.putExtra("crop_name", etCropName.getText().toString());
                startActivity(intent);


                break;
        }
    }


    public void initServer() {
        try {
            //创建一个ServerSocket，port是客户端的端口
            ServerSocket serverSocket = new ServerSocket(9000);
            while (true) {
                //从请求队列中取出链接,如果只接受一次则不用使用while循环
                Socket socket = serverSocket.accept();
                //获取客户端信息
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                final String clientContent = input.readLine();
                //接下来可以对信息进行操作，我这里是直接打印了，你可以读取或者做其他操作
                System.out.println(clientContent + "-------------------");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvRefreshPh.setText(clientContent);
//                        phLevel = clientContent
                    }
                });

                //初始化输出流，回复客户端
                PrintStream out = new PrintStream(socket.getOutputStream());
                //获取键盘输出的内容
                String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
                //将信息发送给客户端
                out.println("open");

                //关闭
                out.close();
                input.close();
            }
        } catch (IOException e) {
            System.out.println("服务器异常:" + e);
        }
    }
}
