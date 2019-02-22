#include<iostream>
using namespace std;

int arr[247000];
int main()
{
	 

	for(int i=1; i<247000; i++)
	{
		
		arr[1]=1;
		for(int a=2*i; a<=247000; a+=i)
			arr[a]=1;
	}
	int n;
	while(true)
	{
		cin>>n;
		if(!n)
		break;
		int sosue(0);
		for(int i=n+1; i<=2*n; i++)
		{
			if(!arr[i])
				sosue++;
		}
		cout<<sosue<<endl;
	}
}
