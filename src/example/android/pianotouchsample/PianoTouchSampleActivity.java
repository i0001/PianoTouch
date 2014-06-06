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

//�s�A�m���Activity
@SuppressLint("Recycle")
public class PianoTouchSampleActivity extends Activity implements Runnable{
	public static final double EIGHTH_NOTE = 0.125;
    public static final double FORTH_NOTE = 0.25;
    public static final double HALF_NOTE = 0.5;
    public static final double WHOLE_NOTE = 1.0;

    // Sound�����N���X
    private DigitalSoundGenerator soundGenerator;
    // Sound�Đ��N���X
    private AudioTrack audioTrack;
    // ���ʃf�[�^
    private List<SoundDto> soundList = new ArrayList<SoundDto>();

    /**
     * ���ʃf�[�^���쐬
     */
    private void initScoreData() {
        // ���ʃf�[�^�쐬
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

 // �������Ր����`����萔
 private static final int WHITE_KEY_NUMBER = 12;
 // �������Ր����`����萔
 private static final int BLACK_KEY_NUMBER = 8;

 // �����E���������Đ��pMediaPlayer�z��̏�����
 private MediaPlayer[] whiteKeyPlayer;
 private MediaPlayer[] blackKeyPlayer;

 // onCreate���\�b�h(��ʏ����\���C�x���g)
 private Button m_button;

 @SuppressLint({ "NewApi", "Recycle" })
 @Override
 public void onCreate(Bundle savedInstanceState) {

     super.onCreate(savedInstanceState);

     // ���C�A�E�gXML�̐ݒ�
     setContentView(R.layout.pianotouchsample);

  // SoundGenerator�N���X���T���v�����[�g44100�ō쐬
     soundGenerator = new DigitalSoundGenerator(44100, 44100);

     // �����Đ��pAudioTrack�́A�����T���v�����[�g�ŏ������������̂𗘗p����
     audioTrack = soundGenerator.getAudioTrack();

  // �����Đ��{�^���̎擾
     m_button = (Button)findViewById(R.id.autoplay_btn);

     // �����Đ��{�^�����������Ƃ��̃C�x���g
     m_button.setOnClickListener(new OnClickListener(){
         public void onClick(View v){
             // �Đ�
             Thread th = new Thread(PianoTouchSampleActivity.this);
             th.start();
         }
     });

     // �X�R�A�f�[�^���쐬
     initScoreData();

     // �����E���������Đ��pMediaPlayer�z��̏�����
     whiteKeyPlayer = new MediaPlayer[WHITE_KEY_NUMBER];
     blackKeyPlayer = new MediaPlayer[BLACK_KEY_NUMBER];

     // ���\�[�X�t�@�C�����甒�������pmidi�t�@�C���ǂݍ���
     TypedArray mids =
         getResources().obtainTypedArray(R.array.mids_whiteKey);

     for (int i = 0; i < mids.length(); i++) {
         int mds = mids.getResourceId(i, -1);
         if (mds != -1) {
             whiteKeyPlayer[i] = MediaPlayer.create(this, mds);
         }
     }

     // ���\�[�X�t�@�C�����獕�������pmidi�t�@�C���ǂݍ���
     mids = getResources().obtainTypedArray(R.array.mids_blackKey);

     for (int i = 0; i < mids.length(); i++) {
         int mds = mids.getResourceId(i, -1);
         if (mds != -1) {
             blackKeyPlayer[i] = MediaPlayer.create(this, mds);
         }
     }

     // ���C�A�E�gXML��蔒���̃��C�A�E�g���擾���A�^�b�`�C�x���g��o�^
     LinearLayout keyWhiteLayout =
         (LinearLayout) findViewById(R.id.layout_key_white);

     // �擾�������C�A�E�g���甒���L�[(�{�^��)�ɂP���^�b�`�C�x���g��o�^
     for (int i = 0; i < keyWhiteLayout.getChildCount(); i++) {
         ImageButton keyWhiteBtn =
             (ImageButton) keyWhiteLayout.getChildAt(i);

         keyWhiteBtn.setOnTouchListener(new ButtonTouchListener(
             whiteKeyPlayer[i], R.drawable.k_w, R.drawable.k_w_p));
     }

     // ���C�A�E�gXML��荕����view���擾���A�^�b�`�C�x���g��o�^
     LinearLayout keyBlackLayout =
         (LinearLayout) findViewById(R.id.layout_key_black);

     // �擾�������C�A�E�g���甒���L�[(�{�^��)�ɂP���^�b�`�C�x���g��o�^
     for (int i = 0; i < keyBlackLayout.getChildCount(); i++) {
         ImageButton keyBlackBtn =
             (ImageButton) keyBlackLayout.getChildAt(i);

         keyBlackBtn.setOnTouchListener(new ButtonTouchListener(
             blackKeyPlayer[i], R.drawable.k_b, R.drawable.k_b_p));
     }

     // �{�����[���{�^���Ń��f�B�A�̉��ʒ����ɐݒ�
     setVolumeControlStream(AudioManager.STREAM_MUSIC);
 }

 // onDestroy���\�b�h(�A�N�e�B�r�e�B�j���C�x���g)
 @Override
 public void onDestroy() {
     super.onDestroy();
     // ���������Đ��pMediaPlayer�̉��
     for (int i = 0; i < whiteKeyPlayer.length; i++) {
         if (whiteKeyPlayer[i].isPlaying()) {
             whiteKeyPlayer[i].stop();
         }
         whiteKeyPlayer[i].release();
     }

     // ���������Đ��pMediaPlayer�̉��
     for (int i = 0; i < blackKeyPlayer.length; i++) {
         if (blackKeyPlayer[i].isPlaying()) {
             blackKeyPlayer[i].stop();
         }
         blackKeyPlayer[i].release();
     }

  // �Đ������������~���ă����[�X
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
  * �W�r�b�g�̃s�R�s�R���𐶐�����.
  * @param gen Generator
  * @param freq ���g��(���K)
  * @param length ���̒���
  * @return ���f�[�^
  */
 public byte[] generateSound(DigitalSoundGenerator gen, double freq, double length) {
     return gen.getSound(freq, length);
 }

 /**
  * �����f�[�^���쐬����
  * @param gen Generator
  * @param length �����f�[�^�̒���
  * @return �����f�[�^
  */
 public byte[] generateEmptySound(DigitalSoundGenerator gen, double length) {
     return gen.getEmptySound(length);
 }

 @Override
 public void run() {

     // �Đ����Ȃ��U�~�߂�
     if(audioTrack.getPlayState() == AudioTrack.PLAYSTATE_PLAYING) {
         audioTrack.stop();
         audioTrack.reloadStaticData();
     }
     // �Đ��J�n
     audioTrack.play();

     // �X�R�A�f�[�^����������
     for(SoundDto dto : soundList) {
         audioTrack.write(dto.getSound(), 0, dto.getSound().length);
     }
     // �Đ���~
     audioTrack.stop();
 }
}