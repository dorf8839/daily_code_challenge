package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("/* ===== Substring Search ===== */");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string");
        String str = sc.nextLine().toLowerCase();
        System.out.println("Enter the pattern");
        String pat = sc.nextLine().toLowerCase();
        bruteSearch(str, pat);
        new KMP().KMPSearch(str, pat);
        new Z().search(str, pat);
        new RK().search(str, pat, 101);
        new BM().search(str, pat);
    }

    public static void bruteSearch(String str, String pat){
        int strLength = str.length();
        int patLength = pat.length();

        for(int i = 0; i <= strLength - patLength; i++){
            int j;
            for(j = 0; j < patLength; j++){
                if(str.charAt(i + j) != pat.charAt(j)){
                    break;
                }
            }
            if(j == patLength){
                System.out.println("Brute Search found pattern at index " + i);
            }
        }
    }
}

class KMP{
    public void KMPSearch(String str, String pat){
        int strLength = str.length();
        int patLength = pat.length();

        //create lps[] that will hold hte longest prefix suffix values for pattern
        int[] lps = new int[patLength];
        int j = 0; //index for pat[]

        //Preprocess the pattern (calculate lps[] array)
        computeLPSArray(pat, patLength, lps);

        int i = 0; //index for str[]
        while(i < strLength){
            if (pat.charAt(j) == str.charAt(i)){
                j++;
                i++;
            }
            if(j == patLength){
                System.out.println("KMP found pattern at index " + (i-j));
                j = lps[j-1];
            }else if(i < strLength && pat.charAt(j) != str.charAt(i)){
                //Do not match lps[0..lps[j-1]] characters,
                //they will not match anyway
                if(j != 0){
                    j = lps[j-1];
                }else{
                    i = i+1;
                }
            }
        }
    }

    private void computeLPSArray(String pat, int M, int[] lps){
        //length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; //lps[0] is always 0

        //the loop calculates lps[i] for i=1 to M-1
        while(i < M){
            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{ //pat[i] != pat[len])
                //This is tricky.  Consider the example.
                //AAACAAAA and i = 7.  The idea is similar
                //to search step.
                if(len != 0){
                    len = lps[len - 1];
                    //Also, note that we do not increment i here
                }else{ //if(len == 0)
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}

class Z {
    //  prints all occurrences of pattern in text using
    // Z algo
    public void search(String text, String pattern) {
        // Create concatenated string "P$T"
        String concat = pattern + "$" + text;
        int l = concat.length();
        int Z[] = new int[l];

        // Construct Z array
        getZarr(concat, Z);

        // now looping through Z array for matching condition
        for (int i = 0; i < l; ++i) {
            // if Z[i] (matched region) is equal to pattern
            // length we got the pattern
            if (Z[i] == pattern.length()) {
                System.out.println("Z found pattern at index "
                        + (i - pattern.length() - 1));
            }
        }
    }

    // Fills Z array for given string str[]
    private void getZarr(String str, int[] Z) {
        int n = str.length();
        // [L,R] make a window which matches with
        // prefix of s
        int L = 0, R = 0;

        for (int i = 1; i < n; ++i) {
            // if i>R nothing matches so we will calculate.
            // Z[i] using naive way.
            if (i > R) {
                L = R = i;
                // R-L = 0 in starting, so it will start
                // checking from 0'th index. For example,
                // for "ababab" and i = 1, the value of R
                // remains 0 and Z[i] becomes 0. For string
                // "aaaaaa" and i = 1, Z[i] and R become 5
                while (R < n && str.charAt(R - L) == str.charAt(R))
                    R++;
                Z[i] = R - L;
                R--;
            } else {
                // k = i-L so k corresponds to number which
                // matches in [L,R] interval.
                int k = i - L;
                // if Z[k] is less than remaining interval
                // then Z[i] will be equal to Z[k].
                // For example, str = "ababab", i = 3, R = 5
                // and L = 2
                if (Z[k] < R - i + 1)
                    Z[i] = Z[k];
                    // For example str = "aaaaaa" and i = 2, R is 5,
                    // L is 0
                else {
                    // else start from R and check manually
                    L = i;
                    while (R < n && str.charAt(R - L) == str.charAt(R))
                        R++;
                    Z[i] = R - L;
                    R--;
                }
            }
        }
    }
}

class RK{
    public void search(String txt, String pat, int q)
    {
        int M = pat.length();
        int N = txt.length();
        int d = 256;
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M-1; i++)
            h = (h*d)%q;

        // Calculate the hash value of pattern and first
        // window of text
        for (i = 0; i < M; i++)
        {
            p = (d*p + pat.charAt(i))%q;
            t = (d*t + txt.charAt(i))%q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++)
        {

            // Check the hash values of current window of text
            // and pattern. If the hash values match then only
            // check for characters on by one
            if ( p == t )
            {
                /* Check for characters one by one */
                for (j = 0; j < M; j++)
                {
                    if (txt.charAt(i+j) != pat.charAt(j))
                        break;
                }

                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                if (j == M)
                    System.out.println("RK found pattern at index " + i);
            }

            // Calculate hash value for next window of text: Remove
            // leading digit, add trailing digit
            if ( i < N-M )
            {
                t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+M))%q;

                // We might get negative value of t, converting it
                // to positive
                if (t < 0)
                    t = (t + q);
            }
        }
    }
}

class BM{
    int NO_OF_CHARS = 256;
    //A utility function to get maximum of two integers
    int max (int a, int b) { return (a > b)? a: b; }
    //The preprocessing function for Boyer Moore's
    //bad character heuristic
    private void badCharHeuristic( char []str, int size,int badchar[]){
        int i;
        // Initialize all occurrences as -1
        for (i = 0; i < NO_OF_CHARS; i++)
            badchar[i] = -1;

        // Fill the actual value of last occurrence
        // of a character
        for (i = 0; i < size; i++)
            badchar[(int) str[i]] = i;
    }

    /* A pattern searching function that uses Bad
    Character Heuristic of Boyer Moore Algorithm */
    public void search( String str,  String strPat){
        char[] txt = str.toCharArray();
        char[] pat = strPat.toCharArray();
        int m = pat.length;
        int n = txt.length;

        int badchar[] = new int[NO_OF_CHARS];

      /* Fill the bad character array by calling
         the preprocessing function badCharHeuristic()
         for given pattern */
        badCharHeuristic(pat, m, badchar);

        int s = 0;  // s is shift of the pattern with
        // respect to text
        while(s <= (n - m))
        {
            int j = m-1;

          /* Keep reducing index j of pattern while
             characters of pattern and text are
             matching at this shift s */
            while(j >= 0 && pat[j] == txt[s+j])
                j--;

          /* If the pattern is present at current
             shift, then index j will become -1 after
             the above loop */
            if (j < 0)
            {
                System.out.println("BK found a pattern at shift = " + s);

              /* Shift the pattern so that the next
                 character in text aligns with the last
                 occurrence of it in pattern.
                 The condition s+m < n is necessary for
                 the case when pattern occurs at the end
                 of text */
                s += (s+m < n)? m-badchar[txt[s+m]] : 1;

            }

            else
              /* Shift the pattern so that the bad character
                 in text aligns with the last occurrence of
                 it in pattern. The max function is used to
                 make sure that we get a positive shift.
                 We may get a negative shift if the last
                 occurrence  of bad character in pattern
                 is on the right side of the current
                 character. */
                s += max(1, j - badchar[txt[s+j]]);
        }
    }
}