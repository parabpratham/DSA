package study.dsa.algo;

import java.util.Set;
import java.util.TreeSet;

public class PowerSet {

	public static int no = 2;

	public static void main(String[] args) {
		int[] ip = { 10, 15, 12, 16, 13, 55 };
		int n = ip.length - 1;
		Set<String> a = new TreeSet<String>();
		a.add("0");
		a.add("1");

		for (int i = 0; i < Math.pow(2, n); i++) {
			a.add(addPreZeroes(Integer.toBinaryString(i), n));
		}
		Set<String> b = new TreeSet<String>();
		b.add("0");
		b.add("1");
		for (int i = 0; i < n; i++) {
			b = append(b);
		}
		for (String temp : b) {
			System.out.println(temp + "--" + powerSet(temp) + " -- "
					+ sum(temp, ip));
		}
	}

	private static String addPreZeroes(String binaryString, int n) {
		// TODO Auto-generated method stub
		int counter = n - binaryString.length();
		for (int i = 0; i < counter; i++)
			binaryString = "0" + binaryString;
		return binaryString;
	}

	private static String powerSet(String temp) {
		// TODO Auto-generated method stub
		String[] ip = { "A", "B", "C", "D", "E", "F" };
		char[] ipString = temp.toCharArray();
		String rt = "";
		for (int i = 0; i < ipString.length; i++) {
			if (ipString[i] == '1') {
				rt = rt + ip[i];
			}
		}

		return rt;
	}

	private static int sum(String temp, int[] ip) {

		char[] ipString = temp.toCharArray();
		int rt = 0;
		for (int i = 0; i < ipString.length; i++) {
			if (ipString[i] == '1')
				rt += ip[i];
		}

		return rt;
	}

	private static Set<String> append(Set<String> a) {

		Set<String> newA = new TreeSet<String>();
		// newA.addAll(a);
		for (String ip : a) {
			newA.add(ip + "0");
			newA.add(ip + "1");
			no++;
		}

		return newA;

	}
}
