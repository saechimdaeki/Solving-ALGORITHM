#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
vector<int> v;
int sum,answer;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	v.resize(10);
	for(int i=0; i<10; i++)
	cin>>v[i];
	for(int i=0; i<10; i++)
	{
		int tmp(sum);
		sum+=v[i];
		answer+=v[i];
		if(sum>=100)
		{
		(sum-100<=100-tmp) ? (answer=sum) : (answer=tmp);
			goto z;
		}
	}
	z:
		cout<<answer;
	
	
}
