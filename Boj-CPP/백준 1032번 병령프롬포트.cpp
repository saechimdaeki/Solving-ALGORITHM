#include<iostream>
 using namespace std;
 
 int main()
 {
 	int n;
 	cin>>n;
 	string bts;
 	cin>>bts;
 	
 	string output=bts;
 	for(int i=0; i<n-1; i++)
 	{
 		string abc;
 		cin>>abc;
 		for(int a=0; a<bts.length(); a++)
 		{
 			if(bts[a]!=abc[a])
 				output[a]='?';
		 }
	 }
	 cout<<output<<endl;
	 
 }
