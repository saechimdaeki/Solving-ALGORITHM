#include<iostream>
#define endl '\n'
using namespace std;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	for(int i=1; i<=100; i++)
	{
		string s;
		getline(cin,s);
		if(s=="Was it a cat I saw?")
			break;
		for(int j=0; j<s.length(); j+=(i+1))
			cout<<s[j];
		cout<<endl;
		
	}
}
