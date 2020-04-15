#include<iostream>
#include<algorithm>
#include<vector>
#include<cmath>
using namespace std;
vector<int> v(9);
vector<int> d(9);

bool magic_square(vector<int> &v1)
{
	int tmp(v1[0]+v1[1]+v1[2]);
	for(int i=0; i<3; i++) //row
	{
		int sum(0);
		for(int j=0; j<3; j++)
		sum+=v1[i*3+j];
		if(tmp!=sum)return false;
	}
	for(int i=0; i<3; i++) //colum
	{
		int sum(0);
		for(int j=0; j<3; j++)
		sum+=v1[j*3+i];
		if(tmp!=sum)return false;
	}
	if(tmp!=v1[0]+v1[4]+v1[8])return false;
	if(tmp!=v1[2]+v1[4]+v1[6])return false;
	return true;
	
	
}
int difference(vector<int> &v1, vector<int> &v2)
{
	int ans(0);
	for(int i=0; i<9; i++)
		ans+=abs(v1[i]-v2[i]);
	return ans;
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	for(int i=0; i<9; i++)
	{
		cin>>v[i];
		d[i]=i+1;		
	}
	int answer(-1);
	do{
		if(magic_square(d))
		{
			int cost(difference(v,d));
			if(answer==-1 || answer>cost)
			answer=cost;
		}
	}while(next_permutation(d.begin(),d.end()));
	cout<<answer;	
}
