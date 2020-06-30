#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int l,r;
int sum;
int two(2);
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>l>>r;
	while(l>5)
	{
		l=(int)(l*((double)r/100));
		if(l<=5)
		break;
		sum+=two*l;
		two*=2;	
	}
	cout<<sum; 
		
}
