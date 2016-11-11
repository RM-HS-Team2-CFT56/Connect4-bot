package se.sigmatechnology.connect4.bot;

import org.apache.commons.cli.CommandLine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import se.sigmatechnology.connect4.bot.ai.RandomAI;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;
import static se.sigmatechnology.connect4.bot.State.*;

/**
 * Created by msk on 2016-11-11.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainTest {

    @Mock
    GameClient client;

    @Spy
    Board board = new Board();

    @Mock
    RandomAI ai;

    @Mock
    CommandLine commandLine;

    @InjectMocks
    Main main;

    @Test
    public void testWorkflow() throws Exception {
        when(client.connect(anyString())).thenReturn(true);
        when(client.getState()).thenReturn(WAITING_FOR_PLAYER,
                YOUR_TURN, OPPONENTS_TURN, OPPONENTS_TURN,
                YOUR_TURN, OPPONENTS_TURN,
                YOUR_TURN, WON);
        when(client.getLastTurn()).thenReturn(6);
        when(client.enterDisk(anyInt())).thenReturn("OK");
        when(ai.getNextTurn(any(Board.class))).thenReturn(1);
        main.run(new String[]{});


    }

}
