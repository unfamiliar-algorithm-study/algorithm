/**
 * 
 */
package main;

import java.util.Arrays;

import sort.Sort;

/**
 * @FileName : Main.java
 * @Date : 2016. 9. 19.
 * @author : ChoiTaeEun
 * @description :
 */
public class Main {

	public static void main(String[] args) {

		Math.random();

		int[] arr = { 5, 3, 2, 8, 1, 6, 4 };

		Sort.mergeSort(arr);

		System.out.println(Arrays.toString(arr));
	}

}
