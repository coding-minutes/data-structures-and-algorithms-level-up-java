package com.company.SlidingWindow;

public class StringWindow {

    public static String find_window(String s,String p){


        //Array as a Freq Map or you can hashmap
        int[] FP = new int[256];
        int[] FS = new int[256];

        for(int i=0;i<p.length();i++){
            FP[p.charAt(i)]++;
        }

        //Sliding Window Algorithm
        int cnt = 0;
        int start = 0; // left contraction
        int start_idx = -1; //start_idx for best window
        int min_so_far = Integer.MAX_VALUE; //large number
        int window_size ;


        for(int i=0 ; i < s.length(); i++){
            //expand the window by including current character
            char ch = s.charAt(i);
            FS[ch]++;

            //Count how many characters have been matched till now (string and pattern)
            if(FP[ch]!=0 && FS[ch]<= FP[ch]){
                cnt += 1;
            }

            //another thing
            //if all characters of the pattern are found in the current window then you can start contracting
            if(cnt==p.length()){

                //start contracting from the left to remove unwanted characters

                while(FP[s.charAt(start)]==0 || FS[s.charAt(start)] > FP[s.charAt(start)]){
                    FS[s.charAt(start)]--;
                    start++;
                }

                //note. the window size
                window_size = i - start + 1;
                if(window_size < min_so_far){
                    min_so_far = window_size;
                    start_idx = start;
                }

            }

        }
        if(start_idx==-1){
            return "No window found";
        }
        return substringutil(s,start_idx,min_so_far);
    }

    private static String substringutil(String str, int start_window, int i) {

        int inc= start_window;
        StringBuilder str1 = new StringBuilder();

        while(i!=0){

            str1.append(str.charAt(inc));
            inc++;
            i--;
        }

        return str1.toString();
    }



}
