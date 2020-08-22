#include<iostream>
#include<stack>
using namespace std;

int vps(string s)
{
	int len=s.length();
	stack<char> bts;
	for(int i=0; i<len; i++)
	{
		char a=s[i];//문자열하나씩 받기
		if(a=='(')
		 {
		 	bts.push(s[i]);
		 }
		 else{//닫는괄호면 
		 	if(bts.empty())
			 return 0;
			 else
			 bts.pop(); 
		 }
	}
	return bts.empty();
}
int main()
{
	int n;
	cin>>n;
	for(int i=0; i<n; i++)
	{
		string s;
		cin>>s;
		if(vps(s))
		cout<<"YES"<<"\n";
		else
		cout<<"NO"<<"\n";
	}
}
