#include <iostream>
#include <string.h>
using namespace std;
int stack[10001], top = -1;
void push(int x){
    stack[++top] = x;
}
int empty() {
    if (top < 0)return 1;
    else return 0;
}
void pop() {
    if (empty() == 1)cout << "-1"<<"\n";
    else {
        cout << stack[top] << "\n";
        stack[top--] = 0;
    }
}
 
int main() {
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        char str[10];
        cin >> str;
        if (!strcmp(str, "push")) {
            int x; cin >> x;
            push(x);
        }
        else if (!strcmp(str, "top")) {//top()함수를 만들면 top 변수와 겹치기 때문에 만들지 않음
            if (empty() == 1)cout << "-1"<<"\n";
            else cout << stack[top] << "\n";
        }
        else if (!strcmp(str, "pop")) {
            pop();
        }
        else if (!strcmp(str, "empty")) {
            cout << empty() << "\n";
        }
        else {//empty()함수는 간단하기 때문에 함수를 만들지 않음
            cout << top + 1 << "\n";
        }
    }
    return 0;
}



