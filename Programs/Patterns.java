package Programs;

public class Patterns {
    public static void main(String[] args) {
        System.out.println("PATTERNS");
        System.out.println();

        int n = 5;
        /*
        1) Rectangular Star Pattern
        
        * * * * *
        * * * * *
        * * * * *
        * * * * *
        * * * * *
        
         */
        System.out.println("1) Rectangular Star Pattern");
        rectangularStarPattern(n);                      System.out.println(); // new line for next method



        /*
        2) Right-Angled Triangle Pattern
          
        *
        * *
        * * *
        * * * *
        * * * * *
          
         */
        System.out.println("2) Right-Angled Triangle Pattern");
        rightAngledTrianglePattern(n);                      System.out.println();



        /*
        3) Right-Angled Triangle Number Pattern
         
        1
        1 2
        1 2 3
        1 2 3 4
        1 2 3 4 5
         
         */
        System.out.println("3) Right-Angled Triangle Number Pattern");
        rightAngledTriangleNumberPattern(n);                      System.out.println();



        /*
        4) Right-Angled Triangle Number Pattern - 2
        
        1
        2 2
        3 3 3
        4 4 4 4
        5 5 5 5 5 
        
         */
        System.out.println("4) Right-Angled Triangle Number Pattern - 2");
        rightAngledTriangleNumberPattern2(n);                      System.out.println();



        /*
        5) Inverted Right-Angled Triangle Pattern
        
        * * * * *
        * * * *
        * * *
        * *
        *
        
         */
        System.out.println("5) Inverted Right-Angled Triangle Pattern");
        invertedRightAngledTrianglePattern(n);                      System.out.println();



        /*
        6) Inverted Right-Angled Triangle Pattern
        
        1 2 3 4 5
        1 2 3 4
        1 2 3
        1 2
        1

         */
        System.out.println("6) Inverted Right-Angled Triangle Pattern");
        invertedRightAngledTriangleNumberPattern(n);                      System.out.println();



        /*
        7) Star Pyramid

            *
           ***
          *****
         *******
        *********

         */
        System.out.println("7) Star Pyramid");
        starPyramid(n);                      System.out.println();



        /*
        8) Inverted Star Pyramid
        
        *********
        _*******_
        __*****__
        ___***___
        ____*____

         */
        System.out.println("8) Inverted Star Pyramid");
        invertedStarPyramid(n);                      System.out.println();


        
        /*
        9) Diamond Star Pyramid

        ....*....
        ...***...
        ..*****..
        .*******.
        *********
        *********
        _*******_
        __*****__
        ___***___
        ____*____
        
         */
        System.out.println("9) Diamond Star Pyramid");
        diamondStarPyramid(n);                      System.out.println();


        /*
        10) Half Diamond Star Pattern 
        
        *
        * *
        * * *
        * * * *
        * * * * *
        * * * *
        * * *
        * *
        * 

         */
        System.out.println("10) Half Diamond Star Pattern");
        halfDiamondStarPyramid(n);                      System.out.println();



        /*
        11) Binary Number Triangle Pattern
        
        1
        01
        101
        0101
        10101
        010101

         */
        System.out.println("11) Binary Number Triangle Pattern");
        binaryNumberTrianglePattern(n);                      System.out.println();


        /*
        12) Number Crown Pattern"
        
        1       1
        12     21
        123   321
        1234 4321
        1234554321

         */
        System.out.println("12) Number Crown Pattern");
        numberCrownPattern(n);                      System.out.println();




        /*
        13) Increasing Number Triangle Pattern
        
        1
        2 3
        4 5 6
        7 8 9 10
        11 12 13 14 15        //note 10 and 14 in same col
        
         */
        System.out.println("13) Increasing Number Triangle Pattern");
        increasingNumberTrianglePattern(n);                      System.out.println();




        /*
        14) Increasing Letter Triangle Pattern
        
        A
        A B
        A B C
        A B C D
        A B C D E
        A B C D E F
        
         */
        System.out.println("14) Increasing Letter Triangle Pattern");
        increasingLetterTrianglePattern(n);                      System.out.println();






        /* 
        15) Reverse Letter Triangle Pattern

        A B C D E
        A B C D
        A B C
        A B
        A

         */
        System.out.println("15) Reverse Letter Triangle Pattern");
        reverseLetterTrianglePattern(n);                      System.out.println();


        
        
        /* 
        16) Alpha-Ramp Pattern
        
        A 
        B B
        C C C
        D D D D
        E E E E E
        F F F F F F

         */
        System.out.println("16) Alpha-Ramp Pattern");
        alphaRampPattern(n);                      System.out.println();



      
        /* 
        17) Alpha-Hill Pattern
        
            A     
           ABA    
          ABCBA   
         ABCDCBA  
        ABCDEDCBA 

         */
        System.out.println("17) Alpha-Hill Pattern");
        alphaHillPattern(n);                      System.out.println();
      


        /* 
        18) Alpha-Triangle Pattern
        
        E
        D E
        C D E
        B C D E
        A B C D E

         */
        System.out.println("18) Alpha-Triangle Pattern");
        alphaTrianglePattern(n);                      System.out.println();

        
        /* 
        19) Symmetric-Void Pattern

        **********
        ****  ****
        ***    ***
        **      **
        *        *
        *        *
        **      **
        ***    ***
        ****  ****
        **********

         */
        System.out.println("19) Symmetric-Void Pattern");
        symmetricVoidPattern(n);                      System.out.println();

        
        /* 
        20) Symmetric-Butterfly Pattern

        *        *
        **      **
        ***    ***
        ****  ****
        **********
        ****  ****
        ***    ***
        **      **
        *        *

         */
        System.out.println("20) Symmetric-Butterfly Pattern");
        symmetricButterflyPattern(n);                      System.out.println();



        /* 
        21) Hollow Rectangle Pattern

        *****
        *   *
        *   *
        *   *
        *****

         */
        System.out.println("21) Hollow Rectangle Pattern");
        hollowRectangularPattern(n);                      System.out.println();

        /* 
        22) The Number Pattern

        555555555
        544444445
        543333345
        543222345
        543212345
        543222345
        543333345
        544444445
        555555555

         */
        System.out.println("22) The Number Pattern");
        theNumberPattern(n);                      System.out.println();
    }   









    static void rectangularStarPattern(int n) {
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print("* ");
            }
            System.out.println(); // exit from current row print in next line
        }
    }

    static void rightAngledTrianglePattern(int n) {
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void rightAngledTriangleNumberPattern(int n) {
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    
    static void rightAngledTriangleNumberPattern2(int n) {
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    static void invertedRightAngledTrianglePattern(int n) {
        for(int i=n; i>=0; i--){   // or for (int i = 0; i < N; i++) to loop n times
            for(int j=1; j<=i; j++){    // or for (int j = n; j > i; j--)
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void invertedRightAngledTriangleNumberPattern(int n) {
        for(int i=n; i>=0; i--){   // or for (int i = 0; i < N; i++) to loop n times
            for(int j=1; j<=i; j++){    // or for (int j = n; j > i; j--)
                System.out.print(j+" ");    // or System.out.print(N-j+1+" ")
            }
            System.out.println();
        }
    }

    static void starPyramid(int n) {
        int cols= 2*n-1;  // if n = 5 => ----*---- and n is number of rows
        for (int i = 1; i <= n; i++) {
            for (int j = 1, noOfStars = 0; j <= cols; j++) {
            	// pyramid starting column in this row
                int startCol = n-i+1; // or (int)Math.ceil(cols*1.0/2) - i+1;
                int noOfStarsInThisRow = 2*i-1;
                if(startCol== j-noOfStars && noOfStars < noOfStarsInThisRow){
                    noOfStars++;
                    System.out.print("*");
                } else System.out.print(".");
            }
            System.out.println();
        }

        // // or
        // for (int i = 0; i < n; i++) {
        //   // print spaces
        //   for (int j = 0; j < n - i - 1; j++) { // below midIndex -i, where midIndex always be n-1
        //     System.out.print(".");
        //   }
        //   // print stars
        //   for (int k = 0; k < 2 * i + 1; k++) { 
        //     System.out.print("*");
        //   }
        //   System.out.println();
        // }


        // // or  ----------  IMPORTANT ---------
        // int cols = 2*n-1; // if n = 5 => ----*---- and n is number of rows
		// int mid = cols/2; // or n-1 => mid will be always the same, only the pyramid width increases in each row by 1 on each side
		// for(int i=0; i<n; i++){
		//     int fillStart = mid - i;
		//     int fillEnd = mid + i;
		// 	//iterating through all the columns
		// 	for(int j=0; j<cols; j++){
        //      // filling the stars in current row if j is between stars
		// 		if(j >= fillStart && j<= fillEnd)
		// 			System.out.print("*");
		// 		else System.out.print("-");
		// 	}
		// 	System.out.println();
		// }

    }

    static void invertedStarPyramid(int rows) {
        int midIndex = rows-1;
        int cols = 2*rows-1;
        for (int i = rows-1; i >= 0 ; i--) {
            int widthStart = midIndex-i;
            int widthEnd = midIndex+i;
            for (int j = 0; j < widthStart; j++) System.out.print("_");
            for (int j = widthStart; j <= widthEnd; j++) System.out.print("*");
            for (int j = widthEnd+1; j < cols; j++) System.out.print("_");
            System.out.println();
        }
    }

    static void diamondStarPyramid(int rows) {
        starPyramid(rows);
        invertedStarPyramid(rows);
    }

    static void halfDiamondStarPyramid(int rows) {
        rightAngledTrianglePattern(rows-1);
        invertedRightAngledTrianglePattern(rows);
    }

    static void binaryNumberTrianglePattern(int n) {
        for(int i=0; i<n; i++){
            int ibool = i%2==0 ? 1:0;
            for(int j=0; j<=i; j++){
                System.out.print(ibool + " ");
                ibool = 1 - ibool;
            }
            System.out.println();
        }
    }

    static void numberCrownPattern(int rows){
        int cols = 2*rows;
        for (int i = rows-1; i >= 0 ; i--) {
            int widthStart = rows-i;
            int widthEnd = rows+i;
            for (int j = 1; j <= widthStart; j++) System.out.print(j);
            for (int j = widthStart; j < widthEnd; j++) System.out.print(" ");
            for (int j = widthEnd+1; j <= cols; j++) System.out.print(cols-j+1);
            System.out.println();
        }


        // // or
        // int spaces = 2*(rows-1);
        // for(int i=1;i<=rows;i++){
        //     for(int j=1;j<=i;j++) System.out.print(j);
        //     for(int j = 1;j<=spaces;j++) System.out.print(" ");
        //     for(int j=i;j>=1;j--) System.out.print(j);
        //     spaces-=2; // After each iteration nos. increase by 2, thus, spaces will decrement by 2
        //     System.out.println();
        // }
    }


    static void increasingNumberTrianglePattern(int n) {
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }

    static void increasingLetterTrianglePattern(int n) {
        for (int i = 0; i < n; i++) {
            // for (int j = 0; j <= i; j++) System.out.print( (char) (j + 65) + " ");
            for (char ch = 'A'; ch<='A'+i; ch++) System.out.print(ch + " ");
            System.out.println();
        }
    }

    static void reverseLetterTrianglePattern(int n) {
        for (int i = n; i > 0; i--) {
            // for (int j = 0; j < i; j++) System.out.print( (char) (j + 65) + " ");
            for (char ch = 'A'; ch<'A'+i; ch++) System.out.print(ch + " ");
            System.out.println();
        }
    }

    static void alphaRampPattern(int n) {
        for (char ch = 'A'; ch<'A'+n; ch++) {
            for (int j = 'A'; j <= ch; j++) System.out.print(ch + " "); // or (char) 'A'+i
            System.out.println();
        }
    }


    static void alphaHillPattern(int rows) {
        int midIndex = rows -1;
        for (int i = 0; i < rows; i++) {

            int startWidth = midIndex-i;
            int endWidth = midIndex+i;

            for (int j = 0; j < startWidth; j++) System.out.print(" ");
            for (int j = startWidth; j <= midIndex; j++) System.out.print(  (char) (j - startWidth + 'A'));
            for (int j = midIndex +1 ; j <= endWidth; j++) System.out.print(  (char) (endWidth - j + 'A'));
            
            System.out.println();

            // or insted of second & third loop  use this instead
            /*             
            char ch = 'A';
            int breakpoint = (2*i+1)/2;
            for(int j=1;j<=2*i+1;j++){    
                System.out.print(ch);
                if(j <= breakpoint) ch++;
                else ch--;
            } 
            */
        }
    }
        
    
    static void alphaTrianglePattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = i; j >= 1; j--) 
                System.out.print((char) (rows - j + 'A') + " ");
            System.out.println();
        }
    }
        


    static void symmetricVoidPattern(int n) {
        int rows = 2*n;
        int cols = 2*n;

        int midIndex = n;
        for (int row = 0, i = 0; row < rows; row++) {

            int startWidth = midIndex - i;
            int endWidth = midIndex + i;

            for (int j = 0; j < cols; j++) {
                if (j >= startWidth && j< endWidth)
                    System.out.print(" ");
                else System.out.print("*");
                
            }
            // skip i=5 step cause maintain two similar i => 0, 1, 2, 3, 4, 4, 3, 2, 1, 0
            // *        *
            // *        *
            // in the middle rows
            if (row < n-1)
                i++; 
            else if( row >= n) 
                i--;
            System.out.println();
        }

        // or use two halfs of n rows instead of direct 2n rows
    }
    
    static void symmetricButterflyPattern(int n) {
        int rows = 2*n-1;
        int cols = 2*n;

        int midIndex = n;
        for (int row = 1, i = n-1; row <= rows; row++) {

            int startWidth = midIndex - i;
            int endWidth = midIndex + i;

            for (int j = 0; j < cols; j++) {
                if (j >= startWidth && j< endWidth)
                    System.out.print(" ");
                else System.out.print("*");
                
            }
            // remember that current row is less than next loop
            // i & row will increase/decrease at once after the child for loop
            // row starts from 1; 
            // let n =5; i decrease upto 0 i.e when row = 5 and i should increase when row becomes 6
            // i.e here increase i at row = 4 (when i = 0) => i should not be less than 0
            if (row < n)
                i--; 
            else
                i++;
            System.out.println();
        }

        // or use two halfs of n rows instead of direct 2n rows
    }

    static void hollowRectangularPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n-1 || j == 0  || j == n-1) {
                    System.out.print("*");
                } else System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void theNumberPattern(int n) {

        // here i saw diamond pattern
        int rows = 2*n-1;
        int cols = 2*n-1;
        int midNum = n;
        for (int row = 1, i=n; row <= rows; row++) {
            int startWidth = midNum - i; 
            int endWidth = midNum + i;

            for (int j = 1; j <= cols; j++) {
                if (j <= startWidth)
                    System.out.print(n-j+1);
                else if (j > startWidth && j < endWidth ) {
                    System.out.print(i);
                } else System.out.print(j-n+1);
            }

            // next loop row = current row + 1
            int nextRow = row + 1;
            if(nextRow <= n) // or row < n
                i--;
            else i++;
            System.out.println();
        }

        // //or
        /* 
        for example take n = 4

        4 4 4 4 4 4 4
        4 3 3 3 3 3 4
        4 3 2 2 2 3 4
        4 3 2 1 2 3 4
        4 3 2 2 2 3 4
        4 3 3 3 3 3 4
        4 4 4 4 4 4 4

        if we substract n from above matrix it'll become

        we know that i is for rows and j is for cols but distance is different


          j distance
        ◄-----------► 
        left    right

        0 0 0 0 0 0 0   ▲   top distance
        0 1 1 1 1 1 0   |
        0 1 2 2 2 1 0   |
        0 1 2 3 2 1 0   |   i distance
        0 1 2 2 2 1 0   |
        0 1 1 1 1 1 0   |
        0 0 0 0 0 0 0   ▼   bottom distance

        let's take "3" in second matrix
        then it's left-distance is j and top-distance is i
        and calulate right-distance: 2n-1-1 is last element index of this matrix then 2n-1-1-j is right-distance
        similarly bottom-distance is 2n-1-1-i index
        and calculate the min distance of any element here, then that is the value of that element
        and finally substract this 0 1 2 3... matrix with n
        then we'll get the original matrix
        

 */
        // for(int i=0;i<2*n-1;i++){
         
        //     // inner loop for no. of columns.
        //     for(int j=0;j<2*n-1;j++){
                
        //         // Initialising the top, down, left and right indices of a cell.

        //         int top = i;
        //         int bottom = j;
        //         int right = (2*n - 2) - j;
        //         int left = (2*n - 2) - i;
                
        //         // Min of 4 directions and then we subtract from n
        //         // because previously we would get a pattern whose border
        //         // has 0's, but we want with border N's and then decrease inside.
        //         System.out.print(n- Math.min(Math.min(top,bottom), Math.min(left,right)) + " ");
        //     }
        //     System.out.println();
        // }
    }



}
