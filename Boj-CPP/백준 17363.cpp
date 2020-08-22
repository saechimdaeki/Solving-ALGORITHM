#include<iostream>
#include<algorithm>
#include<map>
using namespace std;
char grid[100][100];
map<char,char> mm;
int n,m;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	mm.insert({'.','.'});
	mm.insert({'O','O'});
	mm.insert({'-','|'});
	mm.insert({'|','-'});
	mm.insert({'/','\\'});
	mm.insert({'\\','/'});
	mm.insert({'^','<'});
	mm.insert({'<','v'});
	mm.insert({'v','>'});
	mm.insert({'>','^'});
	cin>>n>>m;
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		cin>>grid[i][j];
	}
	for(int i=m-1; i>=0; i--)
	{
		for(int j=0; j<n; j++)
		cout<<mm[grid[j][i]];
		cout<<"\n";
	}
}
