package game;

import com.fasterxml.jackson.databind.ObjectMapper;
import game.model.HighScores;
import game.model.Maze;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Class responsible for loading mazes and high scores.
 */
public class FileLoader {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static Maze level;

    private static HighScores highScores;

    /**
     * Loads the information about the maze.
     */
    public static void loadLevel() throws IOException {
        level = OBJECT_MAPPER.readValue(
            FileLoader.class.getResourceAsStream("level.json"), Maze.class
        );
    }

    /**
     * Loads the high scores.
     */
    public static void loadHighScores(String path) throws IOException {
        highScores = OBJECT_MAPPER.readValue(
                Files.readString(Path.of(path)), HighScores.class
        );
    }

    /**
     * Returns the loaded information about the maze.
     *
     * @return The loaded information about the maze
     */
    public static Maze getLevel() {
        return level;
    }

    /**
     * Returns the loaded high scores.
     *
     * @return The loaded high scores
     */
    public static HighScores getHighScores() {
        return highScores;
    }
}
