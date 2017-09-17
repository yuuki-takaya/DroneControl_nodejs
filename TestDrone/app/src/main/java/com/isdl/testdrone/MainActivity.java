package com.isdl.testdrone;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    Handler redrawHandler;
    String text = "";
    String url = "http://172.31.6.94:4000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        redrawHandler = new Handler();





        Button takeoff =  (Button)findViewById(R.id.btn01);
        Button landon =  (Button)findViewById(R.id.btn02);
        Button down =  (Button)findViewById(R.id.btn03);
        Button front =  (Button)findViewById(R.id.btn04);
        Button up =  (Button)findViewById(R.id.btn05);
        Button left =  (Button)findViewById(R.id.btn06);

        Button right =  (Button)findViewById(R.id.btn08);
        Button turnleft =  (Button)findViewById(R.id.btn09);
        Button back =  (Button)findViewById(R.id.btn10);
        Button turnright =  (Button)findViewById(R.id.btn11);

        Button frontflip =  (Button)findViewById(R.id.btn13);
        Button backflip =  (Button)findViewById(R.id.btn14);


        frontflip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestBody formBody = new FormBody.Builder()
                        .add("name", "f")
                        .add("ctrl", "false")
                        .add("meta", "false")
                        .add("shift", "false")
                        .add("sequence", "f")
                        .build();

                Request request = new Request.Builder()
                        .url(url)       // HTTPアクセス POST送信 テスト確認用ページ
                        .post(formBody)
                        .build();

                OkHttpClient client = new OkHttpClient();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        text = response.body().string();
                        redrawHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                ((TextView)findViewById(R.id.text02)).setText(text);
                            }
                        });
                    }
                });
            }
        });


        backflip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestBody formBody = new FormBody.Builder()
                        .add("name", "b")
                        .add("ctrl", "false")
                        .add("meta", "false")
                        .add("shift", "false")
                        .add("sequence", "b")
                        .build();

                Request request = new Request.Builder()
                        .url(url)       // HTTPアクセス POST送信 テスト確認用ページ
                        .post(formBody)
                        .build();

                OkHttpClient client = new OkHttpClient();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        text = response.body().string();
                        redrawHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                ((TextView)findViewById(R.id.text02)).setText(text);
                            }
                        });
                    }
                });
            }
        });





        takeoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestBody formBody = new FormBody.Builder()
                        .add("name", "t")
                        .add("ctrl", "false")
                        .add("meta", "false")
                        .add("shift", "false")
                        .add("sequence", "t")
                        .build();

                Request request = new Request.Builder()
                        .url(url)       // HTTPアクセス POST送信 テスト確認用ページ
                        .post(formBody)
                        .build();

                OkHttpClient client = new OkHttpClient();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        text = response.body().string();
                        redrawHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                ((TextView)findViewById(R.id.text02)).setText(text);
                            }
                        });
                    }
                });
            }
        });

        landon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestBody formBody = new FormBody.Builder()
                        .add("name", "l")
                        .add("ctrl", "false")
                        .add("meta", "false")
                        .add("shift", "false")
                        .add("sequence", "l")
                        .build();

                Request request = new Request.Builder()
                        .url(url)       // HTTPアクセス POST送信 テスト確認用ページ
                        .post(formBody)
                        .build();

                OkHttpClient client = new OkHttpClient();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        text = response.body().string();
                        redrawHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                ((TextView)findViewById(R.id.text02)).setText(text);
                            }
                        });
                    }
                });

            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestBody formBody = new FormBody.Builder()
                        .add("name", "d")
                        .add("ctrl", "false")
                        .add("meta", "false")
                        .add("shift", "false")
                        .add("sequence", "d")
                        .build();

                Request request = new Request.Builder()
                        .url(url)       // HTTPアクセス POST送信 テスト確認用ページ
                        .post(formBody)
                        .build();

                OkHttpClient client = new OkHttpClient();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        text = response.body().string();
                        redrawHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                ((TextView)findViewById(R.id.text02)).setText(text);
                            }
                        });
                    }
                });


            }
        });

        front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestBody formBody = new FormBody.Builder()
                        .add("name", "w")
                        .add("ctrl", "false")
                        .add("meta", "false")
                        .add("shift", "false")
                        .add("sequence", "w")
                        .build();

                Request request = new Request.Builder()
                        .url(url)       // HTTPアクセス POST送信 テスト確認用ページ
                        .post(formBody)
                        .build();

                OkHttpClient client = new OkHttpClient();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        text = response.body().string();
                        redrawHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                ((TextView)findViewById(R.id.text02)).setText(text);
                            }
                        });
                    }
                });


            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestBody formBody = new FormBody.Builder()
                        .add("name", "u")
                        .add("ctrl", "false")
                        .add("meta", "false")
                        .add("shift", "false")
                        .add("sequence", "u")
                        .build();

                Request request = new Request.Builder()
                        .url(url)       // HTTPアクセス POST送信 テスト確認用ページ
                        .post(formBody)
                        .build();

                OkHttpClient client = new OkHttpClient();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        text = response.body().string();
                        redrawHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                ((TextView)findViewById(R.id.text02)).setText(text);
                            }
                        });
                    }
                });


            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestBody formBody = new FormBody.Builder()
                        .add("name", "a")
                        .add("ctrl", "false")
                        .add("meta", "false")
                        .add("shift", "false")
                        .add("sequence", "a")
                        .build();

                Request request = new Request.Builder()
                        .url(url)       // HTTPアクセス POST送信 テスト確認用ページ
                        .post(formBody)
                        .build();

                OkHttpClient client = new OkHttpClient();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        text = response.body().string();
                        redrawHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                ((TextView)findViewById(R.id.text02)).setText(text);
                            }
                        });
                    }
                });


            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestBody formBody = new FormBody.Builder()
                        .add("name", "s")
                        .add("ctrl", "false")
                        .add("meta", "false")
                        .add("shift", "false")
                        .add("sequence", "s")
                        .build();

                Request request = new Request.Builder()
                        .url(url)       // HTTPアクセス POST送信 テスト確認用ページ
                        .post(formBody)
                        .build();

                OkHttpClient client = new OkHttpClient();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        text = response.body().string();
                        redrawHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                ((TextView)findViewById(R.id.text02)).setText(text);
                            }
                        });
                    }
                });


            }
        });

        turnleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestBody formBody = new FormBody.Builder()
                        .add("name", "m")
                        .add("ctrl", "false")
                        .add("meta", "false")
                        .add("shift", "false")
                        .add("sequence", "m")
                        .build();

                Request request = new Request.Builder()
                        .url(url)       // HTTPアクセス POST送信 テスト確認用ページ
                        .post(formBody)
                        .build();

                OkHttpClient client = new OkHttpClient();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        text = response.body().string();
                        redrawHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                ((TextView)findViewById(R.id.text02)).setText(text);
                            }
                        });
                    }
                });


            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestBody formBody = new FormBody.Builder()
                        .add("name", "z")
                        .add("ctrl", "false")
                        .add("meta", "false")
                        .add("shift", "false")
                        .add("sequence", "z")
                        .build();

                Request request = new Request.Builder()
                        .url(url)       // HTTPアクセス POST送信 テスト確認用ページ
                        .post(formBody)
                        .build();

                OkHttpClient client = new OkHttpClient();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        text = response.body().string();
                        redrawHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                ((TextView)findViewById(R.id.text02)).setText(text);
                            }
                        });
                    }
                });


            }
        });

        turnright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestBody formBody = new FormBody.Builder()
                        .add("name", "h")
                        .add("ctrl", "false")
                        .add("meta", "false")
                        .add("shift", "false")
                        .add("sequence", "h")
                        .build();

                Request request = new Request.Builder()
                        .url(url)       // HTTPアクセス POST送信 テスト確認用ページ
                        .post(formBody)
                        .build();

                OkHttpClient client = new OkHttpClient();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        text = response.body().string();
                        redrawHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                ((TextView)findViewById(R.id.text02)).setText(text);
                            }
                        });
                    }
                });


            }
        });


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Request request = new Request.Builder().url("http://172.31.6.94:4000").get().build();
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // nothing
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                text = response.body().string();
                redrawHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        ((TextView)findViewById(R.id.text02)).setText(text);
                    }
                });
            }
        });
        return super.onTouchEvent(event);
    }
}
