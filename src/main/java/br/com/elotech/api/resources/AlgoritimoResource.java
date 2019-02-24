package br.com.elotech.api.resources;

import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("algoritimos")
public class AlgoritimoResource {

	@GetMapping("/isLucky/{n}")
	public boolean isLucky(@PathVariable int n) {
		String tempStr = Integer.toString(n);
		char[] charArray = tempStr.toCharArray();
		int len = charArray.length;
		int firstHalf = 0, secondHalf = 0;
		for (int i = 0, j = len - 1; i < j; i++, j--) {
			firstHalf += Character.getNumericValue(charArray[i]);
			secondHalf += Character.getNumericValue(charArray[j]);
		}
		return firstHalf == secondHalf;
	}

	@GetMapping("/circleOfNumbers/{n}/{firstNumber}")
	public int circleOfNumbers(@PathVariable int n, @PathVariable int firstNumber) {
		return (firstNumber + (n / 2)) % n;
	}

	@GetMapping("/alphabeticShift/{inputString}")
	public char[] alphabeticShift(@PathVariable String inputString) {
		char[] r = inputString.toCharArray();
		for (int i = 0; i < r.length; i++)
			r[i] = r[i] != 'z' ? (char) (r[i] + 1) : 'a';
		return r;
	}

	@PutMapping("/allLongestStrings")
	public String[] allLongestStrings(@Valid @RequestBody String[] inputArray) {
		int mL = 0;
		for (int i = 0; i < inputArray.length; i++) {
			if (mL < inputArray[i].length())
				mL = inputArray[i].length();
		}

		final int longest = mL;
		return Stream.of(inputArray).filter(s -> s.length() == longest).toArray(String[]::new);
	}

	@PutMapping("/minesweeper")
	public int[][] minesweeper(@Valid @RequestBody boolean[][] matrix) {
		int[][] sol = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++)
				for (int ii = Math.max(0, i - 1); ii <= Math.min(i + 1, matrix.length - 1); ii++)
					for (int jj = Math.max(0, j - 1); jj <= Math.min(j + 1, matrix[0].length - 1); jj++) {
						if (matrix[ii][jj] && (i != ii || jj != j)) {
							sol[i][j]++;
						}
					}

		return sol;
	}

	@PutMapping("/almostIncreasingSequence")
	public boolean almostIncreasingSequence(@Valid @RequestBody int[] seq) {
		int l = seq.length;
		int p = -1;
		int c = 0;
		for (int i = 1; i < l; i++)
			if (seq[i - 1] >= seq[i]) {
				p = i;
				c++;
			}
		if (c > 1)
			return false;
		if (c == 0)
			return true;
		if (p == l - 1 || p == 1)
			return true;
		if (seq[p - 1] < seq[p + 1])
			return true;
		if (seq[p - 2] < seq[p])
			return true;
		return false;
	}

}
