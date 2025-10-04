#include <iostream>
#include <fstream>

using namespace std;

int main(){

    ofstream out("results.txt");

    for (int i = 0; i < 100; i++){
        if (i % 2 == 0){
            out << i << " is even\n";
        } else {
            out << i << " is odd\n";
        } 
    }
    out.close();

    cout << "process completed!";
    return 0;
}