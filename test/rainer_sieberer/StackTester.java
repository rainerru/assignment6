package rainer_sieberer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class StackTester {

    private LIFO stack;
    private int repetition;

    @BeforeEach
    void init(RepetitionInfo repInfo)
    {
        this.repetition = repInfo.getCurrentRepetition();
        // convention: even to test stacklist, odd to test stackarray;
        if ( this.repetition % 2 == 0 )
        {
            this.stack = new StackList<Double>();
            this.repetition = (int) Math.pow(this.repetition-1,4);
            System.out.println("Testing StackList implementation of the LIFO interface");
        } else
        {
            this.stack = new StackArray<Double>();
            this.repetition = (int) Math.pow(this.repetition-1,4);
            System.out.println("Testing StackArray implementation of the LIFO interface");
        }

    }

    @RepeatedTest(2)
    void testPopOnEmptyStack()
    {
        // testing both implementations of the stack
        assertThrows(EmptyStackException.class, ()->this.stack.pop());
    }

    @RepeatedTest(2)
    void testEmptyCheck()
    {
        // testing both implementations of the stack
        assertTrue(this.stack.empty());
    }

    @RepeatedTest(6)
    @DisplayName("testing push and pop")
    void testPushAndPop()
    {
        // testing with 1, 81 and 625 elements, both implementations of the stack
        for ( int i = 0; i < repetition; i ++)
            this.stack.push(new Double(i));
        for ( int i = 0; i < repetition; i ++)
            System.out.println( this.stack.pop() );
    }

    @RepeatedTest(6)
    @DisplayName("testing the peek method")
    void testPeek()
    {
        // testing with 3, 83 and 627 elements, both implementations of the stack
        for ( int i = 0; i < repetition; i ++)
            this.stack.push(new Double(i));
        this.stack.push(new Double(564897118.45897));
        this.stack.push(new Double(1.0));
        this.stack.pop();
        assertTrue( this.stack.peek().equals(new Double(564897118.45897)));
    }

    @RepeatedTest(2)
    @DisplayName("peeking an empty stack")
    void peekWithEmptyStack()
    {
        // testing both implementations of the stack
        assertThrows(EmptyStackException.class, ()->this.stack.peek());
    }

    @RepeatedTest(6)
    @DisplayName("testing getSize")
    void testGetSize()
    {
        // testing with 1, 81 and 625 elements, both implementations of the stack
        for ( int i = 0; i < repetition; i ++)
            this.stack.push(new Double(i));
        assertTrue( this.stack.getSize() == repetition );
    }

    @RepeatedTest(2)
    @DisplayName("testing the search method")
    void testSearch()
    {
        // testing both implementations of the stack
        for ( int i = 0; i < 1000; i ++)
            this.stack.push(new Double(i));
        int positionInStack = this.stack.search(new Double(73.0));
        assertTrue( positionInStack == 927 );
    }

    @RepeatedTest(2)
    @DisplayName("testing the search method by searching for an element not in the stack")
    void testSearchWithMumboJumbo()
    {
        // testing both implementations of the stack
        for ( int i = 0; i < 1000; i ++)
            this.stack.push(new Double(i));
        int positionInStack = this.stack.search(new Double(17773.0));
        assertTrue( positionInStack == -1 );
    }

}
