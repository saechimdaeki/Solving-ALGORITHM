#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n,answer=-1;
vector<int> v;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	for(int i=0; i<n; i++)
		cin>>v[i];
	for(int i=-1; i<=1; i++)
	{
		for(int j=-1; j<=1; j++)
		{
			int changecount(0);
			if(i!=0)
			changecount++;
			if(j!=0)
			changecount++;
			int tmp=v[0]+i;
			int diff=(v[1]+j)-tmp;
			bool isok=true;
			int sooyeol=tmp+diff;
			for(int k=2; k<n; k++)
			{
				sooyeol+=diff;
				if(v[k]==sooyeol)
				continue;
				if(v[k]-1==sooyeol)
				changecount++;
				else if(v[k]+1==sooyeol)
				changecount++;
				else
				{
					isok=false;
					break;
				}
			}
			if(isok)
			{
				if(answer==-1 || answer>changecount)
				answer=changecount;
			}
		}
	}	
	cout<<answer;
}
