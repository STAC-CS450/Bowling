import java.util.*;

public class Game 
{
    private List <String> rolls = new ArrayList<>(); // Dynamic list to store struck pins
    private int score; // Store current score

    Game(String input)
    {
        rolls = Arrays.asList(input.split(" "));
        score = 0;
    }

    public static void main(String[] args)
    {
    	int score = new Game("10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10").score();
    	System.out.println(score + " Points! Wow a perfect score! ... (Yes, while this is hardcoded it still works!)");
    }
    
    public int score ()
    {
        if (rolls.get(0) == "") return 0; //return 0 if no pins are struck at all
        int frameIndex = 0;
        
        try
        {
            for (int i = 0; i < 10 ; i ++)
            {
                if(rolls.get(frameIndex).equals("10")) 
                { // strike
                    score += 10;
                    score += Integer.parseInt(rolls.get(frameIndex+1)) ;
                    score += Integer.parseInt(rolls.get(frameIndex+2));
                    frameIndex++;
                }
                else if (Integer.parseInt(rolls.get(frameIndex)) + Integer.parseInt(rolls.get(frameIndex+1)) == 10 ) 
                { // Spare
                    score += 10;
                    score += Integer.parseInt(rolls.get(frameIndex + 2));
                    frameIndex += 2;
                }
                else 
                {
                    int sum = Integer.parseInt(rolls.get(frameIndex)) + Integer.parseInt(rolls.get(frameIndex+1)); //to check for normal input
                    if (sum>10) break; // break loop if sum frame > 10  -- not possible in reality
                    else score+= sum;
                    frameIndex +=2;
                }
            }
            return score;
        }
        	catch (ArrayIndexOutOfBoundsException e) 
        { 	// exception thrown when no pins left & frame incomplete.
        		return score;
        }
    }
}