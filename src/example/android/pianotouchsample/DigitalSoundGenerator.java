package example.android.pianotouchsample;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;

/**
 * �s�R�s�R�����쐬����
 */
public class DigitalSoundGenerator {

    // �Ƃ肠�����P�I�N�^�[�u���̉��K���m�ہi�����K�܂ށj
    public static final double FREQ_A  = 220.0;
    public static final double FREQ_As = 233.081880;
    public static final double FREQ_B  = 246.941650;
    public static final double FREQ_C  = 261.625565;
    public static final double FREQ_Cs = 277.182630;
    public static final double FREQ_D  = 293.664767;
    public static final double FREQ_Ds = 311.126983;
    public static final double FREQ_E  = 329.627556;
    public static final double FREQ_F  = 349.228231;
    public static final double FREQ_Fs = 369.994227;
    public static final double FREQ_G  = 391.994535;
    public static final double FREQ_Gs = 415.304697;
//  public static final double FREQ_A  = 440.0;
//  public static final double FREQ_As = 466.163761;
//  public static final double FREQ_B  = 493.883301;

    private AudioTrack audioTrack;

    // �T���v�����O���g��
    private int sampleRate;
    // �o�b�t�@�E�T�C�Y
    private int bufferSize;

    /**
     * �R���X�g���N�^
     */
    public DigitalSoundGenerator(int sampleRate, int bufferSize) {
        this.sampleRate = sampleRate;
        this.bufferSize = bufferSize;

        // AudioTrack���쐬
        this.audioTrack = new AudioTrack(
                AudioManager.STREAM_MUSIC,  // ���y�X�g���[����ݒ�
                sampleRate, // �T���v�����[�g
                AudioFormat.CHANNEL_OUT_MONO,   // ���m����
                AudioFormat.ENCODING_DEFAULT,   // �I�[�f�B�I�f�[�^�t�H�[�}�b�gPCM16�Ƃ�PCM8�Ƃ�
                bufferSize, // �o�b�t�@�E�T�C�Y
                AudioTrack.MODE_STREAM); // Stream���[�h�B�f�[�^�������Ȃ���Đ�����
    }

    /**
     * �T�E���h����
     * @param frequency �炵�������̎��g��
     * @param soundLengh ���̒���
     * @return �����f�[�^
     */
    public byte[] getSound(double frequency, double soundLength) {
        // byte�o�b�t�@���쐬
        byte[] buffer = new byte[(int)Math.ceil(bufferSize * soundLength)];
        for(int i=0; i<buffer.length; i++) {
            double wave = i / (this.sampleRate / frequency) * (Math.PI * 2);
            wave = Math.sin(wave);
            buffer[i] = (byte)(wave > 0.0 ? Byte.MAX_VALUE : Byte.MIN_VALUE);
        }

        return buffer;
    }

    /**
     * ������x��
     * @param frequency
     * @param soundLength
     * @return �����f�[�^
     */
    public byte[] getEmptySound(double soundLength) {
        byte[] buff = new byte[(int)Math.ceil(bufferSize * soundLength)];

        for(int i=0; i<buff.length; i++) {
            buff[i] = (byte)0;
        }
        return buff;
    }

    /**
     *
     * @return
     */
    public AudioTrack getAudioTrack() {
        return this.audioTrack;
    }
}
