#include <iostream> 
#include <fstream> 

using namespace std;

class TryTree { 
    
    struct Node { 
    int val = -1; 
    int left = -1; 
    int right = -1; 
    }; 
    
    Node* tree; 
    int size;
    
    public: 
    TryTree(ifstream& in) { 
        in >> size; 
        tree = new Node[size]; 

        int val; 
        in >> val; 
        tree[0].val = val; 

        int parent; 
        char dir; 
        for (int i = 1; i < size; i++) { 
            in >> val >> parent >> dir; 
            tree[i].val = val; 
            if (dir == 'L') { 
                tree[parent - 1].left = i; 
            } 
            else if (dir == 'R') { 
                tree[parent - 1].right = i; 
            } 
        } 
    } 
    
    bool checkTree() { 
        for (int i = 0; i < size; i++) { 
            int check; 
            if (tree[i].left != -1) { 
                check = tree[i].left; 
                while (tree[check].right != -1) { 
                    check = tree[check].right; 
                } 
                if (tree[i].val <= tree[check].val) { 
                    return false; 
                } 
            } 
            if (tree[i].right != -1) { 
                check = tree[i].right; 
                while (tree[check].left != -1) { 
                    check = tree[check].left; 
                } 
                if (tree[i].val > tree[check].val) { 
                    return false; 
                } 
            } 
        } 
        return true; 
    } 
}; 

int main() { 
    ifstream in("bst.in"); 
    ofstream out("bst.out"); 
    TryTree* tree = new TryTree(in); 
    if (tree -> checkTree()) { 
        out << "YES"; 
    } 
    else { 
        out << "NO"; 
    } 
}

