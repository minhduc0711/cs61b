import synthesizer.GuitarString;

public class GuitarHero {
    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] guitarStrings = new GuitarString[keyboard.length()];
        for (int i = 0; i < keyboard.length(); i += 1) {
            guitarStrings[i] = new GuitarString(440 * Math.pow(2, (float) (i-24) / 12));
        }

        while (true) {
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int keyIndex = keyboard.indexOf(key);
                if (keyIndex != -1) {
                    guitarStrings[keyIndex].pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = 0.0;
            for (GuitarString gs : guitarStrings) {
                sample += gs.sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (GuitarString gs : guitarStrings) {
                gs.tic();
            }
        }
    }
}
