#include<iostream>
#include<cmath>
#include<ctime>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);

	while(1)
	{
	srand(time(NULL));
	int x=rand()%10000;
		if(x==1)
		{
			cout<<x;
			break;	
		}
		
		
	}
	
}
