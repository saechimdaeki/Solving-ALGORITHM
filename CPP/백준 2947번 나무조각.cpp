#include<iostream>
#include<algorithm>
#include<vector>
#define endl '\n'
using namespace std;
vector<int> v(5);
void print(vector<int> v)
{
	for(int i=0; i<4; i++)
	{
		for(int j=0; j<4-i; j++)
		{
			if(v[j]>v[j+1])
			{
			swap(v[j],v[j+1]);
			for(int i=0; i<5; i++)
			cout<<v[i]<<' ';
			cout<<endl;
		}
		}
	}

}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	for(int i=0; i<5; i++)
	cin>>v[i];
	print(v);
		
} 
