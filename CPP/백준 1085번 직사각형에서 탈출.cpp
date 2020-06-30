#include<iostream>
#include<algorithm>
using namespace std;

int main()
{
	int x,y,w,h;
	cin>>x>>y>>w>>h;
	int edge=min(w-x,x);
	edge=min(edge,min(h-y,y));
	cout<<edge;	
} 
