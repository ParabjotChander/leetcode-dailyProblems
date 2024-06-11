class leetcode861 {
    
    public int matrixScore(int[][] grid) {
        
        int sum = 0;
        
        // Row Change, if the most significant bit is 1, dont change or else flip the bits to make the most significant bit 1 to increase the binary number for the row
        // For Example: we know that 1000 > 0111 since 8 > 7 
        // thats why the goal is to make the most significant bit 1

        for(int i = 0; i < grid.length; i++){

            if(grid[i][0] == 0){

                for(int j = 0; j < grid[i].length; j++){

                    if(grid[i][j] == 0){
                        grid[i][j] = 1;
                    }
                    else{
                        grid[i][j] = 0;
                    }
                
                }
            
            }
        
        }
    
        // Column Change, count the number if ones and zeros, if zeros are greater than ones for a column, then flip the column 
        for(int i = 0; i < grid[0].length; i++){

            int zeroCount = 0;
            int oneCount = 0;
            
            for(int j = 0; j < grid.length; j++){

                if(grid[j][i] == 1){
                    oneCount++;
                }
                else{
                    zeroCount++;
                }
            
            }
        
            if(oneCount < zeroCount){

                for(int x = 0; x < grid.length; x++){

                    if(grid[x][i] == 0){
                        grid[x][i] = 1;
                    }else{
                        grid[x][i] = 0;
                    }   
                
                }
            
            }
        
        }

        //Calculating the base 10 number from binary and adding it to the sum  
        for(int i = 0; i < grid.length; i++){

            int power = 0;
            int num = 0;
            
            for(int j = grid[i].length-1; j >= 0; j--){

                if(grid[i][j] == 1){
                    num += (int)Math.pow(2,power);
                }
                
                power++;
            }
        
            sum += num;
        }
        
        return sum;
    }

}