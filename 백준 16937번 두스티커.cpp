#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int h,w,n,answer;
vector<int> r,c;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>h>>w>>n;
	r.resize(n); c.resize(n);
	for(int i=0; i<n; i++)
		cin>>r[i]>>c[i];
	for(int i=0; i<n; i++)
	{
		int r1=r[i],c1=c[i];
		for(int j=i+1; j<n; j++)
		{
			int r2=r[j],c2=c[j];
			for(int cr1=0; cr1<2; cr1++)
			{
				for(int cr2=0; cr2<2; cr2++)
				{
					if(r1+r2<=h &&max(c1,c2)<=w)
					{
						int tmp=r1*c1+r2*c2;
						answer=max(answer,tmp);	
					}
					if(max(r1,r2)<=h && c1+c2<=w)
					{
						int tmp=r1*c1+r2*c2;
						answer=max(answer,tmp);	
					}
					swap(r2,c2);	
				}
				swap(r1,c1);	
			}	
		}	
	}
	cout<<answer;	
}
