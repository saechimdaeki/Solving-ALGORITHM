#include <iostream>
#include<cstdio>
#define N 10001
using namespace std;

bool arr[N];
int solution(int n){
	int sum=n;
	
	while(1){
		if(n==0)
		break;
		sum+=n%10;
		n=n/10;
	}
	return sum;
}

	
	int main(){
		for(int i=1;i<N;i++){
			int idx=solution(i);
			if(idx<=N){
				arr[idx]=true;
			}
		}
		for(int i=1;i<N;i++){
			if(!arr[i])
			cout<<i<<endl;
		}
		return 0;
	}

