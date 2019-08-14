#include<iostream>
using namespace std;
int olim[9];
int start[9];
int sum1,sum2;
bool check(false);
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	for(int i=0; i<9; i++)
		cin>>olim[i];
	for(int i=0; i<9; i++)
		cin>>start[i];
	for(int i=0; i<9; i++)
	{
		sum1+=olim[i];
		if(sum1>sum2)
		check=true;
		sum2+=start[i];
		if(sum1>sum2)
		check=true;
	}
	if(check)
	cout<<"Yes";
	else
	cout<<"No";

}
