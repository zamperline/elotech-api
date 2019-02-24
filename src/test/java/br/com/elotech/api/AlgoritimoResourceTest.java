package br.com.elotech.api;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.elotech.api.resources.AlgoritimoResource;

@RunWith(SpringRunner.class)
public class AlgoritimoResourceTest {
	
	private AlgoritimoResource test;

	@Before
	public void setUp() throws Exception {
		test = new AlgoritimoResource();
	}

	@Test
	public void isLucky() throws Exception {
		assertEquals(true, test.isLucky(1230));
		assertEquals(false, test.isLucky(239017));
		assertEquals(true, test.isLucky(123321));
		assertEquals(false, test.isLucky(10));
		assertEquals(true, test.isLucky(11));
		assertEquals(true, test.isLucky(1010));
		assertEquals(false, test.isLucky(261534));
		assertEquals(false, test.isLucky(100000));
		assertEquals(true, test.isLucky(999999));
		assertEquals(true, test.isLucky(123321));		
		
	}
	
	@Test
	public void circleOfNumbers() throws Exception {
		assertEquals(7, test.circleOfNumbers(10, 2));
		assertEquals(2, test.circleOfNumbers(10, 7));
		assertEquals(3, test.circleOfNumbers(4, 1));
		assertEquals(0, test.circleOfNumbers(6, 3));
	}
	
	@Test
	public void alphabeticShift() throws Exception {
		assertEquals("dsbaz",String.valueOf(test.alphabeticShift("crazy")));
		assertEquals("a",String.valueOf(test.alphabeticShift("z")));
		assertEquals("bbbbcccdde",String.valueOf(test.alphabeticShift("aaaabbbccd")));
		assertEquals("gvaaz",String.valueOf(test.alphabeticShift("fuzzy")));
		assertEquals("dpeftjhobm",String.valueOf(test.alphabeticShift("codesignal")));
	}
	
	@Test
	public void allLongestStrings() throws Exception {
		assertEquals("[aba, vcd, aba]", Arrays.toString(test.allLongestStrings(new String[] {"aba", "aa", "ad", "vcd", "aba"})));
		assertEquals("[aa]", Arrays.toString(test.allLongestStrings(new String[] {"aa"})));
		assertEquals("[eeee, abcd]", Arrays.toString(test.allLongestStrings(new String[] {"abc",  "eeee",  "abcd",  "dcd"})));
		assertEquals("[zzzzzz, abcdef, aaaaaa]", Arrays.toString(test.allLongestStrings(new String[] {"a",  "abc",  "cbd",  "zzzzzz",  "a",  "abcdef",  "asasa",  "aaaaaa"})));
	}
	
	@Test
	public void minesweeper() throws Exception {
		assertEquals("[[1, 2, 1], [2, 1, 1], [1, 1, 1]]", Arrays.deepToString(test.minesweeper(new boolean[][] {{true, false, false}, {false, true, false}, {false, false, false}})));
		assertEquals("[[0, 0, 0], [0, 0, 0]]", Arrays.deepToString(test.minesweeper(new boolean[][] {{false,false,false}, {false,false,false}})));
		assertEquals("[[0, 2, 2, 1], [3, 4, 3, 3], [1, 2, 3, 1]]", Arrays.deepToString(test.minesweeper(new boolean[][] {{true,false,false,true}, {false,false,true,false}, {true,true,false,true}})));
		assertEquals("[[3, 5, 3], [5, 8, 5], [3, 5, 3]]", Arrays.deepToString(test.minesweeper(new boolean[][] {{true,true,true}, {true,true,true}, {true,true,true}})));
		assertEquals("[[3, 3, 3, 2], [2, 4, 5, 2], [2, 3, 2, 2]]", Arrays.deepToString(test.minesweeper(new boolean[][] {{false,true,true,false}, {true,true,false,true}, {false,false,true,false}})));
		assertEquals("[[1, 2], [2, 3], [2, 1], [1, 1], [0, 0]]", Arrays.deepToString(test.minesweeper(new boolean[][] {{true,false}, {true,false}, {false,true},{false,false},{false,false}})));
	}

	@Test
	public void almostIncreasingSequence() throws Exception {
		assertEquals(false, test.almostIncreasingSequence(new int[] {1,3,2,1}));
		assertEquals(true, test.almostIncreasingSequence(new int[] {1, 3, 2}));
		assertEquals(false, test.almostIncreasingSequence(new int[] {1, 2, 1, 2}));
		assertEquals(false, test.almostIncreasingSequence(new int[] {3, 6, 5, 8, 10, 20, 15}));
		assertEquals(false, test.almostIncreasingSequence(new int[] {1, 1, 2, 3, 4, 4}));
		assertEquals(false, test.almostIncreasingSequence(new int[] {1, 4, 10, 4, 2}));
		assertEquals(true, test.almostIncreasingSequence(new int[] {10, 1, 2, 3, 4, 5}));
		assertEquals(false, test.almostIncreasingSequence(new int[] {1, 1, 1, 2, 3}));
		assertEquals(true, test.almostIncreasingSequence(new int[] {0, -2, 5, 6}));
		assertEquals(false, test.almostIncreasingSequence(new int[] {1, 2, 3, 4, 5, 3, 5, 6}));
		assertEquals(false, test.almostIncreasingSequence(new int[] {1000, 1000, 2000, 3000, 4000, 5000, 5000}));
		assertEquals(true, test.almostIncreasingSequence(new int[] {1, 1}));
		assertEquals(true, test.almostIncreasingSequence(new int[] {-5, -4, -3, -2, 10, 2, 8}));
	}
}
