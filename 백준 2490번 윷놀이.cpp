#include<iostream>
#include<algorithm>
#include<functional>
using namespace std;
int arr[4];

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	for(int i=0; i<3; i++)
	{	
		for(int i=0; i<4; i++)
			cin>>arr[i];
			
	sort(arr,arr+4);
	
	if(arr[0]==1)
	cout<<"E";
	else if(arr[1]==1)
	cout<<"A";
	else if(arr[2]==1)
	cout<<"B";
	else if(arr[3]==1)
	cout<<"C";
	else
	cout<<"D";
	cout<<"\n"; 
	}
}

