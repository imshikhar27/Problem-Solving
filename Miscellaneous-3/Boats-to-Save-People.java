class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int l=people.length;
        Arrays.sort(people);
        int i=0,j=l-1;;
        int boat=0;
        while(i<=j)
        {
          int first=people[i];
          while(i<=j)
          {
            int last=(i==j)?0:people[j];
            boat++;
            j--;
            if(first+last<=limit)
             break;
          }
          i++;
        }
        return boat;
    }
}
