#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
vector<int> v;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	v.resize(9);
	int sum(0);
	int answer;
	cin>>answer;
	for(int i=0; i<9; i++)
	{
		cin>>v[i];
		sum+=v[i];	
	}
	cout<<answer-sum;
}
