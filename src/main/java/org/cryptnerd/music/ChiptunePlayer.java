package org.cryptnerd.music;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class ChiptunePlayer {

    // Define standard audio settings
    private static final int SAMPLE_RATE = 44100; 
    private static final int BYTES_PER_SAMPLE = 1; // 8-bit audio for that retro crunch

    public static void main(String[] args) {
        // Setup standard 8-bit mono audio format
        AudioFormat format = new AudioFormat(SAMPLE_RATE, BYTES_PER_SAMPLE * 8, 1, true, false);
        
        try (SourceDataLine line = AudioSystem.getSourceDataLine(format)) {
            line.open(format);
            line.start();

            System.out.println("Playing your custom melody...");

            // Define a simple musical sequence (Frequencies in Hz)
            // C4=261.63, E4=329.63, G4=392.00, C5=523.25
            double[] melody = {261.63, 329.63, 392.00, 523.25, 392.00, 523.25};
            int durationMs = 300; // Duration of each note in milliseconds

            // Loop through the notes to play the melody
            for (double frequency : melody) {
                playNote(line, frequency, durationMs);
            }

            line.drain(); // Wait for audio to finish playing
        } catch (LineUnavailableException e) {
            System.err.println("Audio line unavailable: " + e.getMessage());
        }
    }

    /**
     * Synthesizes and plays a single raw sine wave note.
     */
    private static void playNote(SourceDataLine line, double frequency, int durationMs) {
        int numSamples = (SAMPLE_RATE * durationMs) / 1000;
        byte[] buffer = new byte[numSamples];

        for (int i = 0; i < numSamples; i++) {
            // Math formula to generate a continuous wave: angle = 2 * PI * i * freq / sample_rate
            double angle = 2.0 * Math.PI * i * frequency / SAMPLE_RATE;
            
            // Generate sine wave value between -127 and 127
            double sampleValue = Math.sin(angle) * 127.0;
            
            // Fade out the note slightly at the end to prevent harsh popping clicks
            if (i > numSamples - 1000) {
                double fade = (double) (numSamples - i) / 1000.0;
                sampleValue *= fade;
            }

            buffer[i] = (byte) sampleValue;
        }

        // Send the raw wave bytes directly to the sound card
        line.write(buffer, 0, buffer.length);
    }
}

