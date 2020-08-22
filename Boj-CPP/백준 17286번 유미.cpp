#include<iostream>
#include<cmath>
using namespace std;
int arr[4][2];
int ans=123456789;
int k;
double calc(int a, int b) {
	return sqrt((arr[a][0]-arr[b][0])*(arr[a][0]-arr[b][0])+(arr[a][1]-arr[b][1])*(arr[a][1]-arr[b][1]));
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	double t;
	for (int i = 0; i < 4; i++)
	 cin>>arr[i][0]>>arr[i][1];
	for (int i = 1; i < 4; i++)
	{
		for (int j = 1; j < 4; j++)
		{
			if (i!=j) {
			k=6-i-j;
			t=calc(0,i)+calc(i,j)+calc(j,k);
			ans=min(ans,(int)t);	
		}
	}	
	} 
	cout<<ans;
}
