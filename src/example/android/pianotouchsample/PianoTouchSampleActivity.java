package example.android.pianotouchsample;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.TypedArray;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

//ピアノ画面Activity
@SuppressLint("Recycle")
public class PianoTouchSampleActivity extends Activity implements Runnable{
	public static final double EIGHTH_NOTE = 0.125;
    public static final double FORTH_NOTE = 0.25;
    public static final double HALF_NOTE = 0.5;
    public static final double WHOLE_NOTE = 1.0;

    // Sound生成クラス
    private DigitalSoundGenerator soundGenerator;
    // Sound再生クラス
    private AudioTrack audioTrack;
    // 譜面データ
    private List<SoundDto> soundList = new ArrayList<SoundDto>();

    /**
     * 譜面データを作成
     */
    private void initScoreData() {
        // 譜面データ作成
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, WHOLE_NOTE), WHOLE_NOTE));
        soundList.add(new SoundDto(generateEmptySound(soundGenerator, EIGHTH_NOTE), EIGHTH_NOTE));

        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, WHOLE_NOTE), WHOLE_NOTE));
        soundList.add(new SoundDto(generateEmptySound(soundGenerator, EIGHTH_NOTE), EIGHTH_NOTE));

        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_G, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_C, WHOLE_NOTE), WHOLE_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_D, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, WHOLE_NOTE), WHOLE_NOTE));
        soundList.add(new SoundDto(generateEmptySound(soundGenerator, FORTH_NOTE), FORTH_NOTE));

        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_F, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_F, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_F, WHOLE_NOTE), WHOLE_NOTE));
        soundList.add(new SoundDto(generateEmptySound(soundGenerator, FORTH_NOTE), FORTH_NOTE));

        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_F, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, WHOLE_NOTE), WHOLE_NOTE));

        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_D, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_D, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_D, WHOLE_NOTE), WHOLE_NOTE));

        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_G, WHOLE_NOTE), WHOLE_NOTE));
        soundList.add(new SoundDto(generateEmptySound(soundGenerator, HALF_NOTE), HALF_NOTE));


        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, WHOLE_NOTE), WHOLE_NOTE));
        soundList.add(new SoundDto(generateEmptySound(soundGenerator, EIGHTH_NOTE), EIGHTH_NOTE));

        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, WHOLE_NOTE), WHOLE_NOTE));
        soundList.add(new SoundDto(generateEmptySound(soundGenerator, EIGHTH_NOTE), EIGHTH_NOTE));

        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_G, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_C, WHOLE_NOTE), WHOLE_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_D, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, 3), 3));
        soundList.add(new SoundDto(generateEmptySound(soundGenerator, FORTH_NOTE), FORTH_NOTE));

        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_F, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_F, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_F, WHOLE_NOTE), WHOLE_NOTE));
        soundList.add(new SoundDto(generateEmptySound(soundGenerator, EIGHTH_NOTE), EIGHTH_NOTE));

        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_F, EIGHTH_NOTE), EIGHTH_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_F, EIGHTH_NOTE), EIGHTH_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_E, WHOLE_NOTE), WHOLE_NOTE));

        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_G, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_G, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_F, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_D, HALF_NOTE), HALF_NOTE));
        soundList.add(new SoundDto(generateSound(soundGenerator, DigitalSoundGenerator.FREQ_C, WHOLE_NOTE), WHOLE_NOTE));
    }

 // 白鍵鍵盤数を定義する定数
 private static final int WHITE_KEY_NUMBER = 12;
 // 黒鍵鍵盤数を定義する定数
 private static final int BLACK_KEY_NUMBER = 8;

 // 白鍵・黒鍵音声再生用MediaPlayer配列の初期化
 private MediaPlayer[] whiteKeyPlayer;
 private MediaPlayer[] blackKeyPlayer;

 // onCreateメソッド(画面初期表示イベント)
 private Button m_button;

 @SuppressLint({ "NewApi", "Recycle" })
 @Override
 public void onCreate(Bundle savedInstanceState) {

     super.onCreate(savedInstanceState);

     // レイアウトXMLの設定
     setContentView(R.layout.pianotouchsample);

  // SoundGeneratorクラスをサンプルレート44100で作成
     soundGenerator = new DigitalSoundGenerator(44100, 44100);

     // 自動再生用AudioTrackは、同じサンプルレートで初期化したものを利用する
     audioTrack = soundGenerator.getAudioTrack();

  // 自動再生ボタンの取得
     m_button = (Button)findViewById(R.id.autoplay_btn);

     // 自動再生ボタンを押したときのイベント
     m_button.setOnClickListener(new OnClickListener(){
         public void onClick(View v){
             // 再生
             Thread th = new Thread(PianoTouchSampleActivity.this);
             th.start();
         }
     });

     // スコアデータを作成
     initScoreData();

     // 白鍵・黒鍵音声再生用MediaPlayer配列の初期化
     whiteKeyPlayer = new MediaPlayer[WHITE_KEY_NUMBER];
     blackKeyPlayer = new MediaPlayer[BLACK_KEY_NUMBER];

     // リソースファイルから白鍵音声用midiファイル読み込み
     TypedArray mids =
         getResources().obtainTypedArray(R.array.mids_whiteKey);

     for (int i = 0; i < mids.length(); i++) {
         int mds = mids.getResourceId(i, -1);
         if (mds != -1) {
             whiteKeyPlayer[i] = MediaPlayer.create(this, mds);
         }
     }

     // リソースファイルから黒鍵音声用midiファイル読み込み
     mids = getResources().obtainTypedArray(R.array.mids_blackKey);

     for (int i = 0; i < mids.length(); i++) {
         int mds = mids.getResourceId(i, -1);
         if (mds != -1) {
             blackKeyPlayer[i] = MediaPlayer.create(this, mds);
         }
     }

     // レイアウトXMLより白鍵のレイアウトを取得し、タッチイベントを登録
     LinearLayout keyWhiteLayout =
         (LinearLayout) findViewById(R.id.layout_key_white);

     // 取得したレイアウトから白鍵キー(ボタン)に１つずつタッチイベントを登録
     for (int i = 0; i < keyWhiteLayout.getChildCount(); i++) {
         ImageButton keyWhiteBtn =
             (ImageButton) keyWhiteLayout.getChildAt(i);

         keyWhiteBtn.setOnTouchListener(new ButtonTouchListener(
             whiteKeyPlayer[i], R.drawable.k_w, R.drawable.k_w_p));
     }

     // レイアウトXMLより黒鍵のviewを取得し、タッチイベントを登録
     LinearLayout keyBlackLayout =
         (LinearLayout) findViewById(R.id.layout_key_black);

     // 取得したレイアウトから白鍵キー(ボタン)に１つずつタッチイベントを登録
     for (int i = 0; i < keyBlackLayout.getChildCount(); i++) {
         ImageButton keyBlackBtn =
             (ImageButton) keyBlackLayout.getChildAt(i);

         keyBlackBtn.setOnTouchListener(new ButtonTouchListener(
             blackKeyPlayer[i], R.drawable.k_b, R.drawable.k_b_p));
     }

     // ボリュームボタンでメディアの音量調整に設定
     setVolumeControlStream(AudioManager.STREAM_MUSIC);
 }

 // onDestroyメソッド(アクティビティ破棄イベント)
 @Override
 public void onDestroy() {
     super.onDestroy();
     // 白鍵音声再生用MediaPlayerの解放
     for (int i = 0; i < whiteKeyPlayer.length; i++) {
         if (whiteKeyPlayer[i].isPlaying()) {
             whiteKeyPlayer[i].stop();
         }
         whiteKeyPlayer[i].release();
     }

     // 黒鍵音声再生用MediaPlayerの解放
     for (int i = 0; i < blackKeyPlayer.length; i++) {
         if (blackKeyPlayer[i].isPlaying()) {
             blackKeyPlayer[i].stop();
         }
         blackKeyPlayer[i].release();
     }

  // 再生中だったら停止してリリース
     if(audioTrack.getPlayState() == AudioTrack.PLAYSTATE_PLAYING) {
         audioTrack.stop();
         audioTrack.release();
     }
 }

 @Override
 protected void onPause() {
     super.onPause();
 }



 @Override
 protected void onResume() {
     super.onResume();
 }

 @Override
 public boolean onCreateOptionsMenu(Menu menu) {
     // Inflate the menu; this adds items to the action bar if it is present.
     getMenuInflater().inflate(R.menu.activity_main, menu);
     return true;
 }

 /**
  * ８ビットのピコピコ音を生成する.
  * @param gen Generator
  * @param freq 周波数(音階)
  * @param length 音の長さ
  * @return 音データ
  */
 public byte[] generateSound(DigitalSoundGenerator gen, double freq, double length) {
     return gen.getSound(freq, length);
 }

 /**
  * 無音データを作成する
  * @param gen Generator
  * @param length 無音データの長さ
  * @return 無音データ
  */
 public byte[] generateEmptySound(DigitalSoundGenerator gen, double length) {
     return gen.getEmptySound(length);
 }

 @Override
 public void run() {

     // 再生中なら一旦止める
     if(audioTrack.getPlayState() == AudioTrack.PLAYSTATE_PLAYING) {
         audioTrack.stop();
         audioTrack.reloadStaticData();
     }
     // 再生開始
     audioTrack.play();

     // スコアデータを書き込む
     for(SoundDto dto : soundList) {
         audioTrack.write(dto.getSound(), 0, dto.getSound().length);
     }
     // 再生停止
     audioTrack.stop();
 }
}