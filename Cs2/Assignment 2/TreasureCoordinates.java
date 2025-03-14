import java.util.*;

public class TreasureCoordinates
{

    ArrayList<String> determineCoordinates(String s)
    {
        ArrayList<String> coords = new ArrayList<>();  // stores valid coordinates

        StringBuilder nums = new StringBuilder(s.substring(1, s.length()-1)); //remove parentheses 

        StringBuilder L = new StringBuilder();
        StringBuilder R = new StringBuilder();

        int n = nums.length();

        determineCoordinatesR(coords, nums, L, R, 0, false, false, n); //call recursive function

        return coords;
    }
    
    void determineCoordinatesR(ArrayList<String> coords, StringBuilder nums, StringBuilder L, StringBuilder R, int index, Boolean dotL, Boolean dotR, int n)
    {
            if(index == n)
            {
                if(L.length() != 0 && R.length() != 0 && isValid(L) && isValid(R)) //check if both L and R coords are valid
                {
                    coords.add("(" + L + ", " + R + ")"); //add to valid coords
                }

                return;  
                
            }
                
                if(R.length() == 0)  //recurse through L coords
                {
                    L = L.append(nums.charAt(index));
                    determineCoordinatesR(coords, nums, L , R, index + 1, dotL, dotR, n);
                    L = L.deleteCharAt(L.length()-1);  //backtrack
                }

                if(L.length() != 0)  //recurse through R coords
                {
                    R = R.append(nums.charAt(index));
                    determineCoordinatesR(coords, nums, L, R, index + 1, dotL, dotR, n);
                    R = R.deleteCharAt(R.length()-1);  //backtrack
                }

                if(L.length() > 0 && index < n && !dotL)  //recurse through L coords with decimal
                {
                    L = L.append(".");
                    determineCoordinatesR(coords, nums, L, R, index, true, dotR, n);
                    L = L.deleteCharAt(L.length()-1);  //backtrack
                    dotL = false;
                }

                if(R.length() > 0 && index < n && !dotR)  //recurse through R coords with decimal
                {
                    R = R.append(".");
                    determineCoordinatesR(coords, nums, L, R, index, dotL, true, n);
                    R = R.deleteCharAt(R.length()-1);  //backtrack
                    dotR = false;
                }

        
    }
        
        boolean isValid(StringBuilder temp)
        {
            //filter coords that start with 0 but are not 0 or 0.0
            if(temp.charAt(0) == '0' && temp.length() > 1 && temp.charAt(1) != '.')
            {
                return false;
            }

            //filter coords starting or ending with decimals
            if(temp.charAt(0) == '.' || temp.charAt(temp.length()-1) == '.')
            {
                return false;
            }

            //filter coords with trailing zeros
            if(temp.length() > 1 && temp.lastIndexOf("0") == temp.length()-1)
            {
                return false;
            }

            return true;

        }



}

