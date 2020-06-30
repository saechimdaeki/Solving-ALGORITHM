#include<iostream>
#define endl '\n'
using namespace std;

int gcd(int a, int b){
	if (b==0)
	return a;
	return gcd(b, a%b);
}
int n,m;
string s,num1,num2;
int t;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>s;
	for(int i=0; i<s.length(); i++)
	{
		if(s[i]==':')
		t=i;	
	}
	for(int i=0; i<t; i++)
	{
		num1+=s[i];
	}
	for(int i=t+1; i<s.length(); i++)
	{
		num2+=s[i];
	}
	int n1(stoi(num1));
	int n2(stoi(num2));
	
	cout<<n1/(gcd(n1,n2))<<":"<<n2/(gcd(n1,n2));
	
}
