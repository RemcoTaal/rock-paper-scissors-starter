package domain;

import com.sun.jdi.connect.Connector;
import domain.rules.RockPaperScissors;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class RockPaperScissorsTest {

    private static Stream<Arguments> provideMovesAndResults(){
        return Stream.of(
                Arguments.of(Move.ROCK, Move.SCISSORS, Result.WIN),
                Arguments.of(Move.PAPER, Move.ROCK, Result.WIN),
                Arguments.of(Move.SCISSORS, Move.PAPER, Result.WIN),
                Arguments.of(Move.ROCK, Move.ROCK, Result.DRAW),
                Arguments.of(Move.PAPER, Move.PAPER, Result.DRAW),
                Arguments.of(Move.SCISSORS, Move.SCISSORS, Result.DRAW),
                Arguments.of(Move.ROCK, Move.PAPER, Result.LOSE),
                Arguments.of(Move.PAPER, Move.SCISSORS, Result.LOSE),
                Arguments.of(Move.SCISSORS, Move.ROCK, Result.LOSE)
        );
    }


    @ParameterizedTest
    @MethodSource("provideMovesAndResults")
    void verifyMovesAndResults(Move mine, Move theirs, Result expectedResult){
        Rules game = new RockPaperScissors();
        Result result = game.decide(mine, theirs);
        assertEquals(result, expectedResult);
    }

    //Prove i did the unit tests
//    @Test
//    @DisplayName("Rock crushes scissors")
//    public void rockCrushesScissors() {
//        Rules game = new RockPaperScissors();
//        Result result = game.decide(Move.ROCK, Move.SCISSORS);
//        assertEquals(Result.WIN, result);
//    }
//
//    @Test
//    @DisplayName("Scissors cuts Paper")
//    public void scissorsCutsPaper(){
//        Rules game = new RockPaperScissors();
//        Result result = game.decide(Move.SCISSORS, Move.PAPER);
//        assertEquals(Result.WIN, result);
//    }
//
//    @Test
//    @DisplayName("Paper covers Rock")
//    public void paperCoversRock(){
//        Rules game = new RockPaperScissors();
//        Result result = game.decide(Move.PAPER, Move.ROCK);
//        assertEquals(Result.WIN, result);
//    }


}
