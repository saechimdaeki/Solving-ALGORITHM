#include<iostream>
#include<algorithm>
using namespace std;
int n;
int arr[6]={1,5,10,50,100,500};
int count123;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	
	int answer(1000-n);
	sort(arr,arr+6);
	reverse(arr,arr+6);
	//for(int i=0; i<6; i++)
	//cout<<arr[i]<<" "; 
	for(int i=0; i<6; i++)
	{
		while(answer-arr[i]>=0)
		{
			answer-=arr[i];
			count123++;
			if(answer==0)
			goto z;
		}
	}
	z:
		cout<< count123;
}
