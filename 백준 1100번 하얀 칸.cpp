#include<iostream>
using namespace std;

string s[8];
int count123;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	for(int i=0; i<8; i++)
	cin>>s[i];
	for(int i=0; i<8; i++)
	{
		for(int j= i%2; j<8; j+=2)
		{
			if(s[i][j]=='F')
			count123++;
		}
	}
	cout<<count123;
}
