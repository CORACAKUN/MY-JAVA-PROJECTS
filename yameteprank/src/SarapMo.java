import javax.sound.sampled.*;

public class SarapMo {
    public static void main(String[] args) {
            String musicFilePath = "./ugh.wav";
        try {
            // Open an audio input stream
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    SarapMo.class.getResourceAsStream(musicFilePath));

            // Get the audio format of the music file
            AudioFormat audioFormat = audioInputStream.getFormat();

            // Create a data line info object for the SourceDataLine (part of the sound system)
            DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);

            // Open the data line using the specified audio format
            SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
            sourceDataLine.open(audioFormat);

            // Start playing the music
            sourceDataLine.start();

            // Create a buffer for reading audio data
            byte[] buffer = new byte[4096];
            int bytesRead = 0;

            // Read the audio data from the input stream and write it to the data line
            while ((bytesRead = audioInputStream.read(buffer)) != -1) {
                sourceDataLine.write(buffer, 0, bytesRead);
            }

            // Wait for the music to finish playing
            sourceDataLine.drain();
            sourceDataLine.stop();
            sourceDataLine.close();
            audioInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}