public class DesignAddSearchWordsDataStructure {
    /*
     * First try, using a Trie, but with a recursive search to handle the '.' character.
     * 
     * Runtime 168ms beats 98.29%
     */
    class WordDictionary {
        MyNode root = new MyNode();

        public WordDictionary() {
            
        }
        
        public void addWord(String word) {
            MyNode node = root;

            for(int i = 0; i<word.length(); i++){
                char actual = word.charAt(i);

                if(node.nodes[actual - 'a'] == null) 
                    node.nodes[actual - 'a'] = new MyNode(actual);

                node = node.nodes[actual - 'a'];
            }

            node.isWord = true;
        }
        
        public boolean search(String word) {
            return recursiveSearch(word, 0, root);
        }

        private boolean recursiveSearch(String word, int pos, MyNode node){
            char ch = word.charAt(pos);
            
            if(pos == word.length()-1){
                
                if(ch == '.'){
                    for(MyNode nd : node.nodes)
                        if(nd != null && nd.isWord) return true;
                    return false;
                }
                
                return (node.nodes[ch-'a'] != null && node.nodes[ch-'a'].isWord);
            }

            if(ch == '.'){
                for(int i = 0; i < 26; i++){
                    MyNode nd = node.nodes[i];
                    if(nd == null) continue;
                    if(recursiveSearch(word, pos+1, nd)) return true;
                }
                return false;
            }

            MyNode nd = node.nodes[ch-'a'];
            if(nd == null) return false;

            return recursiveSearch(word, pos+1, nd);
        }

        private class MyNode{
            MyNode[] nodes = new MyNode[26];
            char ch;
            boolean isWord = false;

            public MyNode(){}

            public MyNode(char ch){
                this.ch = ch;
            }
        }
    }
}
