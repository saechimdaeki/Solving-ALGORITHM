#include<iostream>
#include<cmath>
#include<algorithm>
using namespace std;
int n,k;
bool check[1001];
int eratos(int num)
{	
	for(int i=2; i<=n; i++)
	check[i]=true;
	for(int i=2; i*i<=1001*1001; i++)
	{
		if(check[i]==true)
		{
			check[i]=false;
			num--;
			if(num==0)
			return i;
			for(int j=i*i; j<=n; j+=i)
			{
				if(check[j]==true)
					{
						check[j]=false;
						num--;
						if(num==0)
						return j;
					}
			}
		}
		
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>k;
	cout<<eratos(k);
	
}
