
/*
 * Insert and search costs O(key_length), 
 * however the memory requirements of Trie is O(ALPHABET_SIZE * key_length * N) where N is number of keys in Trie.
 */
public class Trie {

	static final int ALPHABET_SIZE = 26;
	static class TrieNode{
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
		
		boolean isEndOfWord;
		
		TrieNode() {
			isEndOfWord = false;
			for(int i=0;i < ALPHABET_SIZE;i++)
				children[i] = null;
			
		}	
	};
	
	static TrieNode root;
	
	static void insert(String key) {
		int length = key.length();
		int level,index;
		
		TrieNode pCrawl = root;
		
		for(level =0; level <length;level++) {
			index = key.charAt(level) -'a';
			
			if(pCrawl.children[index] == null)
				pCrawl.children[index] = new TrieNode();
			
			pCrawl = pCrawl.children[index];
			
		}
		pCrawl.isEndOfWord = true;
	}
	
	static boolean search(String key) {
		int length = key.length();
		int level,index;
		
		TrieNode pCrawl = root;
		
		for(level =0; level <length; level++) {
			index = key.charAt(level) - 'a';
			
			if(pCrawl.children[index] == null)
				return false;
			
			pCrawl = pCrawl.children[index];
		}
		return (pCrawl !=null && pCrawl.isEndOfWord);
	}
	
	static boolean isLastNode(TrieNode root)
	{
		for(int i =0;i < ALPHABET_SIZE;i++)
		{
			if(root.children[i] != null)
				return false;
		}
		return true;
		
	}
	
	static void suggestionsRec(TrieNode root, String prefix)
	{
		if(root.isEndOfWord)
		{
			System.out.println(prefix);
		}
		
		if(isLastNode(root))
			return;
		
		for(int i =0; i<ALPHABET_SIZE; i++)
		{
			if(root.children[i] != null)
			{
				int s = i + 'a';
				prefix = prefix.concat(Character.toString((char)s));
				
				suggestionsRec(root.children[i], prefix);
				
				prefix = prefix.substring(0,prefix.length() - 1);
			}
		}
		
	}
	static int printAutoSuggestion(TrieNode root, String query)
	{
		TrieNode pCrawl = root;
		int level;
		int n = query.length();
		for(level =0; level<n;level++)
		{
			int index = query.charAt(level) - 'a';
			
			if(pCrawl.children[index] == null)
				return 0;
			
			pCrawl = pCrawl.children[index];
						
		}
		
		boolean isWord = pCrawl.isEndOfWord;
		
		boolean isLastNode = isLastNode(pCrawl);
		
		if(isWord && isLastNode)
		{
			System.out.println(query);
			return -1;
		}
		
		if(!isLastNode)
		{
			String prefix = query;
			suggestionsRec(pCrawl,prefix);
			return 1;
		}
		return 0;
	}
	
	
	public static void main(String[] args) {
		
		String keys[] = {"bicycle", "a", "there", "their", "themselves", 
                "by", "bye", "therefore"}; 

		String output[] = {"Not present in trie", "Present in trie"};
		
		root = new TrieNode();
		
		// Construct trie 
        int i; 
        for (i = 0; i < keys.length ; i++) 
            insert(keys[i]); 
       
        
        int comp = printAutoSuggestion(root, "by");
        
        if(comp == -1)
        {
        	System.out.println("No other Strings found with prefix");
        }
        
        if(comp == 0)
        	System.out.println("No Strings found with prefix");
        
        
        /*
        // Search for different keys 
        if(search("the") == true) 
            System.out.println("the --- " + output[1]); 
        else System.out.println("the --- " + output[0]); 
          
        if(search("these") == true) 
            System.out.println("these --- " + output[1]); 
        else System.out.println("these --- " + output[0]); 
          
        if(search("their") == true) 
            System.out.println("their --- " + output[1]); 
        else System.out.println("their --- " + output[0]); 
          
        if(search("thaw") == true) 
            System.out.println("thaw --- " + output[1]); 
        else System.out.println("thaw --- " + output[0]); */
	}

}
