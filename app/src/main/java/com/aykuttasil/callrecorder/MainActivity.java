package com.aykuttasil.callrecorder;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.View;

import com.aykuttasil.callrecord.CallRecord;
import com.aykuttasil.callrecord.helper.LogUtils;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getSimpleName();

    CallRecord callRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //callRecord = CallRecord.init(this);
        callRecord = new CallRecord.Builder(this)
                .setLogEnable(true)
                .setRecordFileName("CallRecorderTestFile")
                .setRecordDirName("CallRecorderTest")
                .setAudioSource(MediaRecorder.AudioSource.VOICE_COMMUNICATION)
                .setShowSeed(true)
                .build();

        //callRecord.changeReceiver(new MyCallRecordReceiver(callRecord));

        //callRecord.enableSaveFile();

        /*
        callRecord = new CallRecord.Builder(this)
                .setRecordFileName("Record_" + new SimpleDateFormat("ddMMyyyyHHmmss", Locale.US).format(new Date()))
                .setRecordDirName("CallRecord")
                .setRecordDirPath(Environment.getExternalStorageDirectory().getPath())
                .setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
                .setOutputFormat(MediaRecorder.OutputFormat.AMR_NB)
                .setAudioSource(MediaRecorder.AudioSource.VOICE_COMMUNICATION)
                .setShowSeed(true)
                .buildService();

        callRecord.startCallRecordService();
        */
    }

    public void StartCallRecordClick(View view) {
        LogUtils.i(TAG, "StartCallRecordClick");
        callRecord.startCallReceiver();

        //callRecord.enableSaveFile();
        //callRecord.changeRecordDirName("NewDirName");
    }

    public void StopCallRecordClick(View view) {
        LogUtils.i(TAG, "StopCallRecordClick");
        callRecord.stopCallReceiver();

        //callRecord.disableSaveFile();
        //callRecord.changeRecordFileName("NewFileName");
    }

}
