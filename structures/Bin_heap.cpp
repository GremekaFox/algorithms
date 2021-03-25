#include <iostream>
#include <cmath>
#include <fstream>

using namespace std;

int main() {
    ifstream is("input.txt");
    ofstream os("output.txt");

    long long n = 0;
    is >> n;

    int len = (int) log2(n) + 1;
    bool* res = new bool[len];
    int i = 0;

    while(n != 0) {
        res[i++] = n % 2;
        n /= 2;
    }

    for(int i = 0; i < len; i++) if(res[i]) os << i << "\n";
}