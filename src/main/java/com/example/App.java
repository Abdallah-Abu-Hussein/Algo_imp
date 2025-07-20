package com.example;

import java.util.*;

public class App
{
    public static void main( String[] args )
    {
        int[] prices = {2,4,1};
        System.out.println(maxProfit(prices));
    }

// best time to buy and sell stocks
public static int maxProfit(int[] prices) {
    int profits [] = new int[prices.length];
    int profit;
    int bestBuyingPrice = 10000;

    for (int i = 0; i < prices.length; i++){
        if(prices[i] < bestBuyingPrice){
            bestBuyingPrice = prices[i];
        }
        profit = prices[i] - bestBuyingPrice;
        profits[i] = profit;
    }
    Arrays.sort(profits);
    return profits[profits.length - 1];
}


    public int[] twoSum_MapVersion(int[] nums, int target) {
        Map<Integer,Integer> numberParis = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complment = target - nums[i];

            if(numberParis.containsKey(complment)){
                return new int [] {numberParis.get(complment),i};
            }
            numberParis.put(nums[i],i);
        }
        return null;
    }

    public static int[] twoSum(int[] nums, int target) {
        // brute force
        // for in nums
        // take each nums[i]
        // compare it to the rest of the array till you find the target

        int [] result = new int[2];
        for (int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i]+nums[j] == target){
                    result[0] = nums[i];
                    result[1] = nums[j];
                }
            }

        }
        return result;
    }
    public static int romanToInt(String s) {
        Map<Character, Integer> RomanTONumberMap = new HashMap<>();
        RomanTONumberMap.put('I', 1);
        RomanTONumberMap.put('V', 5);
        RomanTONumberMap.put('X', 10);
        RomanTONumberMap.put('L', 50);
        RomanTONumberMap.put('C', 100);
        RomanTONumberMap.put('D', 500);
        RomanTONumberMap.put('M', 1000);

        int Number = 0;
        char[] Letters = s.toCharArray();
        for (int i = 0; i < Letters.length; i++) {
            char current = Letters[i];

            if (i + 1 < Letters.length) {
                if ((current == 'I') && (Letters[i + 1] == 'V' || Letters[i + 1] == 'X')) {
                    Number += (RomanTONumberMap.get(Letters[i + 1]) - RomanTONumberMap.get(current));
                    i++;
                } else if ((current == 'X') && (Letters[i + 1] == 'L' || Letters[i + 1] == 'C')) {
                    Number += (RomanTONumberMap.get(Letters[i + 1]) - RomanTONumberMap.get(current));
                    i++;
                } else if ((current == 'C') && (Letters[i + 1] == 'D' || Letters[i + 1] == 'M')) {
                    Number += (RomanTONumberMap.get(Letters[i + 1]) - RomanTONumberMap.get(current));
                    i++;
                } else {
                    Number += RomanTONumberMap.get(current);
                }
            }
            else {
                Number += RomanTONumberMap.get(current);
            }
        }
        return Number;
    }



    public static char getFirstNonDuplicate (String sentence){
        sentence = sentence.toLowerCase().replaceAll("//s","");
        char [] sentenceArray = sentence.toCharArray();
        HashMap<Character,Integer> Input = new HashMap<>();

        for (char c : sentenceArray){
            if (Input.containsKey(c)){
                Input.put(c,Input.get(c)+1);
            }else {
                Input.put(c,1);
            }
        }
        for (char c : sentenceArray) {
            if (Input.get(c) == 1)
                return c;
        }
        return '.';
    }

    public static char getMissingLetter(String letters){
        letters = letters.toLowerCase().replaceAll("\\s", "");
        char [] lettersArray = letters.toCharArray();

        HashSet<Character> Alphabet = new HashSet<>();
        HashMap <Character,Boolean> Input = new HashMap<>();

        for (char c = 'a'; c <= 'z'; c++) {
            Alphabet.add(c);
        }

        for (char value : lettersArray) {
            Input.put(value, true);
            System.out.println("Letter Array Index I = " + value);
        }

        for (char c : Alphabet){
            if (Alphabet.contains(c) && !Input.containsKey(c)){
                System.out.print(c + " " + Alphabet.contains(c) + " ");;
                return c;
            }
        }
        return '.';
    }



    public static String findDuplicate(String [] letters){
        // hash map
        HashMap <String,Boolean> map = new HashMap<>();
        for (String str : letters){
            if (map.containsKey(str)){
                return str;
            }else {
                System.out.println(map);
                map.put(str,true);
            }
        }
        return null;
    }



    public static int [] getIntersection(int[] arr_1,int[] arr_2){

        HashSet<Integer> table = new HashSet<>();

        if (arr_1 == null || arr_2 == null) {
            return new int[0];
        }
        if (Arrays.equals(arr_1,arr_2))
            return arr_1;

        // o(n)
        for (int j = 0 ; j <= arr_1.length -1;j++) {
            table.add(arr_1[j]);
            System.out.println(table.toString());
        }

        HashSet <Integer> Intersections = new HashSet<>();
        for (int i = 0; i <= arr_1.length - 1 ; i++){
            if (table.contains(arr_2[i])) {
                Intersections.add(arr_2[i]);
            }
        }

        int [] results = new int[Intersections.size()];
        int index = 0;
        for (int value : Intersections ){
            results[index++] = value;
        }
        return results;
    }


    public static String rev_String(String str) {
        char[] ReversedString = new char[str.length()];
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        System.out.println("Stack Before Pop " + stack.toString());

        for (int i = 0; i < ReversedString.length; i++) {
            ReversedString[i] = stack.pop();
        }
        System.out.println("Stack After POP " + stack.toString());
        str = new String(ReversedString);
        return str;
    }

    public static void linter(String code) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '(' || code.charAt(i) == '[' || code.charAt(i) == '{') {
                stack.push(code.charAt(i));
            } else if (code.charAt(i) == ')' || code.charAt(i) == ']' || code.charAt(i) == '}') {
                if (stack.isEmpty()) {
                    System.out.println(code.charAt(i) + "dose not have closing parentheses");
                    return;
                }
                char popedIteam = stack.pop();
                if (code.charAt(i) == ')' && popedIteam == '(') {
                    System.out.println("( ) are fine");
                } else if (code.charAt(i) == ']' && popedIteam == '[') {
                    System.out.println("[ ] are fine");
                } else if (code.charAt(i) == '}' && popedIteam == '{') {
                    System.out.println("{ } are fine");
                } else {
                    System.out.println(code.charAt(i) + " has miss matched parentheses");
                }

            }
        }
        if (!stack.isEmpty()) {
            System.out.println(stack.peek() + " does not have a closing brace");
        } else {
            System.out.println("All barces are matched correctly ");
        }
    }

    public static int fibonacci_v2(int limit) {
        if (limit < 0)
            throw new IllegalArgumentException("Negative indices are not supported");

        int[] fibo = new int[limit + 1];
        fibo[0] = 0;
        if (limit >= 1)
            fibo[1] = 1;

        for (int i = 2; i <= limit; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        return fibo[limit];
    }

    //without recursion
    public static int fibonacci(int limit) {
        int fibo[] = new int[limit + 1];
        fibo[0] = 0;
        fibo[1] = 1;
        if (limit == 0)
            return 0;
        if (limit == 1)
            return 1;
        else
            for (int i = 2; i <= limit; i++) {
                fibo[i] = fibo[i - 2] + fibo[i - 1];
            }
//        System.out.println(Arrays.toString(fibo));
        return fibo[limit];
    }

    public static int FindNonRepatinginString(String str) {
        int index = -1;
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length() - 1; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    break;
                } else {
                    index = i;
                }

            }
            // System.out.println(str.charAt(index));
            return index;
        }
        return -1;
    }

    public static String findPalindrom(String[] words) {
        int maxLength = Integer.MIN_VALUE;
        int palIndex = -1;
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase().replace(" ", "");
            int k = words[i].length() - 1;
            boolean ispalndrom = true;
            for (int j = 0; j < (words[i].length() - 1) / 2; k--, j++) {
                if (words[i].charAt(j) != words[i].charAt(k)) {
                    ispalndrom = false;
                    break;
                }
            }
            if (ispalndrom && maxLength < words[i].length()) {
                maxLength = words[i].length();
                palIndex = i;
            }
        }

        return palIndex != -1 ? words[palIndex] : null;
    }

    static boolean isAlphSorted(String words[], String order) {
        // return true iff words order is true to order of order array
        if (words == null || order == null) {
            return false;
        }
        if (words.length == 1) {
            return true;
        }
        int index = 0;
        while (index < words.length - 1) {
            int j = 0;
            if (order.charAt(words[j].charAt(j)) > order.charAt(words[j + 1].charAt(j))) {
                return false;
            } else if (order.charAt(words[j].charAt(j)) < order.charAt(words[j + 1].charAt(j))) {
                j++;
                index++;
                break;
            } else {
                continue;
            }
        }
        return true;
    }

    static String Player() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter one of following : Rock, Paper, Scissors");
        String choice = scan.nextLine();
        return choice.toLowerCase();
    }

    static String computer() {
        String choices[] = {"Rock", "Paper", "Scissors"};
        return choices[(int) (Math.random() * choices.length)].toLowerCase();
    }

    static String PlayRound() {
        String Human = Player();
        System.out.println("Human choice : " + Human);
        String Computer = computer();
        System.out.println("Computer Choice : " + Computer);

        if (Human.equalsIgnoreCase(Computer)) {
            return "Tie";
        } else if ((Human.equalsIgnoreCase("rock") && !Computer.equals("paper")) ||
                (Human.equalsIgnoreCase("paper") && !Computer.equals("scissors")) ||
                (Human.equalsIgnoreCase("scissors") && !Computer.equals("rock"))) {
            return "Human";
        }
        return "Computer";
    }

    // {11,3,5,6,3}
    static void linearsearch(int arr[], int goal) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == goal) {
                System.out.println("goal found at " + i);
                return;
            }
        }
        System.out.print("the goal value dose not exsist in the given array ");
    }

    static int binaryToDECimal(int binary) {
        // String str = Integer.toString(binary);
        // int numbers [] = new int[str.length()];
        // for (int i = 0; i < numbers.length ; i++) {
        // numbers[i] = str.charAt(i) - '0';
        // }
        // // int decimal = 0;
        //
        // for (int i = numbers.length -1; i >= 0;--i){
        // decimal += numbers[i]*(int)Math.pow(2,numbers.length-i-1);
        // }
        // ex: 1011 = 1*2^0 + 1*2^1 + 0*2^2 + 1*2^3 = 1+2+0+8=11
        // how to convert binary to decimal ?
        int digitIndex = 0;
        int decimal = 0;
        while (binary != 0) {
            int digit = binary % 10;
            decimal += digit * ((int) (Math.pow(2, digitIndex)));
            binary = binary / 10;
            digitIndex++;
        }
        return decimal;
    }

    static boolean hasDup(int arr[]) {
        Arrays.sort(arr); // O(n log n) + O(n)
        int[] existing = new int[arr[arr.length - 1]];
        for (int i = 0; i < arr.length - 1; i++) {
            if (existing[arr[i]] == 1) {
                return true;
            } else {
                existing[arr[i]] = 1;
            }
        }
        return false;
    }

    static int binarySearch(int array[], int target) {
        int low, high, mid;

        low = 0;
        high = array.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] == target) {
                System.out.println("found at " + mid);
                return mid;
            } else if (array[mid] > target) {
                high = mid - 1;
            } else if (array[mid] < target) {
                low = mid + 1;
            }
        }
        return 0;
    }

    static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    static void bSortV2(int[] arr) {
        int len = arr.length - 1;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;

            for (int i = 0; i < len; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
            }

        }
    }

    static void insertionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                } else
                    break;
            }
            arr[j + 1] = key;
        }
    }

    static void mergeSort(int arr[]) {
        int length = arr.length;
        if (length == 1)
            return;
        int middle = length / 2;
        int[] Farr = new int[middle];
        int[] Sarr = new int[length - middle];
        int i = 0, j = 0; // pointers for right and left arrays
        for (; i < length; i++) {
            if (i < middle)
                Farr[i] = arr[i];
            else {
                Sarr[j] = arr[i];
                j++;
            }
        }
        mergeSort(Farr);
        mergeSort(Sarr);
        merge(Farr, Sarr, arr);
    }

    static void selectionsort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) { // i = 0
            int min_idx = i; // min_idx = 0
            for (int j = i + 1; j < n; j++) // j = 1
                if (arr[j] < arr[min_idx])
                    min_idx = j; // min_idx = 1
            int temp = arr[min_idx]; // temp = 87
            arr[min_idx] = arr[i]; // arr[1] = 22
            arr[i] = temp; // arr[0] = 87
        }
    }

    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) { // base case
            int pivotindex = partition(arr, low, high);
            quicksort(arr, low, pivotindex - 1);
            quicksort(arr, pivotindex + 1, high);
        }
    }

    // same as split
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // location of pivot

    }


    static void merge(int left[], int right[], int arr[]) {
        int leftsize, rightsize, i = 0, l = 0, r = 0;
        leftsize = arr.length / 2;
        rightsize = arr.length - leftsize;
        // check merging condition
        while (l < leftsize && r < rightsize) {
            if (left[l] < right[r]) {
                arr[i] = left[l];
                i++;
                l++;
            } else {
                arr[i] = right[r];
                i++;
                r++;
            }

        }
        while (l < leftsize) {
            arr[i] = left[l];
            i++;
            l++;
        }
        while (r < rightsize) {
            arr[i] = right[r];
            i++;
            r++;
        }

    }

    static void min_heapify(int arr[], int n, int i) {
        // n = array حجم
        // i = level
        int smallest = i; // initialize largest as root
        int l = 2 * i + 1; // left child = 2*i + 1
        int r = 2 * i + 2; // right child = 2*i + 2
        // if left child is larger than root
        if (l < n && arr[l] < arr[smallest])
            smallest = l;
        // if right child is larger than largest so far
        if (r < n && arr[r] < arr[smallest])
            smallest = r;
        // if largest is not root
        if (smallest != i) {
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;
            // recursively heapify the affected sub-tree
            min_heapify(arr, n, smallest);
        }
    }

    static void heapSort(int arr[]) {
        int n = arr.length;
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) // start من الاغصان

            min_heapify(arr, n, i);
        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // call max heapify on the reduced heap
            min_heapify(arr, i, 0);
        }
    }


}
