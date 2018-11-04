package practice7;

import java.util.Scanner;

public class drunkManGame {
    private static int cnt = 0;
    public static int play(Stack first, Stack second) {
        if(first.getTop() == 0 & second.getTop() == 9) {
            second.addBottom(first.removeTop());
            cnt++;
        } else if(first.getTop() == 9 & second.getTop() == 0) {
            first.addBottom(second.removeTop());
            cnt++;
        } else if(first.getTop() < second.getTop()) {
            first.addBottom(second.removeTop());
            cnt++;
        } else if(first.getTop() == second.getTop()) {
            first.addBottom(first.removeTop());
            second.addBottom(second.removeTop());
            cnt++;
        } else if(first.getTop() > second.getTop()) {
            second.addBottom(first.removeTop());
            cnt++;
        }
        return cnt;
    }

    public static boolean whoIsWin(Stack first, Stack second, int k) {
        if(cnt == 106) {
            System.out.println("Botva" + " " + k);
            return false;
        } if(first.isEmpty()) {
            System.out.println("First" + " " + k);
            return false;
        } else if (second.isEmpty()) {
            System.out.println("Second" + " " + k);
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Stack first = new Stack();
        Stack second = new Stack();
        int[] arr1 = new int[3];
        int[] arr2 = new int[3];
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < 3; i++) {
            arr1[i] = scan.nextInt();
            arr2[i] = scan.nextInt();
        }
        int k = 0;
        first.start(arr1);
        second.start(arr2);
        //first.show(k);
        //second.show(k);
        while(whoIsWin(first, second, k)) {
            k = play(first, second);
            //first.show(k);
            //second.show(k);
        }
    }
}