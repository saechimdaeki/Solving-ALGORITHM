#include<iostream>
using namespace std;

char abc[20];
char num(int n, int k)
{
	sprintf(abc, "%lld", n);
	return abc[k];
}
int main()
{
	int n;
	cin>>n;
	
	int digit(0),sum(0),psum(0),s(9);
	while(sum<n)
	{
		digit++;
		psum=sum;
		sum+=s*digit;
		s*=10;
	}
	int from(1);
	for(int i=0; i<digit-1; i++)
	from*=10;
	int idx(n-psum-1);
	
	cout<<num(from+(idx/digit),idx%digit);
}
