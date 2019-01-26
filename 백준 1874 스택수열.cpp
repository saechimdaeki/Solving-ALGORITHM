#include<iostream>
#include<cstring>
#define len 10000
using namespace std;

class stack{
	public:
	int topindex=-1;
	int arr[len];
	
	void push(int data)
	{	topindex++;
		arr[topindex]=data;
	}	
	int pop()
	{
		cout<<arr[topindex]<<endl;
		topindex--;
	}
};

int main()
{	stack s;
	int n;//명령 줄의 수
	cin>>n; 
	for(int i=0; i<n; i++)
	{
		cin>>s.arr[i];
	}
	
}
