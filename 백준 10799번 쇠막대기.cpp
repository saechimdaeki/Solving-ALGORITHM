#include<iostream>
#include<stack>
using namespace std;
string s;
int sum;
stack<char> sk;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>s;
	char ch;
	for(int i=0; i<s.length();i++)
	{
		if(s[i]=='(')
		sk.push(s[i]);
		else
		{
			sk.pop();
			if(ch=='(')
			sum+=sk.size();
			else
			sum++;
		}
		ch=s[i];
	}
	cout<<sum;
}
