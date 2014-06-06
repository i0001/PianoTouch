package example.android.pianotouchsample;
public class SoundDto {

    // �����f�[�^
    private byte[] sound;
    // ����
    private double length;

    /**
     * �����t���R���X�g���N�^
     * @param source
     * @param length
     */
    public SoundDto(byte[] source, double length) {
        this.sound = source;
        this.length = length;
    }

    public byte[] getSound() {
        return sound;
    }
    public void setSound(byte[] sound) {
        this.sound = sound;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
}