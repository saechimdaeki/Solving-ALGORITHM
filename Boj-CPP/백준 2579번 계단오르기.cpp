#include <iostream>
#include<algorithm> 
using namespace std;
 int dynamic[305];
    int dp[305];
 
int main(){
    
    int n;
   
    cin>>n;
 
    for (int i = 1; i <= n; i++)
        cin>>dynamic[i];
 
    for (int i = 1; i <= 3 && i <= n; i++)
        if (i!=3)
            dp[i] = dp[i - 1] + dynamic[i];
        else
            dp[i] = max(dynamic[i] + dp[i - 2], dynamic[i] + dynamic[i - 1]);
 
    for (int i = 4; i <= n; i++)
        dp[i]=max(dynamic[i] + dp[i - 2], dynamic[i] + dynamic[i - 1] + dp[i - 3]);
 
	cout<<dp[n];
 
}



