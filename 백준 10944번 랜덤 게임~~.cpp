#include<iostream>
#include<cmath>
#include<ctime>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cout.tie(NULL);
	srand(time(NULL));
	while(1)
	{
	
	int x=rand()%10000;
		if(x==1)
		{
			cout<<x;
			break;	
		}
		
		
	}
	
}
