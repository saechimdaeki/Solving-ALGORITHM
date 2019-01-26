#include<iostream>
using namespace std;
char arr[1001][1001];
void triangle(int numline,int x,int y)
{
	if(numline==3)
	{
		arr[y][x]='*';
		arr[y+1][x-1]='*';
		arr[y+1][x+1]='*';
		
		arr[y+2][x-2]='*';
		arr[y+2][x-1]='*';
		arr[y+2][x]='*';
		arr[y+2][x+1]='*';
		arr[y+2][x+2]='*';
		
	}
	else
	{
		triangle(numline/2,x,y);
		triangle(numline/2,x-numline/2,y+numline/2);
		triangle(numline/2,x-numline/2,y+numline/2);
	}
}



int main()
{
	int n;
	cin>>n;
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<2*n-1; j++)
		arr[i][j]=' ';
	}
	triangle(n,n-1,0);
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<2*n-1; j++)
		cout<<arr[i][j];
	}
	cout<<"\n";
	
}
