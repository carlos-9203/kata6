package tests;

import org.junit.Test;
import software.ulpg.kata6.Board;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static tests.BoardTest.Cases.*;

public class BoardTest {
    @Test
    public void should_return_empty_board_given_empty_board(){
        String state = new Board("").next().state();
        assertThat(state).isEqualTo("");
    }

    @Test
    public void should_return_board_1x1_with_a_dead_cell_given_board_1x1_with_a_dead_cell(){
        String state = new Board(".").next().state();
        assertThat(state).isEqualTo(".");
    }
    @Test
    public void should_return_board_1x1_with_a_dead_cell_given_board_1x1_with_a_alive_cell(){
        String state = new Board("X").next().state();
        assertThat(state).isEqualTo(".");
    }

    @Test
    public void should_return_board_2x2_with_all_alive_cell_given_board_2x2_with_all_alive_cell(){
        String state = new Board(board_2x2_all_alive_cells).next().state();
        assertThat(state).isEqualTo(board_2x2_all_alive_cells);
    }

    @Test
    public void should_return_board_2x2_with_all_alive_cell_given_board_2x2_with_on_alive_cell(){
        String state = new Board(board_2x2_with_on_alive_cells).next().state();
        assertThat(state).isEqualTo(board_2x2_all_dead_cells);
    }
    @Test
    public void should_return_board_2x2_with_all_alive_cell_given_board_2x2_with_triangle_structure(){
        String state = new Board(board_2x2_with_triangle_structure).next().state();
        assertThat(state).isEqualTo(board_2x2_all_alive_cells);
    }

    @Test
    public void should_return_board_3x3_with_all_alive_cell_in_corners_given_board_3x3_with_all_alive_cell(){
        String state = new Board(board_3x3_all_alive_cells).next().state();
        assertThat(state).isEqualTo(board_3x3_with_alive_cells_in_corners);
    }


    public static class Cases{
        public static final String board_2x2_all_alive_cells = """
                XX
                XX
                """.trim();
        public static final String board_2x2_all_dead_cells = """
                ..
                ..
                """.trim();
        public static final String board_2x2_with_on_alive_cells = """
                ..
                X.
                """.trim();
        public static final String board_2x2_with_triangle_structure = """
                XX
                .X
                """.trim();

        public static final String board_3x3_all_alive_cells = """
                XXX
                XXX
                XXX
                """.trim();
        public static final String board_3x3_with_alive_cells_in_corners = """
                X.X
                ...
                X.X
                """.trim();
    }

}
