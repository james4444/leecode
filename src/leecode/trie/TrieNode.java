package leecode.trie;

class Trie {
    class TrieNode {
        private TrieNode[] links;

        private boolean isEnd;

        public  TrieNode(){
            links = new TrieNode[26];
        }

        public boolean containsKey(char ch){
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch){
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node){
            links[ch - 'a'] = node;
        }

        public void setEnd(){
            isEnd = true;
        }

        public boolean getEnd(){
            return isEnd;
        }
    }

    private TrieNode root ;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char currentChar = word.charAt(i);
            if(!node.containsKey(currentChar)){
                node.put(currentChar,node);
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    private TrieNode serchPrefix(String word){
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(node.containsKey(ch)){
                node = node.get(ch);
            }else{
                return null;
            }
        }
        return node;
    }


    public boolean search(String word){
        TrieNode node = serchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix){
        TrieNode node = serchPrefix(prefix);
        return node != null;
    }
}
