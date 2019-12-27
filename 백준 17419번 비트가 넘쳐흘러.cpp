#include<iostream>
#include<algorithm>
using namespace std;
int n,count123;
string s;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	cin>>s;
	for(int i=0; i<n; i++)		
		if(s[i]=='1')
		count123++;

	cout<<count123;
	
}
