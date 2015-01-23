public class Board 
{   
    private int board[][];
    
    public void Board()
    {
        newBoard();
    }
    
    public void newBoard()
    {
        board = new int[4][4];
        for (int i = 0; i < 4; i++) 
        {
            for (int j = 0; j < 4; j++) 
            {
                board[i][j] = 0;
            }
        }
        board[0][0] = 2;
        board[(int)(Math.random()*4)][(int)(Math.random()*4)] = (int)(Math.random()*2+1)*2;
    }
    
    public int getTile(int x, int y)
    {
        return board[x][y];
    }
    
    public void addNum()
    {
        int pox = (int)(Math.random()*4);
        int poy = (int)(Math.random()*4);
        int trys = 0;
        while(board[pox][poy] != 0 && trys < 400)
        {
            pox = (int)(Math.random()*4);
            poy = (int)(Math.random()*4);
            trys++;
        }
        if(trys < 400)
            if(Math.random()*100 < 20)
                board[pox][poy] = 4;
            else
                board[pox][poy] = 2;
    }
    
    public boolean hasWon()
    {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(board[i][j] == 2048)
                    return true;
            }
        }
        return false;
    }
    
    
    public void Move(char Dir)
    {
        int[][] temp = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                temp[i][j] = board[i][j];
            }
        }
        switch(Dir)
            {
                case 'D':
                    for (int x = 2; x >= 0; x--) 
                    {
                        for (int y = 0; y < 4; y++) 
                        {
                            if(board[x+1][y] == board[x][y])
                            {
                                board[x+1][y] *=2;
                                board[x][y] = 0;
                            }
                            else if(board[x][y] == 0)
                            {
                                board[x][y] = board[x+1][y];
                                board[x+1][y] = 0;
                            }
                            
                        }
                    }
                    for (int i = 0; i < 4; i++) 
                    {
                        for (int x = 1; x < 4; x++)//row
                        {
                            for (int y = 0; y < 4; y++)//colomn
                            {
                                if(board[x][y] == 0)
                                {
                                    board[x][y] = board[x-1][y];
                                    board[x-1][y] = 0;
                                }
                            }
                        }
                    }
                    break;
                case 'U':
                    for (int x = 1; x < 4; x++) 
                    {
                        for (int y = 0; y < 4; y++) 
                        {
                            if(board[x-1][y] == board[x][y])
                            {
                                board[x-1][y] *=2;
                                board[x][y] = 0;
                            }
                            else if(board[x][y] == 0)
                            {
                                board[x][y] = board[x-1][y];
                                board[x-1][y] = 0;
                            }
                            
                        }
                    }
                    for (int i = 0; i < 4; i++) 
                    {
                        for (int x = 2; x >= 0; x--)//row
                        {
                            for (int y = 0; y < 4; y++)//colomn
                            {
                                if(board[x][y] == 0)
                                {
                                    board[x][y] = board[x+1][y];
                                    board[x+1][y] = 0;
                                }
                            }
                        }
                    }
                    break;
                case 'L':
                    for (int x = 0; x < 4; x++) 
                    {
                        for (int y = 1; y < 4; y++) 
                        {
                            if(board[x][y-1] == board[x][y])
                            {
                                board[x][y-1] *=2;
                                board[x][y] = 0;
                            }
                            else if(board[x][y] == 0)
                            {
                                board[x][y] = board[x][y-1];
                                board[x][y-1] = 0;
                            }
                        }
                    }
                    for (int i = 0; i < 4; i++) 
                    {
                        for (int x = 0; x < 4; x++)//row
                        {
                            for (int y = 2; y >= 0; y--)//colomn
                            {
                                if(board[x][y] == 0)
                                {
                                    board[x][y] = board[x][y+1];
                                    board[x][y+1] = 0;
                                }
                            }
                        }
                    }
                    break;
                case 'R':
                    for (int x = 0; x < 4; x++) 
                    {
                        for (int y = 2; y >= 0; y--) 
                        {
                            if(board[x][y+1] == board[x][y])
                            {
                                board[x][y+1] *=2;
                                board[x][y] = 0;
                            }
                            //Shift a zero left
                            else if(board[x][y] == 0 )
                            {
                                board[x][y] = board[x][y+1];
                                board[x][y+1] = 0;
                            }
                        }
                    }
                    //shift all zeros
                    for (int i = 0; i < 4; i++) 
                    {
                        for (int x = 0; x < 4; x++)//row
                        {
                            for (int y = 1; y < 4; y++)//colomn
                            {
                                if(board[x][y] == 0)
                                {
                                    board[x][y] = board[x][y-1];
                                    board[x][y-1] = 0;
                                }
                            }
                        }
                    }
                    break;
            }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(board[i][j] != temp[i][j])
                {
                    addNum();
                    return;
                }
            }
        }
    }
    
    public String toString()
    {
        String toReturn = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                toReturn+=board[i][j]+" ";
            }
            toReturn+='\n';
        }
        return toReturn;
    }
}
