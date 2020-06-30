#include<iostream>
#include<cstring>
using namespace std;
int arr[26];
int main()
{
	string abc;
	int a(0);
    char word;
    cin>>abc;
    
    for (int i = 0; i < abc.length(); i++) {
        if (abc[i] >= 65 && abc[i] <= 90)
            arr[abc[i] - 65] += 1;
        else if (abc[i] >= 97 && abc[i] <= 122)
            arr[abc[i] - 97] += 1;
    }
   
    for (int i = 0; i < 26; i++) {
        if (arr[i] > a) {
            word = i + 65;
            a = arr[i];
        }
        else if (arr[i] == a)
            word = '?';
            
    }
    cout<<word<<endl;
 
    
 
}
