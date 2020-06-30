#include<iostream>
 using namespace std;
int arr[10001];
int main()
{
    int n;
    int v(0);
    scanf("%d",&n);
 
    for(int i=0; i<n; i++)
    {
        scanf("%d",&v);
        arr[v]++;
    }
 
    for(int i=1; i<=10000; i++)
    {
        if(arr[i] >0)
            for(int j=0; j<arr[i]; j++)
                printf("%d\n",i);
    }
 
 
    return 0;
}



