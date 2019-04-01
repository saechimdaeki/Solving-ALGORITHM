#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int sum(0);
vector<int> v;
void btsforever()
{
	for(int i=0; i<9; i++)
	{
		for(int j=i+1; j<9; j++)
		{
			if(sum-v[i]-v[j]==100)
			{
				for(int abc=0; abc<9; abc++)
				{
					if(abc!=i &&abc!=j)
					cout<<v[abc]<<endl;
				}
			}
		}
	}
}
int main()
{
	for(int i=0; i<9; i++)
	{
		int a;
		cin>>a;
		sum+=a;	
		v.push_back(a);
	}
	sort(v.begin(),v.end());
	btsforever();
}
