package kr.co.tjeit.bluetoothpracetice;

import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class DeviceListActivity extends BaseActivity {

    private BluetoothAdapter mBtAdapter;
    private android.widget.Button scanBtn;
    private android.widget.ListView newDeviceListView;
    private android.widget.ListView pairedDeviceListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_list);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                탐색을 시작
                doDiscovery();

//                탐색이 진행중일땐 다시 탐색을 시작할 수 없도록.
                scanBtn.setVisibility(View.GONE);

            }
        });
    }


//    주변의 블루투스 기기를 탐색.

    void doDiscovery() {

//        1. 새 기기 목록 리스트뷰를 표시, 패어링 된 목록 리스트 숨김.

        newDeviceListView.setVisibility(View.VISIBLE);
        pairedDeviceListView.setVisibility(View.GONE);

//        만약, 이미 기기 탐색을 진행중이라면, 진행중이던 요청은 취소.

        if (mBtAdapter.isDiscovering()) {
            mBtAdapter.cancelDiscovery();
        }

        mBtAdapter.startDiscovery();

    }

    @Override
    public void setValues() {



    }

    @Override
    public void bindViews() {

        this.pairedDeviceListView = (ListView) findViewById(R.id.pairedDeviceListView);
        this.newDeviceListView = (ListView) findViewById(R.id.newDeviceListView);
        this.scanBtn = (Button) findViewById(R.id.scanBtn);
    }
}
