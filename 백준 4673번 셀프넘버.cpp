#include<iostream>
using namespace std;
bool arr[10000];
int moohan(int n)
{
	int sum=n;
	while(1)
	{
		if(n==0)
		break;
		sum+=n%10;
		n=n/10;
	}
	return sum;
}

int main()
{
	for(int i=1; i<=10000; i++)
	{
		int abc=moohan(i);
		if(abc<=10000)
		{
			arr[abc]=true;
		}
	}
	for(int i=1; i<=10000; i++)
	{
		if(!arr[i])
		cout<<i<<endl;
	}

}
