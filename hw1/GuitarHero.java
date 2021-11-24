import synthesizer.GuitarString;

public class GuitarHero {
    private static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    public static void main(String[] args) {
        GuitarString[] guitar = new GuitarString[37];
        for (int i = 0; i < 37; i++) {
            guitar[i] = new synthesizer.GuitarString(440 * Math.pow(2, (i - 24.0) / 12.0));
        }
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                for (int i = 0; i < 37; i++) {
                    if (key == keyboard.charAt(i)) {
                        guitar[i].pluck();
                    }
                }
            }
            double sample = 0.0;
            for (int i = 0; i < 37; i++) {
                sample += guitar[i].sample();
                guitar[i].tic();
            }
            StdAudio.play(sample);
        }

    }
}
