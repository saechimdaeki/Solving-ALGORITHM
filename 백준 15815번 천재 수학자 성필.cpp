#include <iostream>
#include <algorithm>
#include <stack>
#include<cstring>
using namespace std;

char arr[101];
stack<int> s;

void input(){
    scanf("%s", arr);
}

void operPlus(int num1, int num2){
    s.push(num1 + num2);
}

void operMinus(int num1, int num2){
    s.push(num1 - num2);
}

void operMulti(int num1, int num2){
    s.push(num1 * num2);
}

void operDiv(int num1, int num2){
    s.push(num1 / num2);
}

void runOperation(char op){
    int num2 = s.top();
    s.pop();
    int num1 = s.top();
    s.pop();

    switch (op) {
        case '+' :
            operPlus(num1, num2);
            break;
        case '-' :
            operMinus(num1, num2);
            break;
        case '*' :
            operMulti(num1, num2);
            break;
        case '/' :
            operDiv(num1, num2);
    }
}
bool isNumber(char x){
    char op[] = {'+', '-', '*', '/'};
    for (int i = 0; i < 4; i++) {
        if (op[i] == x) {
            return false;
        }
    }
    return true;
}
void solve(){
    for (int i = 0; i < strlen(arr); i++) {
        if (isNumber(arr[i])) {
            s.push(arr[i] - '0');
        } else {
            runOperation(arr[i]);
        }
    }

    cout << s.top();
}

int main(){

    input();
    solve();

    return 0;
}
