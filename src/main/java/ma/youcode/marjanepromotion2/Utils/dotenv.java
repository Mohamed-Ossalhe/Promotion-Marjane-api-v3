package ma.youcode.marjanepromotion2.Utils;

import io.github.cdimascio.dotenv.Dotenv;

import java.util.logging.Logger;

public class dotenv {
    volatile private static Dotenv dotenv = null;

    static {
        Logger.getLogger(ma.youcode.marjanepromotion2.Utils.dotenv.class.getName()).info("Loading environment variables ...");
        synchronized (ma.youcode.marjanepromotion2.Utils.dotenv.class) {
            if (dotenv == null) {
                dotenv = Dotenv.configure()
                        .ignoreIfMalformed()
                        .ignoreIfMissing()
                        .load();
            }
        }
    }

    /**
     * Get the value of an environment variable by its key.
     *
     * @param key The key of the environment variable.
     * @return The value of the environment variable, or null if not found.
     */
    public static String get(String key) {
        return dotenv.get(key);
    }
}
