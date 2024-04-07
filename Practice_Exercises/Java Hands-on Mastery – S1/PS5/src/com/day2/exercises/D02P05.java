package com.day2.exercises;

import java.util.Scanner;

public class D02P05 {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            str[i] = scanner.next();
        }
        
        boolean flag = traversal(str, str[0].charAt(0), str[0].charAt(0), new boolean[str.length]);
        System.out.println(flag);
        
        scanner.close();
    }

    public static boolean traversal(String[] strings, char start, char ch, boolean[] visited) {
        boolean allVisited = true;
        for (boolean v : visited) {
            if (!v) {
                allVisited = false;
                break;
            }
        }
        if (allVisited && start == ch) {
            return true;
        } else {
            for (int i = 0; i < strings.length; i++) {
                if (!visited[i] && strings[i].charAt(0) == ch) {
                    visited[i] = true;
                    if (traversal(strings, start, strings[i].charAt(strings[i].length() - 1), visited)) {
                        return true;
                    }
                    visited[i] = false;
                }
            }
            return false;
        }
    }
	

}
