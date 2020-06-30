#include<iostream>

using namespace std;

int arr[51];

int fibo(int n)
{
   if(n<2) return 1;
   if(!arr[n-2]) arr[n-2] = fibo(n-2);
   if(!arr[n-1]) arr[n-1] = fibo(n-1);
   return (1+arr[n-2]+arr[n-1])%1000000007;
} 
 
int main()
{
   int n;
   cin>>n;
   cout<<fibo(n);
}
