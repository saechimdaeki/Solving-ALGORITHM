#include<iostream>
#include<vector>
using namespace std;
int a,b,v;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>a>>b>>v;
	int count(0);
	count=(v-b-1)/(a-b)+1;
	cout<<count; 
}
