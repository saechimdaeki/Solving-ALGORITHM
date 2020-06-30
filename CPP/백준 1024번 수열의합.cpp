#include<iostream>
#include<algorithm>
using namespace std;

void from_n(int n1, int n2)
{
	for(int i=n1; i<n1+n2; i++)
	cout<<i<<" ";
}

int until_n(int n)
{
	return n*(n+1)/2; //시그마 그 공식  
}



int main()
{
	int n,l;
	int bts;
	cin>>n>>l;
	for(int i=l; l<=100; i++)
	{
		if((n-until_n(l-1))/l>=0 && (n- until_n(l-1))%l==0)
		{
			bts=(n-until_n(l-1))/l;
			
			for(int k=bts; k<bts+l; k++)
			cout<<k<<" ";
			goto z;
		}
		l++;
	}
	cout<<"-1";
	z:
		return 0;
}
