#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct trie {
int isWord;
struct trie *next[26];
};

struct trie* init() {
// Create the struct, not a word.
struct trie* myTree = malloc(sizeof(struct trie));
myTree->isWord = 0;
// Set each pointer to NULLL.
int i;
for (i=0; i<26; i++)
myTree->next[i] = NULL;
// Return a pointer to the new root.
return myTree;
}

void insert(struct trie **ppTrie, char *word);
int numberOfOccurances(struct trie *pTrie, char *word);
struct trie *deallocateTrie(struct trie *pTrie);
int main(void)
{
    // read the number of the words in the dictionary
    //  parse line  by line, and insert each word to the trie data structure
    char *pWords[] = {"notaword", "ucf", "no", "note", "corg"};

    struct trie *trie = init();

    for (int i = 0; i < 5; i++)
        insert(&trie, pWords[i]);

    for (int i = 0; i < 5; i++)
    {
        printf("\t%s : %d\n", pWords[i], numberOfOccurances(trie, pWords[i]));
    }
    trie = deallocateTrie(trie);
    if (trie != NULL)
        printf("There is an error in this program\n");
    return 0;
}
void insert(struct trie **ppTrie, char *word) {
int len = strlen(word);
int index;
struct trie *current = *ppTrie;
for (int i = 0; i < len; i++) {
    index = word[i] - 'a';
    if (!current->next[index]) {
        current->next[index] = init();
    
    current = current->next[index];
    }
    current->isWord = 1;
}
}
int numberOfOccurances(struct trie *pTrie, char *word) {
    int count = 0;
    int len = strlen(word);
    struct trie *current = pTrie;
    for(int i = 0; i < len; i++) {
        int index = word[i] - 'a';
        if(current->isWord == 1) {
            count++;
            return count;
        }
        current = current->next[index];
    }
 return count;
}
struct trie *deallocateTrie(struct trie *pTrie){
    if(pTrie == NULL) {
        return NULL;
    }
    for(int i = 0; i < 26; i++) {
        deallocateTrie(pTrie->next[i]);
    }
    free(pTrie);
    return NULL;
}