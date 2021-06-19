#include <iostream>
#include <vector>
#include <fstream>
#include <stack>

using namespace std;

struct Node {
  Node* right;
  Node* left;
  Node* parent;
  int height;
  int leafs;
  int count;
  int val;
  Node(): right(nullptr), left(nullptr), leafs(0), height(0), count(0), val(0) {}
};

class Tree {
  private:

    void putNode(int val, Node* & cur, Node* parent) {
      if(cur == nullptr) {
        cur = new Node();
        cur->val = val;
        cur->parent = parent;
      }
      else if(cur->val > val) putNode(val, cur->left, cur);
      else if(cur->val < val) putNode(val, cur->right, cur);
    }

    void leftTraversal(Node* cur) {
      if(cur == nullptr) return;

      leftTraversal(cur->left);
      leftTraversal(cur->right);

      if(cur->left != nullptr || cur->right != nullptr) cur->height = max(cur->left == nullptr ? 0 : cur->left->height, cur->right == nullptr ? 0 : cur->right->height) + 1;

      if(cur->right == nullptr && cur->left == nullptr) cur->leafs = 1;
      else {
        if(cur->right == nullptr) cur->leafs = cur->left->leafs;
        else if(cur->left == nullptr) cur->leafs = cur->right->leafs;
        else {
          if(cur->right->height >= cur->left->height) cur->leafs += cur->right->leafs;
          if(cur->left->height >= cur->right->height) cur->leafs += cur->left->leafs;
        }
      }

      int len = 0;
      if(cur->right != nullptr) len += cur->right->height + 1;
      if(cur->left != nullptr) len += cur->left->height + 1;
      if(len > maxLen) maxLen = len;
    }

  public:
    Node* root;
    int maxLen = 0;

    Tree() {
      root = nullptr;
    }

    void deleteElem(Node* del) {
      if(del == nullptr) return;

      if(del->right != nullptr && del->left != nullptr) {
        Node* tmp = del->right;
        while(tmp->left != nullptr) tmp = tmp->left;
        int value = tmp->val;
        deleteElem(tmp);
        del->val = value;
      }
      else if(del->right == nullptr && del->left == nullptr) {
        if(del == root) root = nullptr;
        else del->parent->left == del ? del->parent->left = nullptr : del->parent->right = nullptr;
      }
      else if(del->right == nullptr && del->left != nullptr) {
        if(del == root) {
          del->left->parent = nullptr;
          this->root = del->left;
        }
        else {
          del->left->parent = del->parent;
          del->val > del->parent->val ? del->parent->right = del->left : del->parent->left = del->left;
        }
      }
      else if(del->right != nullptr && del->left == nullptr) {
        if(del == root) {
          del->right->parent = nullptr;
          this->root = del->right;
        }
        else {
          del->right->parent = del->parent;
          del->val > del->parent->val ? del->parent->right = del->right : del->parent->left = del->right;
        }
      }
    }

    void fillTree() {
      int val;
      while(cin >> val) {
        putNode(val, root, nullptr);
      }
    }

    Node* min;

    void findMin(Node* cur) {
      if(cur == nullptr) return;
      if(cur->count != 0 && cur->count % 2 == 0) {
        if(min->val > cur->val) min = cur;
      }
      findMin(cur->left);
      findMin(cur->right);
    }

    void setCounts(Node* cur, int count) {
      if(cur->right != nullptr && cur->left != nullptr) {
        if(cur->right->height + cur->left->height + 2 == maxLen) {
          if(cur->right->height == cur->left->height) {
            setCounts(cur->right, count > 0 ? count - cur->left->leafs + cur->right->leafs * cur->left->leafs : cur->right->leafs * cur->left->leafs);
            setCounts(cur->left, count > 0 ? count - cur->right->leafs + cur->right->leafs * cur->left->leafs : cur->right->leafs * cur->left->leafs);
          }
          else {
            if(cur->right->height > cur->left->height) {
              setCounts(cur->right, count + cur->right->leafs * cur->left->leafs);
              setCounts(cur->left, cur->right->leafs * cur->left->leafs);
            }
            else if(cur->left->height > cur->right->height) {
              setCounts(cur->left, count + cur->right->leafs * cur->left->leafs);
              setCounts(cur->right, cur->right->leafs * cur->left->leafs);
            }
          }
          count += cur->right->leafs * cur->left->leafs;
        }
        else {
          if(cur->right->height > cur->left->height) {
            setCounts(cur->right, count);
            setCounts(cur->left, 0);
          }
          else if(cur->left->height > cur->right->height) {
            setCounts(cur->left, count);
            setCounts(cur->right, 0);
          }
          else if(cur->left->height == cur->right->height) {
            setCounts(cur->right, count - cur->left->leafs);
            setCounts(cur->left, count - cur->right->leafs);
          }
        }
      }

      else if(cur->right != nullptr && cur->left == nullptr) {
        if(cur->height == maxLen) count += cur->leafs;
        setCounts(cur->right, count);
      }
      else if(cur->left != nullptr && cur->right == nullptr) {
        if(cur->height == maxLen) count += cur->leafs;
        setCounts(cur->left, count);
      }

      cur->count = count;
    }

    void findAndDelete() {
      leftTraversal(this->root);
      Node tmp;
      min = new Node();
      min->val = INT32_MAX;
      setCounts(this->root, 0);
      findMin(this->root);
      if(min->val != INT32_MAX) deleteElem(min);
    }

    void leftPrintTree(Node* cur) {
      if(cur == nullptr) return;
      cout << cur->val << "\n";
      leftPrintTree(cur->left);
      leftPrintTree(cur->right);
    }
};

int main() {
  freopen("tst.in", "r", stdin);
  freopen("tst.out", "w", stdout);

  Tree tree;
  tree.fillTree();
  // tree.leftPrintTree(tree.root);
  tree.findAndDelete();
  // cout << "\n";
  tree.leftPrintTree(tree.root);
}
