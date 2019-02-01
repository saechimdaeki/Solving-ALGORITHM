#include<iostream>

using namespace std;

int gcd(int a,int b)
{
	if(a%b==0)
	return b;
	
	return gcd(b,a%b);
}
int lcm(int a , int b)
{
	return (a*b)/gcd(a,b);
}



int main()
{
	int M,N,x,y;
	int num;
	cin>>num;
	
	for(int i=0; i<num; i++)
	{
		cin>>M>>N>>x>>y;
		int end=lcm(M,N);
		
		while(true)
		{
			if(x>end||(x-1)%N+1==y)
			break;
			x+=M;
		}
		if(x>end)
		cout<<"-1"<<endl;
		else
		cout<<x<<endl;
	}
	
}
