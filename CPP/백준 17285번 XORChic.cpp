#include<iostream>
using namespace std;
string s;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>s;
	int a(s[0]^'C');
	//int b(s[1]^'H');...
	for(int i=0; i<s.length(); i++)
	{
		int b(s[i]^a);
		cout<<(char)b;
	}
}
