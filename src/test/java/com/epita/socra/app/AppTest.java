package com.epita.socra.app;

import org.junit.Test;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.epita.socra.app.tools.IOAdapter;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test.
     */
    /*
    @Test
    public void givenAMock_WhenRunningMain_ThenCheckOuputs() {
        IOAdapter mock = mock(IOAdapter.class);
        when(mock.read()).thenReturn("TEST");
        App app = new App(mock);
        app.run();

        verify(mock).write("Hello, what's your name ?");
        verify(mock).write(argThat(message -> message.contains("TEST")));
    }

*/
    @Test
    public void givenAGoodNumber_ArabicToRoman() {
        IOAdapter mock = mock(IOAdapter.class);
        //when(mock.read()).thenReturn("Arabic");
        when(mock.read()).thenReturn("3000");
        App app = new App(mock);
        app.runInArabic();

        verify(mock).write("Enter your number : ");
        verify(mock).write(argThat(message -> message.contains("MMM")));
    }

    @Test
    public void givenAGoodNumber_RomanToArabic() {
        IOAdapter mock = mock(IOAdapter.class);
        when(mock.read()).thenReturn("MMM");
        App app = new App(mock);
        app.runInRoman();

        verify(mock).write("Enter your number : ");
        verify(mock).write(argThat(message -> message.contains("3000")));
    }

    @Test
    public void givenAGoodNumber_bad_type() {
        IOAdapter mock = mock(IOAdapter.class);
        when(mock.read()).thenReturn("African");
        App app = new App(mock);
        app.run();

        verify(mock).write(argThat(message -> message.contains("Bad conversion type !")));
    }

    @Test
    public void givenABadNumber_RomanToArabic() {
        IOAdapter mock = mock(IOAdapter.class);
        when(mock.read()).thenReturn("MM124");
        App app = new App(mock);
        app.runInRoman();

        verify(mock).write("Enter your number : ");
        verify(mock).write(argThat(message -> message.contains("null")));
    }

    @Test
    public void givenABadNumber_ArabicToRoman() {
        IOAdapter mock = mock(IOAdapter.class);
        when(mock.read()).thenReturn("3001");
        App app = new App(mock);
        app.runInArabic();

        verify(mock).write("Enter your number : ");
        verify(mock).write(argThat(message -> message.contains("null")));
    }
}

