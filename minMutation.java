/*A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".

Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.

For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.

Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.

Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.

Note:

Starting point is assumed to be valid, so it might not be included in the bank.
If multiple mutations are needed, all mutations during in the sequence must be valid.
You may assume start and end string is not the same.
Example 1:

start: "AACCGGTT"
end:   "AACCGGTA"
bank: ["AACCGGTA"]

return: 1
Example 2:

start: "AACCGGTT"
end:   "AAACGGTA"
bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

return: 2
Example 3:

start: "AAAAACCC"
end:   "AACCCCCC"
bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]

return: 3
*/

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)) {return 0;}

        // All possible characters
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};

        // a set has .contains(), but the provided string array doesn't
        Set<String> geneBank = new HashSet<String>();
        for (String gene: bank) {geneBank.add(gene);}

        // Tracks strings that have already been processed
        Set<String> visited = new HashSet<String>();

        int level = 0;

        Queue<String> geneQueue = new LinkedList<String>();

        geneQueue.offer(start);
        visited.add(start);

        // Breadth first search
        // Process: remove a gene string from the queue, add it to the visited list,
        // if it equals the end string, return level
        // Otherwise, change each char in the string to the 4 possible characters,
        // and check if the gene bank contains the new string and if it is not in the visited list
        // if yes -> add it to the queue for processing as well as to the visited list
        // increment the level. Keep processing until queue is empty
        while(!geneQueue.isEmpty()) {
            int size = geneQueue.size();
            // Need to process all those in the queue as 1 level
            // because 1 string might produce 1+ possible strings to be processed next
            // and they all have only 1 character change = 1 level change
            while (size > 0) {
                String currGene = geneQueue.poll();
                if(currGene.equals(end)) {
                    return level;
                }
                char[] curr = currGene.toCharArray();
                for(int i = 0; i < curr.length; i++) {
                    char oldChar = curr[i];
                    for (int j = 0; j < charSet.length; j++) {
                        curr[i] = charSet[j];
                        String newGene = new String(curr);
                        if (geneBank.contains(newGene) && !visited.contains(newGene)) {
                            visited.add(newGene);
                            geneQueue.offer(newGene);

                        }
                    }
                    curr[i] = oldChar;
                }

                size--;
            }
            level++;


        }

        return -1;
    }
}
