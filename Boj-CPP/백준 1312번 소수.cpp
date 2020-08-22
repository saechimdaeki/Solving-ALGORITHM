#include<iostream>
using namespace std;

int main()
{
	int A,B,N;
	cin>>A>>B>>N;
	int bts(A%B);
	for(int i=0; i<N-1; i++)
	{
		bts*=10;
		bts%=B;
	}
	bts*=10;
	cout<<bts/B<<endl;
 } 
