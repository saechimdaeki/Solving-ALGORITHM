#include<iostream>
#include<algorithm>
using namespace std;
int dynamic[1000001];
int n;
 void backprint(int n1)
 {
 	if(n1==0)
 	return;
 	cout<<n1<<" ";
 	if(n1%3==0&&dynamic[n1]==(dynamic[n1/3]+1))
 	backprint(n1/3);
 	else if(n1%2==0 && dynamic[n1]==(dynamic[n1/2]+1))
 	backprint(n1/2);
 	else if((n1-1>=0)&&(dynamic[n1]==dynamic[n1-1]+1))
 	backprint(n1-1);
 	return;
 }
 int main()
 {
 	ios::sync_with_stdio(false);
 	cin.tie(NULL);
 	cin>>n;
 	
 	for(int i=2; i<=n; i++)
 	{
 		dynamic[i]=dynamic[i-1]+1;
 		if(i%2==0)
 		dynamic[i]=min(dynamic[i],dynamic[i/2]+1);
 		if(i%3==0)
 		dynamic[i]=min(dynamic[i],dynamic[i/3]+1);
	 }
	 cout<<dynamic[n]<<"\n";
	 if(n==0)
	 return 0;
	 else
	 backprint(n);
 	
 }
